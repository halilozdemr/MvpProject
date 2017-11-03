package com.halilozdemr.mvpproject.di.component;

import com.halilozdemr.mvpproject.di.module.ActivityModule;
import com.halilozdemr.mvpproject.di.module.ApiModule;
import com.halilozdemr.mvpproject.di.module.NetModule;
import com.halilozdemr.mvpproject.di.scope.PerActivity;
import com.halilozdemr.mvpproject.ui.main.MainActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class, modules = {NetModule.class, ApiModule.class, ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
