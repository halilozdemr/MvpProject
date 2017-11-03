package com.halilozdemr.mvpproject.ui.base;


public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
}
