package com.onion.base.api;


import com.onion.pojo.City;

import io.reactivex.Flowable;
import retrofit2.http.POST;

/**
 * Created by OnionMac on 2018/3/7.
 */

public interface TaxiApi {

    /**
     * 得到城市
     * @return
     */
    @POST("loan/getCity.action")
    Flowable<City> getCity();
}
