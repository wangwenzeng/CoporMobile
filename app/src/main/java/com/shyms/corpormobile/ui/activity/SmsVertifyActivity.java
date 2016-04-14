package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmsVertifyActivity extends BaseActivity {

    @Bind(R.id.top_bar_left_image)
    protected ImageView mTopBarLeftIcon;
    @Bind(R.id.top_bar_title)
    protected TextView mTopBarTitle;
    @Bind(R.id.top_bar_right_text)
    protected TextView mTopBarRightText;
    @Bind(R.id.phone_number_auth_code_page)
    protected TextView phoneNumberText;
    @Bind(R.id.code_auth_code_page)
    protected EditText verifyCode;
    @Bind(R.id.re_send_code_auth_code_page)
    protected Button reSendCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_vertify);
        ButterKnife.bind(this);
        mTopBarTitle.setText("验证手机号");
        mTopBarRightText.setText("继续");
        mTopBarLeftIcon.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.top_bar_left_image)
    protected void onBackPress() {
        finish();
    }

}
