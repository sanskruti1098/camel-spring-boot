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
package org.apache.camel.component.jgroups.raft.springboot.cluster.springboot;

import org.apache.camel.cluster.CamelClusterService;
import org.apache.camel.component.jgroups.raft.cluster.JGroupsRaftClusterService;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.spring.boot.cluster.ClusteredRouteControllerAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore({ ClusteredRouteControllerAutoConfiguration.class, CamelAutoConfiguration.class })
@ConditionalOnProperty(prefix = "camel.cluster.jgroups-raft", name = "enabled")
@EnableConfigurationProperties(JGroupsRaftClusterServiceConfiguration.class)
public class JGroupsRaftClusterServiceAutoConfiguration {

    @Autowired
    private JGroupsRaftClusterServiceConfiguration configuration;

    @Bean(name = "jgroups-raft-cluster-service")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CamelClusterService jgroupsRaftClusterService() throws Exception {
        JGroupsRaftClusterService service = new JGroupsRaftClusterService();

        Optional.ofNullable(configuration.getId())
                .ifPresent(service::setId);
        Optional.ofNullable(configuration.getRaftId())
                .ifPresent(service::setRaftId);
        Optional.ofNullable(configuration.getJgroupsRaftClusterName())
                .ifPresent(service::setJgroupsClusterName);
        Optional.ofNullable(configuration.getJgroupsRaftConfig())
                .ifPresent(service::setJgroupsConfig);

        return service;
    }
}
