package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagPersonInfoOfTagUnivRes {
    @XmlElement(name = "org")
    private List<TagOrgOfTagPersonInfo> listOrg;

    public List<TagOrgOfTagPersonInfo> getListOrg() {
        return listOrg;
    }

    @Override
    public String toString() {
        return "TagPersonInfoOfTagUnivRes{" +
                "listOrg=" + listOrg +
                '}';
    }
}
