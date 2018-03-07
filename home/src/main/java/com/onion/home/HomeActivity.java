package com.onion.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.onion.base.RouterPath;
import com.onion.base.center.AppCenter;
import com.onion.home.api.HomeApi;
import com.onion.home.bean.City;
import com.onion.home.databinding.ActivityMainBinding;
import com.onion.home.di.ActivityComponent;
import com.onion.http.HttpRepository;
import com.onion.http.api.HttpLogger;
import com.onion.pojo.User;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by OnionMac on 2018/2/28.
 */
@Route(path = RouterPath.HOME_MAIN)
public class HomeActivity extends AppCompatActivity{

    @Inject
    AppCenter mAppCenter;

    @Inject
    HttpRepository mHttpRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        User user = new User();
        user.setName("张琦");
        binding.setUser(user);

        binding.tv.setOnClickListener(v -> {
            Log.d("TAG", "onClick: ");
            Retrofit home = mHttpRepository.getRepository("home");
            HomeApi homeApi = home.create(HomeApi.class);
            HttpLogger.setOpenFlag(true);
            homeApi.getCity().enqueue(new Callback<City>() {
                @Override
                public void onResponse(Call<City> call, Response<City> response) {
                    Log.d("TAG", "onResponse: "+new Gson().toJson(response.body()));

                    ARouter.getInstance().build(RouterPath.TAXI_SPLASH).navigation();
                }

                @Override
                public void onFailure(Call<City> call, Throwable t) {
                    Log.d("TAG", "onResponse: "+t.toString());

                }
            });
        });

        ActivityComponent.getInstance().inject(this);

    }


}
