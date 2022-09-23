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
package org.apache.camel.model.rest.springboot;

import java.util.Map;
import javax.annotation.Generated;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestConfigurationDefinition;
import org.apache.camel.model.rest.RestHostNameResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * To configure rest
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.rest")
public class RestConfigurationDefinitionProperties {

    /**
     * The Camel Rest component to use for the REST transport (consumer), such
     * as netty-http, jetty, servlet, undertow. If no component has been
     * explicit configured, then Camel will lookup if there is a Camel component
     * that integrates with the Rest DSL, or if a
     * org.apache.camel.spi.RestConsumerFactory is registered in the registry.
     * If either one is found, then that is being used.
     */
    private String component;
    /**
     * The name of the Camel component to use as the REST API. If no API
     * Component has been explicit configured, then Camel will lookup if there
     * is a Camel component responsible for servicing and generating the REST
     * API documentation, or if a org.apache.camel.spi.RestApiProcessorFactory
     * is registered in the registry. If either one is found, then that is being
     * used.
     */
    private String apiComponent;
    /**
     * Sets the name of the Camel component to use as the REST producer
     */
    private String producerComponent;
    /**
     * The scheme to use for exposing the REST service. Usually http or https is
     * supported. The default value is http
     */
    private String scheme;
    /**
     * The hostname to use for exposing the REST service.
     */
    private String host;
    /**
     * The port number to use for exposing the REST service. Notice if you use
     * servlet component then the port number configured here does not apply, as
     * the port number in use is the actual port number the servlet component is
     * using. eg if using Apache Tomcat its the tomcat http port, if using
     * Apache Karaf its the HTTP service in Karaf that uses port 8181 by default
     * etc. Though in those situations setting the port number here, allows
     * tooling and JMX to know the port number, so its recommended to set the
     * port number to the number that the servlet engine uses.
     */
    private String port;
    /**
     * To use a specific hostname for the API documentation (such as swagger or
     * openapi) This can be used to override the generated host with this
     * configured hostname
     */
    private String apiHost;
    /**
     * Whether to use X-Forward headers for Host and related setting. The
     * default value is true.
     */
    private Boolean useXForwardHeaders = true;
    /**
     * Sets the location of the api document the REST producer will use to
     * validate the REST uri and query parameters are valid accordingly to the
     * api document. The location of the api document is loaded from classpath
     * by default, but you can use file: or http: to refer to resources to load
     * from file or http url.
     */
    private String producerApiDoc;
    /**
     * Sets a leading context-path the REST services will be using. This can be
     * used when using components such as camel-servlet where the deployed web
     * application is deployed using a context-path. Or for components such as
     * camel-jetty or camel-netty-http that includes a HTTP server.
     */
    private String contextPath;
    /**
     * Sets a leading API context-path the REST API services will be using. This
     * can be used when using components such as camel-servlet where the
     * deployed web application is deployed using a context-path.
     */
    private String apiContextPath;
    /**
     * Whether vendor extension is enabled in the Rest APIs. If enabled then
     * Camel will include additional information as vendor extension (eg keys
     * starting with x-) such as route ids, class names etc. Not all 3rd party
     * API gateways and tools supports vendor-extensions when importing your API
     * docs.
     */
    private Boolean apiVendorExtension = false;
    /**
     * If no hostname has been explicit configured, then this resolver is used
     * to compute the hostname the REST service will be using.
     */
    private RestHostNameResolver hostNameResolver = RestHostNameResolver.allLocalIp;
    /**
     * Sets the binding mode to use. The default value is off
     */
    private RestBindingMode bindingMode = RestBindingMode.off;
    /**
     * Whether to skip binding on output if there is a custom HTTP error code
     * header. This allows to build custom error messages that do not bind to
     * json / xml etc, as success messages otherwise will do.
     */
    private Boolean skipBindingOnErrorCode = false;
    /**
     * Whether to enable validation of the client request to check: 1)
     * Content-Type header matches what the Rest DSL consumes; returns HTTP
     * Status 415 if validation error. 2) Accept header matches what the Rest
     * DSL produces; returns HTTP Status 406 if validation error. 3) Missing
     * required data (query parameters, HTTP headers, body); returns HTTP Status
     * 400 if validation error. 4) Parsing error of the message body (JSon, XML
     * or Auto binding mode must be enabled); returns HTTP Status 400 if
     * validation error.
     */
    private Boolean clientRequestValidation = false;
    /**
     * Whether to enable CORS headers in the HTTP response. The default value is
     * false.
     */
    private Boolean enableCors = false;
    /**
     * Inline routes in rest-dsl which are linked using direct endpoints. By
     * default, each service in Rest DSL is an individual route, meaning that
     * you would have at least two routes per service (rest-dsl, and the route
     * linked from rest-dsl). Enabling this allows Camel to optimize and inline
     * this as a single route, however this requires to use direct endpoints,
     * which must be unique per service. This option is default false.
     */
    private Boolean inlineRoutes = false;
    /**
     * Name of specific json data format to use. By default jackson will be
     * used. Important: This option is only for setting a custom name of the
     * data format, not to refer to an existing data format instance.
     */
    private String jsonDataFormat;
    /**
     * Name of specific XML data format to use. By default jaxb will be used.
     * Important: This option is only for setting a custom name of the data
     * format, not to refer to an existing data format instance.
     */
    private String xmlDataFormat;
    /**
     * Allows to configure as many additional properties for the rest component
     * in use.
     */
    private Map<String, Object> componentProperty;
    /**
     * Allows to configure as many additional properties for the rest endpoint
     * in use.
     */
    private Map<String, Object> endpointProperty;
    /**
     * Allows to configure as many additional properties for the rest consumer
     * in use.
     */
    private Map<String, Object> consumerProperty;
    /**
     * Allows to configure as many additional properties for the data formats in
     * use. For example set property prettyPrint to true to have json outputted
     * in pretty mode. The properties can be prefixed to denote the option is
     * only for either JSON or XML and for either the IN or the OUT. The
     * prefixes are: json.in. json.out. xml.in. xml.out. For example a key with
     * value xml.out.mustBeJAXBElement is only for the XML data format for the
     * outgoing. A key without a prefix is a common key for all situations.
     */
    private Map<String, Object> dataFormatProperty;
    /**
     * Allows to configure as many additional properties for the api
     * documentation. For example set property api.title to my cool stuff
     */
    private Map<String, Object> apiProperty;
    /**
     * Allows to configure custom CORS headers.
     */
    private Map<String, Object> corsHeaders;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getApiComponent() {
        return apiComponent;
    }

    public void setApiComponent(String apiComponent) {
        this.apiComponent = apiComponent;
    }

    public String getProducerComponent() {
        return producerComponent;
    }

    public void setProducerComponent(String producerComponent) {
        this.producerComponent = producerComponent;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public Boolean getUseXForwardHeaders() {
        return useXForwardHeaders;
    }

    public void setUseXForwardHeaders(Boolean useXForwardHeaders) {
        this.useXForwardHeaders = useXForwardHeaders;
    }

    public String getProducerApiDoc() {
        return producerApiDoc;
    }

    public void setProducerApiDoc(String producerApiDoc) {
        this.producerApiDoc = producerApiDoc;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getApiContextPath() {
        return apiContextPath;
    }

    public void setApiContextPath(String apiContextPath) {
        this.apiContextPath = apiContextPath;
    }

    public Boolean getApiVendorExtension() {
        return apiVendorExtension;
    }

    public void setApiVendorExtension(Boolean apiVendorExtension) {
        this.apiVendorExtension = apiVendorExtension;
    }

    public RestHostNameResolver getHostNameResolver() {
        return hostNameResolver;
    }

    public void setHostNameResolver(RestHostNameResolver hostNameResolver) {
        this.hostNameResolver = hostNameResolver;
    }

    public RestBindingMode getBindingMode() {
        return bindingMode;
    }

    public void setBindingMode(RestBindingMode bindingMode) {
        this.bindingMode = bindingMode;
    }

    public Boolean getSkipBindingOnErrorCode() {
        return skipBindingOnErrorCode;
    }

    public void setSkipBindingOnErrorCode(Boolean skipBindingOnErrorCode) {
        this.skipBindingOnErrorCode = skipBindingOnErrorCode;
    }

    public Boolean getClientRequestValidation() {
        return clientRequestValidation;
    }

    public void setClientRequestValidation(Boolean clientRequestValidation) {
        this.clientRequestValidation = clientRequestValidation;
    }

    public Boolean getEnableCors() {
        return enableCors;
    }

    public void setEnableCors(Boolean enableCors) {
        this.enableCors = enableCors;
    }

    public Boolean getInlineRoutes() {
        return inlineRoutes;
    }

    public void setInlineRoutes(Boolean inlineRoutes) {
        this.inlineRoutes = inlineRoutes;
    }

    public String getJsonDataFormat() {
        return jsonDataFormat;
    }

    public void setJsonDataFormat(String jsonDataFormat) {
        this.jsonDataFormat = jsonDataFormat;
    }

    public String getXmlDataFormat() {
        return xmlDataFormat;
    }

    public void setXmlDataFormat(String xmlDataFormat) {
        this.xmlDataFormat = xmlDataFormat;
    }

    public Map<String, Object> getComponentProperty() {
        return componentProperty;
    }

    public void setComponentProperty(Map<String, Object> componentProperty) {
        this.componentProperty = componentProperty;
    }

    public Map<String, Object> getEndpointProperty() {
        return endpointProperty;
    }

    public void setEndpointProperty(Map<String, Object> endpointProperty) {
        this.endpointProperty = endpointProperty;
    }

    public Map<String, Object> getConsumerProperty() {
        return consumerProperty;
    }

    public void setConsumerProperty(Map<String, Object> consumerProperty) {
        this.consumerProperty = consumerProperty;
    }

    public Map<String, Object> getDataFormatProperty() {
        return dataFormatProperty;
    }

    public void setDataFormatProperty(Map<String, Object> dataFormatProperty) {
        this.dataFormatProperty = dataFormatProperty;
    }

    public Map<String, Object> getApiProperty() {
        return apiProperty;
    }

    public void setApiProperty(Map<String, Object> apiProperty) {
        this.apiProperty = apiProperty;
    }

    public Map<String, Object> getCorsHeaders() {
        return corsHeaders;
    }

    public void setCorsHeaders(Map<String, Object> corsHeaders) {
        this.corsHeaders = corsHeaders;
    }
}