package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagCOfTagD {
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String v;
}
