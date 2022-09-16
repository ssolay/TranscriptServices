package com.nsc.tsui.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.UnsupportedEncodingException;

public interface TSUIRequestBuilder {

    HttpGet buildGet(String endpointLocation);

    HttpPost buildPost(String endpointLocation, HttpEntity httpEntity) throws UnsupportedEncodingException;

    HttpPost buildPost(String endpointLocation, byte[] httpEntity) throws UnsupportedEncodingException;
}
