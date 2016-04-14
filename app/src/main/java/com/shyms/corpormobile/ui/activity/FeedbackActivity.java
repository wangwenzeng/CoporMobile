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

public class FeedbackActivity extends BaseActivity {

    @Bind(R.id.top_bar_left_image)
    protected ImageView mTopBarLeftIcon;
    @Bind(R.id.top_bar_title)
    protected TextView mTopBarTitle;
    @Bind(R.id.feed_back)
    protected EditText mEtFeedBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ButterKnife.bind(this);
        mTopBarTitle.setText("意见反馈");
    }

    @OnClick(R.id.top_bar_left_image)
    protected void onBackPress() {
        finish();
    }


}
