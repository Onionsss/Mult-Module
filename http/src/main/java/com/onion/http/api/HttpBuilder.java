package com.onion.http.api;

import android.app.Application;

import com.google.gson.Gson;

import okhttp3.Cache;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by OnionMac on 2018/3/5.
 *
 * Http建造者
 */

public class HttpBuilder {

    public static final Gson sGson = new Gson();

    public static Gson getGson(){
        return sGson;
    }

    /**
     * 构建缓存
     * @param application
     * @return
     */
    public static Cache getCache(Application application){
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    public static HttpLoggingInterceptor getHttplogger() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
