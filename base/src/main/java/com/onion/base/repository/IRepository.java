package com.onion.base.repository;

import com.onion.http.HttpRepository;

import retrofit2.Retrofit;

/**
 * Created by OnionMac on 2018/3/7.
 *
 * 仓库的接口规范
 */

public interface IRepository<A> {

    String getModuleName();

    A getApi();

    A getApiFromModuleName(String moduleName);

    HttpRepository getHttpRepository();

    Retrofit getModuleRetrofit(String moduleName);
}
