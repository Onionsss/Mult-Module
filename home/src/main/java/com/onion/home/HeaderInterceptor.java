package com.onion.home;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangqi on 2017/12/22.
 * e-mail : ${email}
 * desc :
 *
 * header参数的封装
 */

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("version", "1.0.0")
                .build();
        return chain.proceed(request);
    }
}
