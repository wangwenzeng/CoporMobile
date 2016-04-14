package com.shyms.corpormobile.module;

import java.io.Serializable;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NInformationData implements Serializable {

    final public String informationId;//    "informationId":"11", 资讯ID
    final public String title;//          标题
    final public String brief;//            摘要"brief":"",
    final public String content;//            咨询内容"content":null,
    final public String publishTime;//            发布时间"publishTime":"0000-00-00 00:00:00",
    final public String category;//            分类   "category":null,
    final public String viewNum;//            访问量  "viewNum":"0",
    final public String favoriteNum;//          收藏数
    final public String voteUp;//            投票支持 ,
    final public String voteDown;//            投票反对
    final public String isFavorited;//           是否已收藏
    final public String isVoted;//            是否已投票


    public NInformationData() {
        this.informationId = null;
        this.title = null;
        this.brief = null;
        this.content = null;
        this.publishTime = null;
        this.category = null;
        this.viewNum = null;
        this.favoriteNum = null;
        this.voteUp = null;
        this.voteDown = null;
        this.isFavorited = null;
        this.isVoted = null;
    }
}
