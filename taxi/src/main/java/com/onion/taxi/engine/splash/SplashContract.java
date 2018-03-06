package com.onion.taxi.engine.splash;

import com.onion.base.mvp.IBasePresenter;
import com.onion.base.mvp.IBaseView;

/**
 * Created by OnionMac on 2018/3/6.
 */

public interface SplashContract {

    interface View extends IBaseView{
        void getCodeSuccess(String code);
    }

    interface Presenter extends IBasePresenter<SplashContract.View>{

        void getCode();

    }

}
