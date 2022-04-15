package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagFPOfTagUnivRes {
    @XmlAttribute
    private String e;

    public String getE() {
        return e;
    }

    @Override
    public String toString() {
        return "TagFPOfTagUnivRes{" +
                "e='" + e + '\'' +
                '}';
    }
}
