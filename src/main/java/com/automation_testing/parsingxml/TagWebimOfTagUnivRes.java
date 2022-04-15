package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagWebimOfTagUnivRes {
    @XmlAttribute
    private String a;

    public String getA() {
        return a;
    }

    @Override
    public String toString() {
        return "TagWebimOfTagUnivRes{" +
                "a='" + a + '\'' +
                '}';
    }
}
