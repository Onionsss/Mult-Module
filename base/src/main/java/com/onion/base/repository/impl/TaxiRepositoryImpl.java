package com.onion.base.repository.impl;

import com.onion.base.api.TaxiApi;
import com.onion.http.HttpRepository;
import com.onion.pojo.City;

import io.reactivex.Flowable;

/**
 * Created by OnionMac on 2018/3/7.
 * taxi仓库的实现 可实现网络请求类
 */

public class TaxiRepositoryImpl extends TaxiRepository implements TaxiApi {

    public TaxiRepositoryImpl(HttpRepository httpRepository) {
        super(httpRepository);
    }

    @Override
    public Flowable<City> getCity() {
        return mApi.getCity();
    }
}
