package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagAccountInfoOfTagUnivRes {
    @XmlElement(name = "a")
    private List<TagAGeneralForList> listA;

    public List<TagAGeneralForList> getListA() {
        return listA;
    }

    @Override
    public String toString() {
        return "TagAccountInfoOfTagUnivRes{" +
                "listA=" + listA +
                '}';
    }
}
