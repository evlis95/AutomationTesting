package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagCorrAccOfTagR {
    @XmlAttribute
    private String a;

    public String getA() {
        return a;
    }

    @Override
    public String toString() {
        return "TagCorrAccOfTagR{" +
                "a='" + a + '\'' +
                '}';
    }
}
