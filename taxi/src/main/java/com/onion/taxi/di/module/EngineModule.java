package com.onion.taxi.di.module;

import com.onion.taxi.engine.splash.SplashContract;
import com.onion.taxi.engine.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by OnionMac on 2018/3/9.
 */

@Module
public class EngineModule {

    @Provides
    public SplashContract.Presenter providesSplash(SplashPresenter splashPresenter){
        return splashPresenter;
    }

}
