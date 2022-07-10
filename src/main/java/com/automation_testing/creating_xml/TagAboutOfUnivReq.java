package com.automation_testing.creating_xml;

import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
public class TagAboutOfUnivReq {
    @XmlAttribute
    private String h;
    @XmlAttribute
    private String w;
}
