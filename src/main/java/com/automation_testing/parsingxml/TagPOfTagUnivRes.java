package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagPOfTagUnivRes {
    @XmlAttribute
    private String b;
    @XmlElement
    private String c;
    @XmlElement
    private String l;
    @XmlElement(name = "r")
    private List<TagROfTagP>listR;
    @XmlAttribute
    private String a;


    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getL() {
        return l;
    }

    public List<TagROfTagP> getListR() {
        return listR;
    }

    public String getA() {
        return a;
    }

    @Override
    public String toString() {
        return "TagPOfTagUnivRes{" +
                "b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", l='" + l + '\'' +
                ", listR=" + listR +
                ", a='" + a + '\'' +
                '}';
    }
}
