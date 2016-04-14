package com.shyms.corpormobile.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Weimin on 4/12/2016.
 */
public class AffairRemindAdapter extends BaseListAdapter {

    public AffairRemindAdapter(Context context) {
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
            convertView = mLayoutInflater.inflate(R.layout.item_remind_list, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.tv_affair_num)
        TextView mAffairNum;
        @Bind(R.id.tv_affair_time)
        TextView mTime;
        @Bind(R.id.tv_affair_name)
        TextView mAffairName;
        @Bind(R.id.tv_check_atate)
        TextView mCheckState;
        @Bind(R.id.tv_check_idea)
        TextView mCheckIdea;
        ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
        }
    }
}
