package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
public class TagFOfTagLanguages {
    @XmlAttribute
    private String hash;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String in;
    @XmlAttribute
    private String md;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String sl;
    @XmlAttribute
    private String sn;
}
