package com.automation_testing.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagAboutOfUnivReq {
    @XmlAttribute
    private String h;
    @XmlAttribute
    private String w;

    public void setH(String h) {
        this.h = h;
    }

    public void setW(String w) {
        this.w = w;
    }
}
