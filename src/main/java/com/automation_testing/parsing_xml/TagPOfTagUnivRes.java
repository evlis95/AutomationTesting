package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagPOfTagUnivRes {
    @XmlAttribute
    private String b;
    @XmlElement
    private String c;
    @XmlElement
    private String l;
    @XmlElement(name = "r")
    private List<TagROfTagP> listR;
    @XmlAttribute
    private String a;
}
