package com.halilozdemr.mvpproject.ui.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.halilozdemr.mvpproject.R;
import com.halilozdemr.mvpproject.data.IntentTags;
import com.halilozdemr.mvpproject.ui.custom.HelveticaTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {
    @BindView(R.id.txt_user_id) HelveticaTextView mTxtUserId;
    @BindView(R.id.txt_user_name) HelveticaTextView mTxtUserName;
    @BindView(R.id.txt_user_surname) HelveticaTextView mTxtUserSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        String id = getIntent().getStringExtra(IntentTags.USER_ID);
        String name = getIntent().getStringExtra(IntentTags.USER_NAME);
        String surname = getIntent().getStringExtra(IntentTags.USER_SURNAME);

        mTxtUserId.setText(id);
        mTxtUserName.setText(name);
        mTxtUserSurname.setText(surname);
    }
}
