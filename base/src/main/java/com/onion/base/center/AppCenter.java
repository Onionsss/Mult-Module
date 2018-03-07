package com.onion.base.center;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.onion.base.di.component.AppComponent;
import com.onion.base.di.component.DaggerAppComponent;
import com.onion.base.di.module.AppModule;
import com.onion.base.di.module.HttpModule;
import com.onion.base.di.module.RxModule;
import com.onion.base.di.module.repositorymodule.RepositoryModule;
import com.onion.util.logger.MyLogger;

import java.util.LinkedList;

/**
 * Created by OnionMac on 2018/2/28.
 */

public class AppCenter extends MultiDexApplication {

    public static AppCenter mInstance;

    private static AppComponent appComponent;

    private static LinkedList<Activity> mActivities = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        if (true) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        MyLogger.init("MULT",true);

        mInstance = this;
        getAppComponent();
    }

    /**
     * dagger2组件初始化
     * @return
     */
    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mInstance))
                    .httpModule(new HttpModule())
                    .rxModule(new RxModule())
                    .repositoryModule(new RepositoryModule())
                    .build();
        }
        return appComponent;
    }


    public static boolean addActivity(Activity activity){
        mActivities.addFirst(activity);
        return true;
    }

    public static boolean removeActivity(Activity activity){
        mActivities.remove(activity);
        return true;
    }
}