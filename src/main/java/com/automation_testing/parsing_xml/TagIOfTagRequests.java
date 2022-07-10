package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagIOfTagRequests {
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String v;
}
