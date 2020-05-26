package com.example.mvvmnews.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("姓名：黄林晴\n CSDN:https://huanglinqing.blog.csdn.net/");
    }

    public LiveData<String> getText() {
        return mText;
    }
}