package com.example.mvvmnews.http.apiservice;

import com.example.mvvmnews.bean.NewBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc 接口
 */
public interface ApiServices {


    /**
     * 获取新闻数据
     * @param type 类型
     * @param key appkey
     * @return
     */
    @GET("toutiao/index")
    Observable<NewBean> getNews(@Query("type") String type, @Query("key") String key);

}
