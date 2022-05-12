package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagPOfTagUnivRes {
    @XmlAttribute
    private String b;
    @XmlElement
    private String c;
    @XmlElement
    private String l;
    @XmlElement(name = "r")
    private List<TagROfTagP> listR;
    @XmlAttribute
    private String a;
    @XmlAttribute
    private int h;
    @XmlAttribute
    private String u;
    @XmlAttribute
    private String j;
    @XmlAttribute
    private String i;
    @XmlAttribute
    private long k;
    @XmlAttribute
    private String g;
    @XmlAttribute(name = "l")
    private long atrL;
}
