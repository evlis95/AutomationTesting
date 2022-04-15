package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagRequestsOfTagUnivResp {
    @XmlElement(name = "i")
    private List<TagIOfTagRequests> listTagI;

    public List<TagIOfTagRequests> getListTagI() {
        return listTagI;
    }

    @Override
    public String toString() {
        return "TagRequestsOfTagUnivResp{" +
                "listTagI=" + listTagI +
                '}';
    }
}
