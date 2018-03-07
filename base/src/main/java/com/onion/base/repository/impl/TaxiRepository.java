package com.onion.base.repository.impl;

import com.onion.base.api.TaxiApi;
import com.onion.base.repository.RepositoryImpl;
import com.onion.http.HttpRepository;

/**
 * Created by OnionMac on 2018/3/7.
 * Taxi仓库
 */

public abstract class TaxiRepository extends RepositoryImpl<TaxiApi> {

    private static final String moduleName = "taxi";

    public TaxiRepository(HttpRepository httpRepository) {
        super(httpRepository);
    }

    @Override
    public String getModuleName() {
        return moduleName;
    }

    @Override
    public TaxiApi getApi() {
        return mApi;
    }

    @Override
    public TaxiApi getApiFromModuleName(String moduleName) {
        return mHttpRepository.getRepository(moduleName).create(TaxiApi.class);
    }

}
