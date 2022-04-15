package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagOrgOfTagPersonInfo {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String ps;
    @XmlElement(name = "ulk")
    private List<TagUlkOfTagOrg> listULK;

    public String getId() {
        return id;
    }

    public String getPs() {
        return ps;
    }

    public List<TagUlkOfTagOrg> getListULK() {
        return listULK;
    }

    @Override
    public String toString() {
        return "TagOrgOfTagPersonInfo{" +
                "id='" + id + '\'' +
                ", ps='" + ps + '\'' +
                ", listULK=" + listULK +
                '}';
    }
}
