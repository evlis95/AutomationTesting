package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagDOfTafUnivRes {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String i;
    @XmlAttribute
    private String p;
    @XmlAttribute
    private String pc;
    @XmlAttribute
    private String pm;
    @XmlAttribute
    private String ti;
    @XmlAttribute
    private String count;
    @XmlAttribute
    private String type;
    @XmlElement(name = "c")
    private List<TagCOfTagD>listC;

    public String getA() {
        return a;
    }

    public List<TagCOfTagD> getListC() {
        return listC;
    }

    public String getI() {
        return i;
    }

    public String getP() {
        return p;
    }

    public String getPc() {
        return pc;
    }

    public String getPm() {
        return pm;
    }

    public String getTi() {
        return ti;
    }

    public String getCount() {
        return count;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TagDOfTafUnivRes{" +
                "i='" + i + '\'' +
                ", p='" + p + '\'' +
                ", pc='" + pc + '\'' +
                ", pm='" + pm + '\'' +
                ", ti='" + ti + '\'' +
                ", count='" + count + '\'' +
                ", type='" + type + '\'' +
                ", listC=" + listC +
                '}';
    }
}
