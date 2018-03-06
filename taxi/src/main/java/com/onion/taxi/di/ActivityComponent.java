package com.onion.taxi.di;

import com.onion.base.center.AppCenter;
import com.onion.base.di.component.AppComponent;
import com.onion.base.di.module.ActivityModule;
import com.onion.base.di.scope.ActivityScope;
import com.onion.taxi.engine.Test;
import com.onion.taxi.engine.splash.SplashActivity;

import dagger.Component;

/**
 * Created by zhangqi on 16/8/7.
 * activity 管理层
 *
 * 注入app组件  ActivityModule
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public abstract class ActivityComponent {

    private static ActivityComponent sComponent;

    public static ActivityComponent getInstance(){
        if (sComponent == null){
            sComponent = DaggerActivityComponent
                    .builder()
                    .appComponent(AppCenter.getAppComponent())
                    .build();
        }
        return sComponent;
    }

    public abstract void inject(SplashActivity homeActivity);

    public abstract void inject(Test test);
}
