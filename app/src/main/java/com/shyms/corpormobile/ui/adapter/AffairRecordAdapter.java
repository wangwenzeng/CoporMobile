package com.shyms.corpormobile.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Weimin on 4/12/2016.
 */
public class AffairRecordAdapter extends BaseListAdapter {

    public AffairRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_affair_record, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    class ViewHolder {
        @Bind(R.id.tv_order_name)
        TextView mName;
        @Bind(R.id.tv_order_num)
        TextView mNum;
        @Bind(R.id.tv_state_txt)
        TextView mStateTxt;
        @Bind(R.id.tv_order_time)
        TextView mTime;
        @Bind(R.id.btn_update)
        Button mUpdate;

        ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
        }
    }


}
