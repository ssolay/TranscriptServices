package com.nsc.tsui.service.impl;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.nsc.tsui.service.TSUIService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Component
public class DefaultTSUIService implements TSUIService{

    public static Logger logger = LoggerFactory.getLogger(DefaultTSUIService.class);

    @Autowired
    CloseableHttpClient closeableHttpClient;

    @Value("${nsc.api.key}")
    private String apiKey;

    @Metered(name = "calling-ws-metered")
    @Timed(name = "calling-ws-timed")
    @Override
    public String callWebService(HttpRequestBase httpRequestBase) {
        logger.debug("Executing request " + httpRequestBase.getRequestLine());
        httpRequestBase.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpRequestBase.setHeader(HttpHeaders.ACCEPT, "application/json");
        httpRequestBase.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + apiKey);
        // Create a custom response handler
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                logger.warn("Unexpected response status: " + status);
                return EntityUtils.toString(response.getEntity());
            }
        };
        String responseBody = null;
        try {
            responseBody = closeableHttpClient.execute(httpRequestBase, responseHandler);
        } catch (IOException e) {
            logger.error("something bad happened ", e);
        }
        logger.debug("----------------------------------------");
        logger.debug(responseBody);
        return responseBody;
    }

    @Override
    public String postFile(HttpRequestBase httpRequestBase) {
        logger.debug("Executing request " + httpRequestBase.getRequestLine());
        httpRequestBase.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA);
        httpRequestBase.setHeader(HttpHeaders.ACCEPT, "application/json");
        httpRequestBase.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + apiKey);

        // Create a custom response handler
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                logger.warn("Unexpected response status: " + status);
                return EntityUtils.toString(response.getEntity());
            }
        };
        String responseBody = null;
        try {
            responseBody = closeableHttpClient.execute(httpRequestBase, responseHandler);
        } catch (IOException e) {
            logger.error("something bad happened ", e);
        }
        logger.debug("----------------------------------------");
        logger.debug(responseBody);
        return responseBody;
    }

}
