package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagAOfTagAd {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String tr;
}
