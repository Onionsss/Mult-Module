package com.onion.base.di.module;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by OnionMac on 2018/3/6.
 */
@Module
public class RxModule {

    @Provides
    public CompositeDisposable providesCom(){
        return new CompositeDisposable();
    }

}
