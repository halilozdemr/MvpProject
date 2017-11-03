package com.halilozdemr.mvpproject.di.module;

import android.app.Activity;
import android.content.Context;

import com.halilozdemr.mvpproject.di.scope.PerActivity;
import com.halilozdemr.mvpproject.ui.main.MainMvpPresenter;
import com.halilozdemr.mvpproject.ui.main.MainMvpView;
import com.halilozdemr.mvpproject.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
}
