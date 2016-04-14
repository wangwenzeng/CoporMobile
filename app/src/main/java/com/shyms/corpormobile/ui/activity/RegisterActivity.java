package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;
import com.shyms.corpormobile.base.BaseApplication;
import com.shyms.corpormobile.helper.GotoHelper;
import com.shyms.corpormobile.util.NetUtils;
import com.shyms.corpormobile.util.ToastUtil;
import com.shyms.corpormobile.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @Bind(R.id.username_sign_up_page)
    protected EditText mUsername;
    @Bind(R.id.password_sign_up_page)
    protected EditText mPassword;
    @Bind(R.id.re_password_sign_up_page)
    protected EditText mRePassword;
    @Bind(R.id.top_bar_left_image)
    protected ImageView TopBarLeftBack;
    @Bind(R.id.top_bar_title)
    protected TextView TopBarTitle;
    @Bind(R.id.sign_up_button_sign_up_page)
    protected Button button;

    private String mobile;
    private String passWord;
    private String rePassWord;

    private int mMaxPassLength = 16;
    private int mMinPassLength = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    //    @OnClick(R.id.sign_up_button_sign_up_page)
    protected void onClickRegister() {
        mobile = mUsername.getText().toString().trim();
        passWord = mPassword.getText().toString().trim();
        rePassWord = mRePassword.getText().toString().trim();
        if (TextUtils.isEmpty(rePassWord) ||
                !rePassWord.equals(passWord)) {
            Toast.makeText(getBaseContext(), "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        if (passWord.length() < mMinPassLength) {
            ToastUtil.shortShowText("密码至少需要" + mMinPassLength + "位");
            return;
        }
        if (passWord.length() > mMaxPassLength) {
            ToastUtil.shortShowText("密码至多" + mMaxPassLength + "位");
            return;
        }

        if (!NetUtils.isNetworkAvalible(BaseApplication.context)) {
            ToastUtil.showNoNetTip();
            return;
        }

        if (Util.isMobileNO(mobile)) {
//            mActivityHelper.showProgressDialog("正在提交");
//            NETRequest2.APIInstance.sendVerifyCode(mobile)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(flag -> {
//                        if (flag.data.booleanValue() == true) {
//
//                            Toast.makeText(RegisterActivity.this, "网络请求成功", Toast.LENGTH_LONG).show();
//
//                            RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, MainActivity.class));
//
//                        } else {
//                            Toast.makeText(RegisterActivity.this, flag.data.toString(), Toast.LENGTH_LONG).show();
//                            Log.d(GlobalConstant.TAG, flag.toString());
//                        }
//
//                    }, throwable -> {
//
//                    });
        }
    }

    @OnClick(R.id.clickTomain)
    protected void onClickJumpMain() {
        GotoHelper.gotoActivity(RegisterActivity.this, MainActivity.class);
        finish();
    }


}
