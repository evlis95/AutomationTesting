package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagIOfTagUnivRes {
    @XmlAttribute
    private String w;
    @XmlAttribute
    private String sbpreg;
    @XmlAttribute
    private String sbpacc;
}
