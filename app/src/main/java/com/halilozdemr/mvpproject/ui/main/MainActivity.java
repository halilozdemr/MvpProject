package com.halilozdemr.mvpproject.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.halilozdemr.mvpproject.R;
import com.halilozdemr.mvpproject.data.IntentTags;
import com.halilozdemr.mvpproject.ui.base.BaseActivity;
import com.halilozdemr.mvpproject.ui.user.UserActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.edtUserId) EditText mEdtUserId;
    @BindView(R.id.edtName) EditText mEditName;
    @BindView(R.id.edtSurname) EditText mEdtSurname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        getmActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }

    @OnClick(R.id.btnLogin)
    void onServerLoginClick(View v) {
        mPresenter.onServerLoginClick(mEdtUserId.getText().toString(), mEditName.getText().toString(), mEdtSurname.getText().toString());
    }

    @Override
    public void openUserActivity(String id, String name, String surname) {
        Intent in = new Intent(this, UserActivity.class);
        in.putExtra(IntentTags.USER_ID, id);
        in.putExtra(IntentTags.USER_NAME, name);
        in.putExtra(IntentTags.USER_SURNAME, surname);
        startActivity(in);
    }
}
