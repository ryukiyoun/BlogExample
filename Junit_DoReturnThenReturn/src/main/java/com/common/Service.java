package com.common;

public class Service {
    RequestUtil httpRequestUtil;

    public String requestHttp(String URL, String param) {
        httpRequestUtil.Connection(URL);
        return httpRequestUtil.GetRequest(param);
    }
}
