package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagMOfTagDS {
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String cNC;
    @XmlAttribute
    private String d;
    @XmlAttribute
    private String dNC;
    @XmlAttribute
    private String n;
    @XmlElement(name = "d")
    private List<TagDOfTagM> listD;

    public String getC() {
        return c;
    }

    public String getcNC() {
        return cNC;
    }

    public String getD() {
        return d;
    }

    public String getdNC() {
        return dNC;
    }

    public String getN() {
        return n;
    }

    public List<TagDOfTagM> getListD() {
        return listD;
    }

    @Override
    public String toString() {
        return "TagMOfTagDS{" +
                "c='" + c + '\'' +
                ", cNC='" + cNC + '\'' +
                ", d='" + d + '\'' +
                ", dNC='" + dNC + '\'' +
                ", n='" + n + '\'' +
                ", listD=" + listD +
                '}';
    }
}
