package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagHashOfTagUnivRes {

    @XmlAttribute
    private String v;

    public String getV() {
        return v;
    }

    @Override
    public String toString() {
        return "TagHashOfTagUnivRes{" +
                "v='" + v + '\'' +
                '}';
    }
}
