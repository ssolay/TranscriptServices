package com.nsc.tsui.service;

import org.apache.http.client.methods.HttpRequestBase;

public interface TSUIService {
    public String callWebService(HttpRequestBase httpRequestBase);

    public String postFile(HttpRequestBase httpRequestBase);

}
