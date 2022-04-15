package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagPageOfTagLocalization {
    @XmlAttribute
    private String n;
    @XmlElement(name = "f")
    private List<TagFOfTagPage> listF;

    public String getN() {
        return n;
    }

    public List<TagFOfTagPage> getListF() {
        return listF;
    }

    @Override
    public String toString() {
        return "TagPageOfTagLocalization{" +
                "n='" + n + '\'' +
                ", listF=" + listF +
                '}';
    }
}
