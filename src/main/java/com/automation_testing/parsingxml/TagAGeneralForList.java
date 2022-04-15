package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagAGeneralForList {

    @XmlAttribute
    private String k;
    @XmlAttribute
    private String v;

    public String getK() {
        return k;
    }

    public String getV() {
        return v;
    }

    @Override
    public String toString() {
        return "TagAGeneralForList{" +
                "k='" + k + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
