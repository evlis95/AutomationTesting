package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagAboutPageOfTagUnivRes {
    @XmlElement(name = "a")
    private List<TagAGeneralForList> listA;

    public List<TagAGeneralForList> getListA() {
        return listA;
    }

    @Override
    public String toString() {
        return "TagAboutPageOfUnivRes{" +
                "listA=" + listA +
                '}';
    }
}
