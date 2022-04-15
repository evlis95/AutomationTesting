package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagFForList {
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String v;

    public String getN() {
        return n;
    }

    public String getV() {
        return v;
    }

    @Override
    public String toString() {
        return "TagFForList{" +
                "n='" + n + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
