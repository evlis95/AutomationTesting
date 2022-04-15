package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagUIOfTagUnivRes {
    @XmlAttribute
    private String e;
    @XmlAttribute
    private String f;
    @XmlAttribute
    private String p;

    public String getE() {
        return e;
    }

    public String getF() {
        return f;
    }

    public String getP() {
        return p;
    }

    @Override
    public String toString() {
        return "TagUIOfTagUnivRes{" +
                "e='" + e + '\'' +
                ", f='" + f + '\'' +
                ", p='" + p + '\'' +
                '}';
    }
}
