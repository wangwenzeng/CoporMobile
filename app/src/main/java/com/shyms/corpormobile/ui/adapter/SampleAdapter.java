package com.shyms.corpormobile.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Weimin on 4/12/2016.
 */
public class SampleAdapter extends BaseListAdapter implements View.OnClickListener {

    private Context mContext;

    public SampleAdapter(Context context) {
        super(context);
        mContext = context;
    }

    public SampleAdapter(Context context, AbsListView listView) {
        super(context, listView);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_sample_list, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mEmptyLoad.setOnClickListener(this);
        holder.mSampleLoad.setOnClickListener(this);
        return convertView;
    }


    class ViewHolder {
        @Bind(R.id.tv_item_pos)
        TextView mPosText;
        @Bind(R.id.tv_item_content)
        TextView mContent;
        @Bind(R.id.tv_item_description)
        TextView mDescription;
        @Bind(R.id.btn_empty_load)
        Button mEmptyLoad;
        @Bind(R.id.btn_sample_load)
        Button mSampleLoad;

        ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_empty_load:

                //TODO  根据获取来的数据  预览图片
                Toast.makeText(mContext, "下载空表按钮被单击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sample_load:
                Toast.makeText(mContext, "下载样表按钮被单击", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
