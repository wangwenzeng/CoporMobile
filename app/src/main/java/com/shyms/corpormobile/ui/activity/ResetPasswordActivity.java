package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends BaseActivity {

    @Bind(R.id.top_bar_left_image)
    protected ImageView mTopBarLeftIcon;
    @Bind(R.id.top_bar_title)
    protected TextView mTopBarTitle;
    @Bind(R.id.top_bar_right_text)
    protected TextView mTopBarRightText;
    @Bind(R.id.password_input)
    protected EditText mEtPasswordInput;
    @Bind(R.id.tips_email_tips_page)
    protected TextView mEmailTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        mTopBarTitle.setText("重设密码");
        mTopBarRightText.setText("完成");
    }

    @OnClick(R.id.top_bar_left_image)
    protected void onBackPress() {
        finish();
    }
}
