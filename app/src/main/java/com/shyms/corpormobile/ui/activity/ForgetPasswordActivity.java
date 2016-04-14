package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForgetPasswordActivity extends BaseActivity {

    @Bind(R.id.username_forget_password_page)
    protected EditText mEtUsername;
    @Bind(R.id.reset_password_forget_password_page)
    protected Button mBtnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

    }

}
