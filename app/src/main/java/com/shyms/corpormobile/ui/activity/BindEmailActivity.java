package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindEmailActivity extends BaseActivity {

    @Bind(R.id.top_bar_left_image)
    protected ImageView mTopBarLeftIcon;
    @Bind(R.id.top_bar_title)
    protected TextView mTopBarTitle;
    @Bind(R.id.password_input)
    protected EditText mUserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_email);
        ButterKnife.bind(this);
        mTopBarTitle.setText("绑定邮箱");
        mTopBarLeftIcon.setVisibility(View.VISIBLE);


    }

    @OnClick(R.id.top_bar_left_image)
    protected void onBackPress() {
        finish();
    }

}
