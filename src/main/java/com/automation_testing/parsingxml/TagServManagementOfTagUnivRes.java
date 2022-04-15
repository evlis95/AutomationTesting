package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagServManagementOfTagUnivRes {
    @XmlElement(name = "f")
    private List<TagFForList> listF;

    public List<TagFForList> getListF() {
        return listF;
    }

    @Override
    public String toString() {
        return "TagServManagementOfTagUnivRes{" +
                "listF=" + listF +
                '}';
    }
}
