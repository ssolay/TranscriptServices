package com.nsc.tsui.config;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class HttpClientConfig {

    public static final Logger logger = LoggerFactory.getLogger(HttpClientConfig.class);

    @Value("${http.client.pool.size.max}")
    private Integer httpClientPoolSizeMax;

    @Value("${http.client.pool.max.per.route}")
    private Integer httpClientPoolMaxPerRoute;

    @Value("${allow.self.signed.certs}")
    private Boolean allowSelfSignedCerts;

    @Bean
    public PoolingHttpClientConnectionManager getPoolingConnectionManager() {
        PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
        poolingConnectionManager.setMaxTotal(httpClientPoolSizeMax);
        poolingConnectionManager.setDefaultMaxPerRoute(httpClientPoolMaxPerRoute);

        return poolingConnectionManager;
    }

    @Bean
    public CloseableHttpClient httpClient(){
        SSLContextBuilder builder = new SSLContextBuilder();
        SSLConnectionSocketFactory sslsf = null;
        try {
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            sslsf = new SSLConnectionSocketFactory(
                    builder.build());
        } catch (NoSuchAlgorithmException e) {
            logger.error("http Client Build  exception NoSuchAlgorithmException" , e);
        } catch (KeyManagementException e) {
            logger.error("http Client Build  exception KeyManagementException" , e);
        } catch (KeyStoreException e) {
            logger.error("http Client Build  exception KeyStoreException" , e);
        }
        HttpClientBuilder clientBuilder = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(getPoolingConnectionManager());
        if(allowSelfSignedCerts){
            clientBuilder.setSSLSocketFactory(sslsf);
        }
        return clientBuilder.build();
    }
}
