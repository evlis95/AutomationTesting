package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagPageOfTagUnivRes {
    @XmlElement(name = "r")
    private List<TagROfTagPage> listR;
    @XmlAttribute
    private String n;

    public List<TagROfTagPage> getListR() {
        return listR;
    }

    public String getN() {
        return n;
    }

    @Override
    public String toString() {
        return "TagPageOfTagUnivRes{" +
                "listR=" + listR +
                ", n='" + n + '\'' +
                '}';
    }
}
