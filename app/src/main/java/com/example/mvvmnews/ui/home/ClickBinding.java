package com.example.mvvmnews.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.BaseApplication;
import com.example.mvvmnews.NewsDetailActivity;
import com.example.mvvmnews.bean.NewBean;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc
 */
public class ClickBinding {

    public void itemClick(NewBean.ResultBean.DataBean dataBean, View view) {
        Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
        intent.putExtra("newsurl", dataBean.getUrl());
        view.getContext().startActivity(intent);

    }
}
