package com.example.mvvmnews.http.apiservice;

import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;
import com.example.BaseApplication;
import com.example.mvvmnews.config.HttpConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 请求复制构建者模式
 * 默认校验token 不忽略https校验
 */
public class RetrofitServiceBuilder {


    private static Context mContext;

    private static OkHttpClient client;

    /**
     * 创建对象
     */
    public static <T> T createService(final Class<T> clazz) {

        mContext = BaseApplication.getContext();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        client = builder.build();

        if (!NetworkUtils.isConnected(mContext)) {
            return null;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_API)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T service = (T) retrofit.create(clazz);

        return service;


    }

}
