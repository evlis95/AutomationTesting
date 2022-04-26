package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagCOfTagD {
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String v;
}
