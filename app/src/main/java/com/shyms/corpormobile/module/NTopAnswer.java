package com.shyms.corpormobile.module;

import java.io.Serializable;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NTopAnswer implements Serializable {

    public final String voteUp;//":"0",
    public final String voteDown;//voteDown":"0",
    public final String question;// "question":null,
    public final String isVoted;//"isVoted":null,
    public final String previewComments; //      "previewComments":null,
    public final String answerId;//      "answerId":"76",
    public final String questionId;//      "questionId":"27",
    public final String answer; //      "answer":"a",


    public NTopAnswer() {
        this.voteUp = null;
        this.voteDown = null;
        this.question = null;
        this.isVoted = null;
        this.previewComments = null;
        this.answerId = null;
        this.questionId = null;
        this.answer = null;
    }
}
