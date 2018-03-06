package com.onion.base;

/**
 * Created by OnionMac on 2018/3/5.
 */

public class HttpData {

    private String moduleName;
    private String baseUrl;
    private String interceptor;
    private String netInterceptor;
    private int connectTimeout;
    private int readTimeout;
    private int writeTimeout;

    public String getNetInterceptor() {
        return netInterceptor;
    }

    public void setNetInterceptor(String netInterceptor) {
        this.netInterceptor = netInterceptor;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(String interceptor) {
        this.interceptor = interceptor;
    }
}
