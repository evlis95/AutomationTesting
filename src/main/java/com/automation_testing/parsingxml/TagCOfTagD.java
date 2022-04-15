package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagCOfTagD {
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String v;

    public String getS() {
        return s;
    }

    public String getV() {
        return v;
    }

    @Override
    public String toString() {
        return "TagCOfTagD{" +
                "s='" + s + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
