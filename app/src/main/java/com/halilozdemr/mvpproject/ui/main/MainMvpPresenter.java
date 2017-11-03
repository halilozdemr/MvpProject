package com.halilozdemr.mvpproject.ui.main;


import com.halilozdemr.mvpproject.ui.base.MvpPresenter;


public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String userId, String name, String surname);

}
