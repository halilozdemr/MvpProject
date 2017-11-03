package com.halilozdemr.mvpproject.ui.base;

import android.support.annotation.StringRes;

public interface MvpView {


    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);


}
