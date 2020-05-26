package com.example;

import android.app.Application;
import android.content.Context;

/**
 * @author huanglinqing
 * @data:2020.05.26
 */
public class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
