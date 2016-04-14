package com.shyms.corpormobile.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;
import com.shyms.corpormobile.helper.GotoHelper;
import com.shyms.corpormobile.ui.activity.BindEmailActivity;
import com.shyms.corpormobile.ui.activity.FeedbackActivity;
import com.shyms.corpormobile.ui.activity.ForgetPasswordActivity;
import com.shyms.corpormobile.ui.activity.ResetPasswordActivity;
import com.shyms.corpormobile.util.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Weimin on 4/9/2016.
 */
public class SettingFragment extends BaseFragment {

    @Bind(R.id.top_bar_title)
    protected TextView mTitle;
    @Bind(R.id.profile_image)
    protected CircleImageView mProfileImage;

    @Bind(R.id.version_name)
    protected TextView mVersionName;


    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_setting;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTitle.setText("设置");
    }

    @OnClick(R.id.ll_update_password)
    protected void onClickUpdatepassword() {
        GotoHelper.gotoActivity(mActivity, ForgetPasswordActivity.class);
    }

    @OnClick(R.id.ll_reset_password)
    protected void onClickResetPassword() {
        GotoHelper.gotoActivity(mActivity, ResetPasswordActivity.class);
    }

    @OnClick(R.id.ll_bind_Email)
    protected void onClickBindEmial() {
        GotoHelper.gotoActivity(mActivity, BindEmailActivity.class);
    }

    @OnClick(R.id.ll_feed_back)
    protected void onClickFeedBack() {
        GotoHelper.gotoActivity(mActivity, FeedbackActivity.class);
    }


    @OnClick(R.id.ll_version_update)
    protected void onClickVersionUpdate() {
        ToastUtil.shortShowText("当前已经是最新版本");
    }


}
