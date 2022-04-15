package com.automation_testing.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagAOfTagT {
    @XmlAttribute
    private String s;

    public TagAOfTagT(String s) {
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
