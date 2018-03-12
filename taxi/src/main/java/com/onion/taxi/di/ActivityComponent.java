package com.onion.taxi.di;

import android.app.Activity;

import com.onion.base.di.component.AppComponent;
import com.onion.base.di.module.ActivityModule;
import com.onion.base.di.scope.ActivityScope;
import com.onion.taxi.di.module.EngineModule;
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
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, EngineModule.class})
public interface ActivityComponent {

    Activity getActivity();

    void inject(SplashActivity homeActivity);

    void inject(Test test);
}
