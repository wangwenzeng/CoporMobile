package com.shyms.corpormobile.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;
import com.shyms.corpormobile.module.NInformationData;
import com.shyms.corpormobile.util.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Weimin on 4/11/2016.
 */
public class NewsDetailFragment extends BaseFragment {

    @Bind(R.id.top_bar_back)
    protected FrameLayout mback;
    @Bind(R.id.top_bar_title)
    protected TextView mTitle;
    @Bind(R.id.iv_news_img)
    protected SimpleDraweeView mNewsImg;
    @Bind(R.id.tv_home_news_title)
    protected TextView mNewsTitle;
    @Bind(R.id.tv_publish_time)
    protected TextView mPublishTime;
    @Bind(R.id.iv_comment)
    protected ImageView mComment;
    @Bind(R.id.iv_favorite)
    protected ImageView mFavorite;
    @Bind(R.id.tv_comment_num)
    protected TextView mCommentNum;
    @Bind(R.id.tv_favorite_num)
    protected TextView mFavoriteNum;
    @Bind(R.id.tv_publish_unit)
    protected TextView mPublishUnit;
    @Bind(R.id.tv_news_detail)
    protected TextView mNewsDetail;
    @Bind(R.id.tv_news_content)
    protected TextView mNewsContent;

    private NInformationData result;

    @Override

    protected int getLayoutResID() {
        return R.layout.fragment_news_detail;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.findViewById(R.id.top_bar_left_image).setVisibility(View.VISIBLE);
        Bundle bundle = getArguments();
        if (bundle != null) {
            result = (NInformationData) bundle.getSerializable("detail");
            mTitle.setText(result.title);
            mNewsImg.setImageURI(Uri.parse(result.brief));
            mPublishTime.setText(result.publishTime);
            mCommentNum.setText(result.viewNum);
            mFavoriteNum.setText(result.favoriteNum);
            mNewsContent.setText(result.content);
        } else {
            ToastUtil.shortShowText("没有获取到数据");
        }
    }

    @OnClick(R.id.top_bar_back)
    protected void OnClickBack() {
        mActivity.onBackPressed();
    }


}
