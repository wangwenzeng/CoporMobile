package com.shyms.corpormobile.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyms.corpormobile.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Weimin on 4/9/2016.
 */
public class AffairGuideAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private int[] mIcons = {R.mipmap.icon_affair_guide_001, R.mipmap.icon_affair_guide_002, R.mipmap.icon_affair_guide_003, R.mipmap.icon_affair_guide_004,
            R.mipmap.icon_affair_guide_015, R.mipmap.icon_affair_guide_016, R.mipmap.icon_affair_guide_008, R.mipmap.icon_affair_guide_008,
            R.mipmap.icon_affair_guide_009, R.mipmap.icon_affair_guide_010, R.mipmap.icon_affair_guide_011, R.mipmap.icon_affair_guide_012,
            R.mipmap.icon_affair_guide_009, R.mipmap.icon_affair_guide_010, R.mipmap.icon_affair_guide_011, R.mipmap.icon_affair_guide_012,
            R.mipmap.icon_affair_guide_013, R.mipmap.icon_affair_guide_014, R.mipmap.icon_affair_guide_015, R.mipmap.icon_affair_guide_016,};

    private String[] mTvIcon = {"经促局", "工商局", "城市综合管\n理局", "民政局", "公安局",
            "国土资源局", "城乡建设", "水务", "发改", "交通运输局",
            "消防局", "国税局", "质监局", "气象局", "教育局",
            "人社局", "警察局", "人力资源", "社保", "其他"};


    public AffairGuideAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mIcons.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return mIcons[i];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_guide_gv, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgIcon.setImageResource(mIcons[position]);
        holder.tvIcon.setText(mTvIcon[position]);

        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.iv_icon_gv)
        ImageView imgIcon;
        @Bind(R.id.tv_text_gv)
        TextView tvIcon;

        ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
        }
    }
}
