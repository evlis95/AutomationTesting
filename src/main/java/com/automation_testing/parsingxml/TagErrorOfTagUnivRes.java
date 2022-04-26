package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagErrorOfTagUnivRes {
    @XmlAttribute
    private String field;
    @XmlAttribute
    private String message;
    @XmlAttribute
    private String type;
}
