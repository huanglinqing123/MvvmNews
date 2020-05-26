package com.example.mvvmnews.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmnews.bean.NewBean;
import com.example.mvvmnews.http.apiservice.ApiServices;
import com.example.mvvmnews.http.apiservice.BaseSubscriber;
import com.example.mvvmnews.http.apiservice.RetrofitServiceBuilder;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc 新闻仓库
 */
public class NewRepository {


    private static final String TAG = "NewRepository";

    public MutableLiveData<NewBean> getNews(String type, String appkey) {
        Log.d(TAG, "getNews: 走进这个方法了");

        final MutableLiveData<NewBean> mutableLiveData = new MutableLiveData<>();
        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);
        if (apiServices != null) {
            apiServices.getNews(type, appkey)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<NewBean>() {
                        @Override
                        public void onNext(NewBean newBean) {
                            Log.d(TAG, "onNext: 在这里");
                            mutableLiveData.setValue(newBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: " + e.toString());
                        }
                    });
        }

        return mutableLiveData;
    }
}
