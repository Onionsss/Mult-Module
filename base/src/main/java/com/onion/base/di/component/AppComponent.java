package com.onion.base.di.component;

import com.google.gson.Gson;
import com.onion.base.center.AppCenter;
import com.onion.base.di.module.AppModule;
import com.onion.base.di.module.HttpModule;
import com.onion.base.di.module.RxModule;
import com.onion.http.HttpRepository;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by zhangqi on 2017/12/20.
 * e-mail : ${email}
 * desc :
 *
 * App组件层  自动注入
 * AppModule  app层
 * HttpModule 网络层
 * DataModule 数据层
 * RxModule  rxjava层
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class, RxModule.class})
public interface AppComponent {

    AppCenter getContext();

    Gson getGson();

    HttpRepository getHttpRepository();

    CompositeDisposable getCompositedisposable();
}
