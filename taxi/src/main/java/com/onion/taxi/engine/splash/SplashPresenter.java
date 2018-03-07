package com.onion.taxi.engine.splash;

import com.google.gson.Gson;
import com.onion.base.mvp.impl.RxPresenter;
import com.onion.base.rxjava.Result;
import com.onion.base.rxjava.T;
import com.onion.pojo.City;
import com.onion.base.repository.impl.TaxiRepositoryImpl;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by OnionMac on 2018/3/6.
 */

public class SplashPresenter extends RxPresenter<SplashContract.View,TaxiRepositoryImpl> implements SplashContract.Presenter{

    @Inject
    SplashPresenter(CompositeDisposable compositeDisposable,TaxiRepositoryImpl taxiRepository) {
        super(compositeDisposable,taxiRepository);
    }

    @Override
    public void getCode() {
        addSubscribe(mRepository.getCity()
                .compose(T.D())
                .subscribeWith(new Result<City>() {
                    @Override
                    protected void onSuccess(City city) {
                        mView.getCodeSuccess(new Gson().toJson(city));
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                    }
                }));
    }
}
