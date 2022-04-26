package com.automation_testing.parsingxml;

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
