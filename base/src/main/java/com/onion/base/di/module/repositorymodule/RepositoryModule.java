package com.onion.base.di.module.repositorymodule;

import com.onion.base.api.TaxiApi;
import com.onion.base.repository.impl.TaxiRepositoryImpl;
import com.onion.http.HttpRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by OnionMac on 2018/3/7.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public TaxiRepositoryImpl providesTaxiRepositoryImpl(HttpRepository httpRepository){
        return new TaxiRepositoryImpl(httpRepository);
    }

    @Singleton
    @Provides
    public TaxiApi providesTaxiApi(TaxiRepositoryImpl taxiRepository){
        return taxiRepository.getApi();
    }

}
