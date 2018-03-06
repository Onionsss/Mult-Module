package com.onion.base.di.module;

import android.app.Application;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onion.base.HttpData;
import com.onion.base.center.AppCenter;
import com.onion.http.HttpRepository;
import com.onion.http.api.HttpBuilder;
import com.onion.util.AssetUtil;
import com.onion.util.logger.Logger;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangqi on 2017/12/20.
 * e-mail : ${email}
 * desc : HttpModule层  统一由HttpBuilder负责构建对象
 */
@Module
public class HttpModule {


    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        return HttpBuilder.getCache(application);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return HttpBuilder.getGson();
    }

    /**
     * 建造Httplogger
     */
    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLogger(){
        return HttpBuilder.getHttplogger();
    }

    @Provides
    @Singleton
    HttpRepository provideHttpRepository(HttpLoggingInterceptor logging,Gson gson,AppCenter appCenter){
        HttpRepository httpRepository = new HttpRepository();

        String json = AssetUtil.getJson(appCenter, "http.json");
        Logger.json(json);
        Type type = new TypeToken<List<HttpData>>() {
        }.getType();

        List<HttpData> list = gson.fromJson(json, type);
        Map<String, Retrofit> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            HttpData httpData = list.get(i);

            OkHttpClient okHttpClient = buildOkhttp(httpData,logging);

            Retrofit retrofit = buildRetrofit(httpData,okHttpClient);

            map.put(httpData.getModuleName(),retrofit);

        }
        httpRepository.setRepository(map);
        return httpRepository;
    }

    private Retrofit buildRetrofit(HttpData httpData,OkHttpClient okHttpClient) {

        Retrofit.Builder builder = new Retrofit.Builder();

        builder.client(okHttpClient);
        builder.baseUrl(httpData.getBaseUrl());

        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        builder.addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    private OkHttpClient buildOkhttp(HttpData httpData, HttpLoggingInterceptor logging) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(httpData.getConnectTimeout(), TimeUnit.SECONDS)
                .readTimeout(httpData.getReadTimeout(),TimeUnit.SECONDS)
                .writeTimeout(httpData.getWriteTimeout(),TimeUnit.SECONDS);
        /**
         * 增加默认拦截器
         */
        builder.addNetworkInterceptor(logging);
        String interceptor = httpData.getInterceptor();
        if(!TextUtils.isEmpty(interceptor)){
            String[] interceptors = interceptor.split(",");

            for (int i = 0; i < interceptors.length; i++) {
                String interceptor_ = interceptors[i];

                try {
                    Class<?> aClass = Class.forName(interceptor_);
                    Object o = aClass.newInstance();
                    if(o instanceof Interceptor){
                        builder.addInterceptor((Interceptor) o);
                    }
                } catch (Exception e) {

                }

            }
            
        }
        return builder.build();
    }

}
