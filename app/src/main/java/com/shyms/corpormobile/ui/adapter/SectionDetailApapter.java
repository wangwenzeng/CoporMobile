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
public class SectionDetailApapter extends BaseListAdapter<String> {

    public SectionDetailApapter(Context context) {
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
            convertView = mLayoutInflater.inflate(R.layout.item_section_detail_list, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mDetailTxt.setText(mDataList.get(position));

        return convertView;
    }

    class ViewHolder {

        @Bind(R.id.tv_detail_text)
        TextView mDetailTxt;

        ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
        }
    }

}
