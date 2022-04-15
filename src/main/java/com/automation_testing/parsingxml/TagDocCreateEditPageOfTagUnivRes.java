package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagDocCreateEditPageOfTagUnivRes {
    @XmlElement(name = "a")
    private List<TagAGeneralForList> listA;

    public List<TagAGeneralForList> getListA() {
        return listA;
    }

    @Override
    public String toString() {
        return "TagDocCreateEditPageOfUnivRes{" +
                "listA=" + listA +
                '}';
    }
}
