package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagLanguagesOfTagUnivRes {
    @XmlElement(name = "f")
    private List<TagFOfTagLanguages> listF;

    public List<TagFOfTagLanguages> getListF() {
        return listF;
    }

    @Override
    public String toString() {
        return "TagLanguagesOfTagUnivRes{" +
                "listF=" + listF +
                '}';
    }
}
