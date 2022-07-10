package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagUIOfTagUnivRes {
    @XmlAttribute
    private String e;
    @XmlAttribute
    private String f;
    @XmlAttribute
    private String p;
}
