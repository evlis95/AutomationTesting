package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagSDKOfTagSettings {
    @XmlAttribute
    private String sdka;
    @XmlAttribute
    private String sdki;
}
