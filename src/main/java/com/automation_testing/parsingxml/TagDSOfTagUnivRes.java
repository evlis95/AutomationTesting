package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Getter
public class TagDSOfTagUnivRes {
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String l;
    @XmlElement(name = "m")
    private List<TagMOfTagDS> listM;
    @XmlElement(name = "d")
    List<TagDOfTagDS> listD;
}
