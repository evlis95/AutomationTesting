package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagDOfTagConfirmation {
    @XmlAttribute
    private String d;
    @XmlAttribute
    private String sign;
    @XmlAttribute
    private String type;
}
