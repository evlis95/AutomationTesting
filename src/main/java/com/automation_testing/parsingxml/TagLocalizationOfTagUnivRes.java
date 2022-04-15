package com.autotest.parsingxml;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagLocalizationOfTagUnivRes {
    @XmlElement(name = "page")
    private List<TagPageOfTagLocalization> listPage;

    public List<TagPageOfTagLocalization> getListPage() {
        return listPage;
    }

    @Override
    public String toString() {
        return "TagLocalizationOfTagUnivRes{" +
                "listPage=" + listPage +
                '}';
    }
}
