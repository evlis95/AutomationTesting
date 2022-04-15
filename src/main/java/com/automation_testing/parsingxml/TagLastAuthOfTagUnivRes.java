package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagLastAuthOfTagUnivRes {
    @XmlAttribute
    private String i;
    @XmlAttribute
    private String m;

    public String getI() {
        return i;
    }

    public String getM() {
        return m;
    }

    @Override
    public String toString() {
        return "TagLastAuthOfTagUnivRes{" +
                "i='" + i + '\'' +
                ", m='" + m + '\'' +
                '}';
    }
}
