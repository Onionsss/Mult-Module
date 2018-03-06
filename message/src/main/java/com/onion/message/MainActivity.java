package com.onion.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.onion.base.RouterPath;

/**
 * Created by OnionMac on 2018/2/28.
 */
@Route(path = RouterPath.MESSAGE_MAIN)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity_main);

        ARouter.getInstance().build(RouterPath.HOME_MAIN).navigation();
    }

}
