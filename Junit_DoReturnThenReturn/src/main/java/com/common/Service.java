package com.common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Service {
    private final RequestUtil httpRequestUtil;

    public String requestHttp(String URL, String param) {
        httpRequestUtil.connection(URL);
        return httpRequestUtil.getRequest(param);
    }
}
