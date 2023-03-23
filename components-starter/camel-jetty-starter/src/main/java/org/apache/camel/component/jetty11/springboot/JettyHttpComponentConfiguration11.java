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
package org.apache.camel.component.jetty11.springboot;

import java.util.Map;
import org.apache.camel.http.common.HttpBinding;
import org.apache.camel.http.common.HttpConfiguration;
import org.apache.camel.spi.HeaderFilterStrategy;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Expose HTTP endpoints using Jetty 11.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.jetty")
public class JettyHttpComponentConfiguration11
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the jetty component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Allows for bridging the consumer to the Camel routing Error Handler,
     * which mean any exceptions occurred while the consumer is trying to pickup
     * incoming messages, or the likes, will now be processed as a message and
     * handled by the routing Error Handler. By default the consumer will use
     * the org.apache.camel.spi.ExceptionHandler to deal with exceptions, that
     * will be logged at WARN or ERROR level and ignored.
     */
    private Boolean bridgeErrorHandler = false;
    /**
     * Allows to set a timeout in millis when using Jetty as consumer (server).
     * By default Jetty uses 30000. You can use a value of = 0 to never expire.
     * If a timeout occurs then the request will be expired and Jetty will
     * return back a http error 503 to the client. This option is only in use
     * when using Jetty with the Asynchronous Routing Engine.
     */
    private Long continuationTimeout = 30000L;
    /**
     * If this option is true, Jetty JMX support will be enabled for this
     * endpoint.
     */
    private Boolean enableJmx = false;
    /**
     * To set a value for maximum number of threads in server thread pool.
     * Notice that both a min and max size must be configured.
     */
    private Integer maxThreads;
    /**
     * To set a value for minimum number of threads in server thread pool.
     * Notice that both a min and max size must be configured.
     */
    private Integer minThreads;
    /**
     * If enabled and an Exchange failed processing on the consumer side the
     * response's body won't contain the exception's stack trace.
     */
    private Boolean muteException = false;
    /**
     * Allows to configure a custom value of the request buffer size on the
     * Jetty connectors.
     */
    private Integer requestBufferSize;
    /**
     * Allows to configure a custom value of the request header size on the
     * Jetty connectors.
     */
    private Integer requestHeaderSize;
    /**
     * Allows to configure a custom value of the response buffer size on the
     * Jetty connectors.
     */
    private Integer responseBufferSize;
    /**
     * Allows to configure a custom value of the response header size on the
     * Jetty connectors.
     */
    private Integer responseHeaderSize;
    /**
     * If the option is true, jetty will send the server header with the jetty
     * version information to the client which sends the request. NOTE please
     * make sure there is no any other camel-jetty endpoint is share the same
     * port, otherwise this option may not work as expected.
     */
    private Boolean sendServerVersion = true;
    /**
     * Whether or not to use Jetty continuations for the Jetty Server.
     */
    private Boolean useContinuation = true;
    /**
     * To use the X-Forwarded-For header in HttpServletRequest.getRemoteAddr.
     */
    private Boolean useXForwardedForHeader = false;
    /**
     * To use a custom thread pool for the server. This option should only be
     * used in special circumstances. The option is a
     * org.eclipse.jetty.util.thread.ThreadPool type.
     */
    private ThreadPool threadPool;
    /**
     * Whether to allow java serialization when a request uses
     * context-type=application/x-java-serialized-object. This is by default
     * turned off. If you enable this then be aware that Java will deserialize
     * the incoming data from the request to Java and that can be a potential
     * security risk.
     */
    private Boolean allowJavaSerializedObject = false;
    /**
     * Whether autowiring is enabled. This is used for automatic autowiring
     * options (the option must be marked as autowired) by looking up in the
     * registry to find if there is a single instance of matching type, which
     * then gets configured on the component. This can be used for automatic
     * configuring JDBC data sources, JMS connection factories, AWS Clients,
     * etc.
     */
    private Boolean autowiredEnabled = true;
    /**
     * This option is used to set the ErrorHandler that Jetty server uses. The
     * option is a org.eclipse.jetty.server.handler.ErrorHandler type.
     */
    private ErrorHandler errorHandler;
    /**
     * Not to be used - use JettyHttpBinding instead. The option is a
     * org.apache.camel.http.common.HttpBinding type.
     */
    private HttpBinding httpBinding;
    /**
     * Jetty component does not use HttpConfiguration. The option is a
     * org.apache.camel.http.common.HttpConfiguration type.
     */
    private HttpConfiguration httpConfiguration;
    /**
     * To use a existing configured org.eclipse.jetty.jmx.MBeanContainer if JMX
     * is enabled that Jetty uses for registering mbeans. The option is a
     * org.eclipse.jetty.jmx.MBeanContainer type.
     */
    private MBeanContainer mbContainer;
    /**
     * To use a custom org.apache.camel.spi.HeaderFilterStrategy to filter
     * header to and from Camel message. The option is a
     * org.apache.camel.spi.HeaderFilterStrategy type.
     */
    private HeaderFilterStrategy headerFilterStrategy;
    /**
     * To use a http proxy to configure the hostname.
     */
    private String proxyHost;
    /**
     * To use a http proxy to configure the port number.
     */
    private Integer proxyPort;
    /**
     * Specifies the location of the Java keystore file, which contains the
     * Jetty server's own X.509 certificate in a key entry.
     */
    private String keystore;
    /**
     * A map which contains general HTTP connector properties. Uses the same
     * principle as sslSocketConnectorProperties.
     */
    private Map<String, Object> socketConnectorProperties;
    /**
     * A map which contains per port number specific HTTP connectors. Uses the
     * same principle as sslSocketConnectors.
     */
    private Map<Integer, Connector> socketConnectors;
    /**
     * To configure security using SSLContextParameters. The option is a
     * org.apache.camel.support.jsse.SSLContextParameters type.
     */
    private SSLContextParameters sslContextParameters;
    /**
     * The key password, which is used to access the certificate's key entry in
     * the keystore (this is the same password that is supplied to the keystore
     * command's -keypass option).
     */
    private String sslKeyPassword;
    /**
     * The ssl password, which is required to access the keystore file (this is
     * the same password that is supplied to the keystore command's -storepass
     * option).
     */
    private String sslPassword;
    /**
     * A map which contains general SSL connector properties.
     */
    private Map<String, Object> sslSocketConnectorProperties;
    /**
     * A map which contains per port number specific SSL connectors.
     */
    private Map<Integer, Connector> sslSocketConnectors;
    /**
     * Enable usage of global SSL context parameters
     */
    private Boolean useGlobalSslContextParameters = false;

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Long getContinuationTimeout() {
        return continuationTimeout;
    }

    public void setContinuationTimeout(Long continuationTimeout) {
        this.continuationTimeout = continuationTimeout;
    }

    public Boolean getEnableJmx() {
        return enableJmx;
    }

    public void setEnableJmx(Boolean enableJmx) {
        this.enableJmx = enableJmx;
    }

    public Integer getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(Integer maxThreads) {
        this.maxThreads = maxThreads;
    }

    public Integer getMinThreads() {
        return minThreads;
    }

    public void setMinThreads(Integer minThreads) {
        this.minThreads = minThreads;
    }

    public Boolean getMuteException() {
        return muteException;
    }

    public void setMuteException(Boolean muteException) {
        this.muteException = muteException;
    }

    public Integer getRequestBufferSize() {
        return requestBufferSize;
    }

    public void setRequestBufferSize(Integer requestBufferSize) {
        this.requestBufferSize = requestBufferSize;
    }

    public Integer getRequestHeaderSize() {
        return requestHeaderSize;
    }

    public void setRequestHeaderSize(Integer requestHeaderSize) {
        this.requestHeaderSize = requestHeaderSize;
    }

    public Integer getResponseBufferSize() {
        return responseBufferSize;
    }

    public void setResponseBufferSize(Integer responseBufferSize) {
        this.responseBufferSize = responseBufferSize;
    }

    public Integer getResponseHeaderSize() {
        return responseHeaderSize;
    }

    public void setResponseHeaderSize(Integer responseHeaderSize) {
        this.responseHeaderSize = responseHeaderSize;
    }

    public Boolean getSendServerVersion() {
        return sendServerVersion;
    }

    public void setSendServerVersion(Boolean sendServerVersion) {
        this.sendServerVersion = sendServerVersion;
    }

    public Boolean getUseContinuation() {
        return useContinuation;
    }

    public void setUseContinuation(Boolean useContinuation) {
        this.useContinuation = useContinuation;
    }

    public Boolean getUseXForwardedForHeader() {
        return useXForwardedForHeader;
    }

    public void setUseXForwardedForHeader(Boolean useXForwardedForHeader) {
        this.useXForwardedForHeader = useXForwardedForHeader;
    }

    public ThreadPool getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public Boolean getAllowJavaSerializedObject() {
        return allowJavaSerializedObject;
    }

    public void setAllowJavaSerializedObject(Boolean allowJavaSerializedObject) {
        this.allowJavaSerializedObject = allowJavaSerializedObject;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public HttpBinding getHttpBinding() {
        return httpBinding;
    }

    public void setHttpBinding(HttpBinding httpBinding) {
        this.httpBinding = httpBinding;
    }

    public HttpConfiguration getHttpConfiguration() {
        return httpConfiguration;
    }

    public void setHttpConfiguration(HttpConfiguration httpConfiguration) {
        this.httpConfiguration = httpConfiguration;
    }

    public MBeanContainer getMbContainer() {
        return mbContainer;
    }

    public void setMbContainer(MBeanContainer mbContainer) {
        this.mbContainer = mbContainer;
    }

    public HeaderFilterStrategy getHeaderFilterStrategy() {
        return headerFilterStrategy;
    }

    public void setHeaderFilterStrategy(
            HeaderFilterStrategy headerFilterStrategy) {
        this.headerFilterStrategy = headerFilterStrategy;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getKeystore() {
        return keystore;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
    }

    public Map<String, Object> getSocketConnectorProperties() {
        return socketConnectorProperties;
    }

    public void setSocketConnectorProperties(
            Map<String, Object> socketConnectorProperties) {
        this.socketConnectorProperties = socketConnectorProperties;
    }

    public Map<Integer, Connector> getSocketConnectors() {
        return socketConnectors;
    }

    public void setSocketConnectors(Map<Integer, Connector> socketConnectors) {
        this.socketConnectors = socketConnectors;
    }

    public SSLContextParameters getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(
            SSLContextParameters sslContextParameters) {
        this.sslContextParameters = sslContextParameters;
    }

    public String getSslKeyPassword() {
        return sslKeyPassword;
    }

    public void setSslKeyPassword(String sslKeyPassword) {
        this.sslKeyPassword = sslKeyPassword;
    }

    public String getSslPassword() {
        return sslPassword;
    }

    public void setSslPassword(String sslPassword) {
        this.sslPassword = sslPassword;
    }

    public Map<String, Object> getSslSocketConnectorProperties() {
        return sslSocketConnectorProperties;
    }

    public void setSslSocketConnectorProperties(
            Map<String, Object> sslSocketConnectorProperties) {
        this.sslSocketConnectorProperties = sslSocketConnectorProperties;
    }

    public Map<Integer, Connector> getSslSocketConnectors() {
        return sslSocketConnectors;
    }

    public void setSslSocketConnectors(
            Map<Integer, Connector> sslSocketConnectors) {
        this.sslSocketConnectors = sslSocketConnectors;
    }

    public Boolean getUseGlobalSslContextParameters() {
        return useGlobalSslContextParameters;
    }

    public void setUseGlobalSslContextParameters(
            Boolean useGlobalSslContextParameters) {
        this.useGlobalSslContextParameters = useGlobalSslContextParameters;
    }
}