package com.halilozdemr.mvpproject.ui.main;

import android.content.Context;

import com.halilozdemr.mvpproject.rest.model.User;
import com.halilozdemr.mvpproject.rest.model.UserResponse;
import com.halilozdemr.mvpproject.rest.repository.ApiClient;
import com.halilozdemr.mvpproject.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(ApiClient apiClient, Context context) {
        super(apiClient, context);
    }

    @Override
    public void onServerLoginClick(String userId, String name, String surname) {

        getMvpView().showLoading();
        getmApiClient().getUser(new User(name, surname, userId))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UserResponse userModel) {
                        getMvpView().openUserActivity(userModel.getData().getUserId(), userModel.getData().getName(), userModel.getData().getSurname());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().hideLoading();
                    }
                });
    }
}
