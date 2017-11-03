package com.halilozdemr.mvpproject.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.halilozdemr.mvpproject.MvpProjectApp;
import com.halilozdemr.mvpproject.R;
import com.halilozdemr.mvpproject.di.component.DaggerActivityComponent;
import com.halilozdemr.mvpproject.di.module.ActivityModule;
import com.halilozdemr.mvpproject.di.module.ApiModule;
import com.halilozdemr.mvpproject.di.module.NetModule;

import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    DaggerActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = (DaggerActivityComponent) DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .netModule(new NetModule())
                .apiModule(new ApiModule())
                .appComponent(((MvpProjectApp) getApplication()).appComponent)
                .build();

    }

    public DaggerActivityComponent getmActivityComponent() {
        return mActivityComponent;
    }


    @Override
    public void showLoading() {
        hideLoading();
        mDialog = new Dialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.custom_dialog);
        mDialog.setCancelable(false);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        ImageView imageView = (ImageView) mDialog.findViewById(R.id.img_rotate);
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.my_rotate);
        rotation.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(rotation);


        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog == null) return;
        mDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar("asdasdasdas");
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

}
