package com.nsc.tsui.service.impl;

import com.nsc.tsui.service.TSUIRequestBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Component
public class DefaultTSUIRequestBuilder implements TSUIRequestBuilder{

    public static final Logger logger = LoggerFactory.getLogger(DefaultTSUIService.class);

    @Value("${nsc.base.url}")
    private String baseUrl;

    @Override
    public HttpGet buildGet(String endpointLocation) {
        StringBuilder sb = new StringBuilder(baseUrl);
        if(!endpointLocation.startsWith("/")){
            sb.append("/");
        }
        sb.append(endpointLocation);
        logger.debug("url built for get request | {}" , sb.toString());
        HttpGet httpGet = new HttpGet(sb.toString());
        return httpGet;
    }

    @Override
    public HttpPost buildPost(String endpointLocation, HttpEntity httpEntity) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(baseUrl);
        if(!endpointLocation.startsWith("/")){
            sb.append("/");
        }
        sb.append(endpointLocation);
        logger.debug("url built for get request | {}" , sb.toString());
        HttpPost httpPost = new HttpPost(sb.toString());

        httpPost.setEntity(httpEntity);
        return httpPost;
    }

    @Override
    public HttpPost buildPost(String endpointLocation, byte[] httpEntity) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(baseUrl);
        if(!endpointLocation.startsWith("/")){
            sb.append("/");
        }
        sb.append(endpointLocation);
        logger.debug("url built for get request | {}" , sb.toString());
        HttpPost httpPost = new HttpPost(sb.toString());

        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("file", httpEntity)
                .build();

        httpPost.setEntity(entity);
        return httpPost;
    }
}
