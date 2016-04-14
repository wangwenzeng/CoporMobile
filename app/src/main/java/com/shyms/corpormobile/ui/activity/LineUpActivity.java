package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LineUpActivity extends BaseActivity {

    @Bind(R.id.top_bar_title)
    protected TextView mTitle;
    @Bind(R.id.top_bar_back)
    protected FrameLayout mbarBack;
    @Bind(R.id.tv_cur_win_num)
    protected TextView mCurWinNum;//几号窗口
    @Bind(R.id.tv_window_num)
    protected TextView mWinNum;//当前服务窗口数

    @Bind(R.id.tv_lineup_num)
    protected TextView mLineUpNum;//当前排队人数
    @Bind(R.id.tv_my_lineup_num)
    protected TextView mMyLineUpNum;//我的排队号码
    @Bind(R.id.tv_forward_lineup_num)
    protected TextView mForwardNum;//前面排队人数

    @Bind(R.id.tv_mynum_state)
    protected TextView mMyNumState;//我的号码状态
    @Bind(R.id.btn_acquire_code)
    protected Button mAcquireCode;//我要取号
    @Bind(R.id.tv_curcharge_win_num)
    protected TextView mCurChargeNum;//当前收费窗口数
    @Bind(R.id.tv_lineup_num_charge)
    protected TextView mCurLineChargeNum;//当前收费排队人数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_up);
        ButterKnife.bind(this);
        mTitle.setText("排队信息");
        mbarBack.setVisibility(View.VISIBLE);
    }


}
