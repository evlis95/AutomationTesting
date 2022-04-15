package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagDocFromBankOfTagSettings {
    @XmlElement(name = "f")
    List<TagFForList> listF;

    public List<TagFForList> getListF() {
        return listF;
    }

    @Override
    public String toString() {
        return "TagAccountsOfTagSettings{" +
                "listF=" + listF +
                '}';
    }
}
