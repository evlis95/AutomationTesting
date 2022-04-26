package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagAGeneralForList {

    @XmlAttribute
    private String k;
    @XmlAttribute
    private String v;
}
