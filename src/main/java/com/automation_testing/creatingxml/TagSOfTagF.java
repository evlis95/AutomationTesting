package com.autotest.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagSOfTagF {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String k;

    public TagSOfTagF(String a, String k) {
        this.a = a;
        this.k = k;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setK(String k) {
        this.k = k;
    }
}
