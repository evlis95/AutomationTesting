package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagAOfTagAd {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String tr;

    public String getA() {
        return a;
    }

    public String getT() {
        return t;
    }

    public String getTr() {
        return tr;
    }

    @Override
    public String toString() {
        return "TagAOfTagAd{" +
                "a='" + a + '\'' +
                ", t='" + t + '\'' +
                ", tr='" + tr + '\'' +
                '}';
    }
}
