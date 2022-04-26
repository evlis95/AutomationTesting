package com.automation_testing.parsingxml;

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
