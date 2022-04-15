package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagDSOfTagUnivRes {
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String l;
    @XmlElement(name = "m")
    private List<TagMOfTagDS> listM;

    public String getB() {
        return b;
    }

    public String getL() {
        return l;
    }

    public List<TagMOfTagDS> getListM() {
        return listM;
    }
}
