package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagFForList {
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String v;
}
