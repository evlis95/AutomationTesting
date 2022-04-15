package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagFreeDocsToBankOfTagUnivRes {
    @XmlElement(name = "f")
    private List<TagFForList> listF;

    public List<TagFForList> getListF() {
        return listF;
    }

    @Override
    public String toString() {
        return "TagFreeDocsToBank{" +
                "listF=" + listF +
                '}';
    }
}
