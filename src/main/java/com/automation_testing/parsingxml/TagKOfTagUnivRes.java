package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagKOfTagUnivRes {
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String k;
    @XmlAttribute
    private String p;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String u;
}
