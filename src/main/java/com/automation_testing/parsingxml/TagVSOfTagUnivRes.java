package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagVSOfTagUnivRes {
    @XmlAttribute
    private String f;
    @XmlAttribute
    private String c;

}