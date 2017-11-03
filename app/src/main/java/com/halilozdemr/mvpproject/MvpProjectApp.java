package com.halilozdemr.mvpproject;

import android.app.Application;

import com.halilozdemr.mvpproject.di.component.AppComponent;

public class MvpProjectApp extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);

    }

}
