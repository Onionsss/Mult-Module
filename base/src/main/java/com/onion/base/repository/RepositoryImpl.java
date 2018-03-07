package com.onion.base.repository;

import com.onion.http.HttpRepository;

import retrofit2.Retrofit;

/**
 * Created by OnionMac on 2018/3/7.
 */

public abstract class RepositoryImpl<A> implements IRepository<A>{

    protected A mApi;

    protected HttpRepository mHttpRepository;

    public RepositoryImpl(HttpRepository httpRepository){
        mHttpRepository = httpRepository;

        mApi = (A) getApiFromModuleName(getModuleName());
    }

    @Override
    public HttpRepository getHttpRepository() {
        return mHttpRepository;
    }

    @Override
    public Retrofit getModuleRetrofit(String moduleName) {
        return mHttpRepository.getRepository(moduleName);
    }

}
