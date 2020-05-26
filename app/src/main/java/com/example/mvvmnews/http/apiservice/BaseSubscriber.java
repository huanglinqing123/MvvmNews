package com.example.mvvmnews.http.apiservice;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author Huanglinqing
 * BaseSubscriber
 */
public abstract class BaseSubscriber<T> implements Observer<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}