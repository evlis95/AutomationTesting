package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
@Getter
public class TagBOfTagUnivRes {
    @XmlAttribute(name = "a")
    private String a;
    @XmlAttribute(name = "b")
    private String b;
    @XmlAttribute(name = "dt")
    private String dt;
    @XmlAttribute(name = "e")
    private String e;
    @XmlAttribute(name = "i")
    private String i;
    @XmlAttribute(name = "n")
    private String n;
    @XmlAttribute(name = "p")
    private String p;
    @XmlAttribute(name = "s")
    private Integer s;
    @XmlAttribute(name = "t")
    private Integer t;
}
