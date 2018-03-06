package com.onion.home.api;

import com.onion.home.bean.City;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by OnionMac on 2018/3/5.
 */

public interface HomeApi {


    @POST("loan/getCity.action")
    Call<City> getCity();

}
