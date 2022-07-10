package com.automation_testing.parsing_xml;

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
