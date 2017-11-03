package com.halilozdemr.mvpproject.ui.base;


import android.content.Context;

import com.halilozdemr.mvpproject.rest.repository.ApiClient;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    private final Context mContext;
    private final ApiClient mApiClient;

    @Inject
    public BasePresenter(ApiClient apiClient, Context context) {
        this.mApiClient = apiClient;
        this.mContext = context;
    }


    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public ApiClient getmApiClient() {
        return mApiClient;
    }

    public Context getmContext() {
        return mContext;
    }
}
