package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagFOfTagPage {
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
        return "TagFOfTagPage{" +
                "n='" + n + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
