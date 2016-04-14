package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.tv_forget_password)
    protected TextView mJumpMain;
    @Bind(R.id.username_login_page)
    protected EditText mUsername;

    @Bind(R.id.password_login_page)
    protected EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.login_button_login_page)
    protected void OnClickLogin() {

    }


    @OnClick(R.id.tv_forget_password)
    protected void OnClickMain() {
//        GotoHelper.gotoActivity(LoginActivity.this, MainActivity.class);
//        finish();
    }


}
