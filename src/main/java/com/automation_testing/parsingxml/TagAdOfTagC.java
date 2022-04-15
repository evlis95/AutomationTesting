package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagAdOfTagC {
    @XmlElement(name = "a")
    List<TagAOfTagAd> listA;

    public List<TagAOfTagAd> getListA() {
        return listA;
    }

    @Override
    public String toString() {
        return "TagAdOfTagC{" +
                "listA=" + listA +
                '}';
    }
}
