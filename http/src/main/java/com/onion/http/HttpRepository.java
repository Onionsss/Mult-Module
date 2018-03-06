package com.onion.http;

import java.util.Map;

import retrofit2.Retrofit;

/**
 * Created by OnionMac on 2018/3/5.
 */

public class HttpRepository {

    private Map<String,Retrofit> mRetrofitList;

    public void setRepository(Map<String,Retrofit> repository){
        mRetrofitList = repository;
    }

    public Retrofit getRepository(String moduleName){
        return mRetrofitList.get(moduleName);
    }
}
