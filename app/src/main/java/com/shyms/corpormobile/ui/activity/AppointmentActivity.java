package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AppointmentActivity extends BaseActivity {
    @Bind(R.id.tv_appointment_num)
    protected TextView mApomtNum;
    @Bind(R.id.tv_appointment_name)
    protected TextView mApomtName;
    @Bind(R.id.tv_appointment_time)
    protected TextView mApomtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);
        ButterKnife.bind(this);
    }


}
