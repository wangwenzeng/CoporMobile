package com.shyms.corpormobile.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NQuestion implements Serializable {

    final public List<NQuestionData> data;
    final public NPage pageInfo;


    public NQuestion() {
        this.data = null;
        this.pageInfo = null;
    }

    public NQuestion(List<NQuestionData> data, NPage pageInfo) {
        this.data = data;
        this.pageInfo = pageInfo;
    }
}
