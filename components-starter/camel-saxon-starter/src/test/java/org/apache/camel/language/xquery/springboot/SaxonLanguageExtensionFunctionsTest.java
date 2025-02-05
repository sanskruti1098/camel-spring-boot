/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.language.xquery.springboot;

import net.sf.saxon.Configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.language.xquery.XQueryLanguage;
import org.apache.camel.spring.boot.CamelAutoConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;

import org.junit.jupiter.api.Test;


import org.apache.camel.test.spring.junit5.CamelSpringBootTest;


@DirtiesContext
@CamelSpringBootTest
@SpringBootTest(
    classes = {
        CamelAutoConfiguration.class,
        SaxonLanguageExtensionFunctionsTest.class,
        SaxonLanguageExtensionFunctionsTest.TestConfiguration.class
    }
)
public class SaxonLanguageExtensionFunctionsTest {
    
    
    @Autowired
    ProducerTemplate template;
    
    @Autowired
    CamelContext context;

    @EndpointInject("mock:result")
    protected MockEndpoint mock;   
    
    @Test
    public void testWithExtension() throws Exception {
        mock.expectedBodiesReceived("<transformed extension-function-render=\"arg1[test]\"/>");

        template.sendBody("direct:start", "<body>test</body>");

        mock.assertIsSatisfied();
    }   

    
    // *************************************
    // Config
    // *************************************

    @org.springframework.context.annotation.Configuration
    public class TestConfiguration {

        @Bean
        public RouteBuilder routeBuilder() {
            return new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    Configuration conf = new Configuration();
                    conf.registerExtensionFunction(new XQueryWithExtensionTest.SimpleExtension());

                    XQueryLanguage xq = (XQueryLanguage) context.resolveLanguage("xquery");
                    xq.setConfiguration(conf);

                    from("direct:start")
                            .transform()
                            .xquery("resource:classpath:org/apache/camel/component/xquery/transformWithExtension.xquery")
                            .to("mock:result");
                }
            };
        }
    }
}
