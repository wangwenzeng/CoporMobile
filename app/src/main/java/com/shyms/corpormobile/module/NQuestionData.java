package com.shyms.corpormobile.module;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NQuestionData {
    public final String viewNum;//	访问量
    public final String favoriteNum;    //收藏数
    public final String answerNum;    //评论数、回答数

    public final String updateTime;//":"2014-10-27 00:26:21",
    public final String isFavorited;//默认 null,
    public final NTopAnswer topAnswer;//最新评论
    public final String top;//":null,是否置顶
    public final String questionId;//":"27",问题序号
    public final String question;//问题内容
    public final NUser user;//用户信息
    public final String questionTime;//":null,
    public final String thumb;//图片数组


    public NQuestionData() {
        this.viewNum = null;
        this.favoriteNum = null;
        this.answerNum = null;
        this.updateTime = null;
        this.isFavorited = null;
        this.topAnswer = null;
        this.top = null;
        this.questionId = null;
        this.question = null;
        this.user = null;
        this.questionTime = null;
        this.thumb = null;
    }
}
