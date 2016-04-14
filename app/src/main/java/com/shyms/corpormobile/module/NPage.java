package com.shyms.corpormobile.module;

import java.io.Serializable;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NPage implements Serializable {

    final public int pageNo;//"pageNo":0,
    final public int pageSize;// "pageSize":1,
    final public int total;// "total":33

    public NPage() {
        this.pageNo = 0;
        this.pageSize = 0;
        this.total = 0;
    }
}
