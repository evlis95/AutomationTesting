package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagKOfTagUnivRes {
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String k;
    @XmlAttribute
    private String p;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String u;

    public String getN() {
        return n;
    }

    public String getK() {
        return k;
    }

    public String getP() {
        return p;
    }

    public String getT() {
        return t;
    }

    public String getU() {
        return u;
    }

    @Override
    public String toString() {
        return "TagKOfTagUnivRes{" +
                "n='" + n + '\'' +
                ", k='" + k + '\'' +
                ", p='" + p + '\'' +
                ", t='" + t + '\'' +
                ", u='" + u + '\'' +
                '}';
    }
}
