package com.shyms.corpormobile.module;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NInformation implements Serializable {

    public List<NInformationData> data;

    public NPage pageInfo;

    public NInformation() {
        this.data = null;
        this.pageInfo = null;
    }


    public NInformation(List<NInformationData> data, NPage pageInfo) {
        this.data = data;
        this.pageInfo = pageInfo;
    }
}
