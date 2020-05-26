package com.example.mvvmnews.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc
 */
public class HomeViewModelFactory implements ViewModelProvider.Factory {


    private String appKey;

    public HomeViewModelFactory(String appKey) {
        this.appKey = appKey;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel(appKey);
    }
}
