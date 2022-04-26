package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Getter
public class TagROfTagUnivRes {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String d;
    @XmlAttribute
    private String k;
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String f;
    @XmlAttribute
    private String g;
    @XmlAttribute
    private String sn;
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String i;
    @XmlAttribute
    private String o;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String y;
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String gbn;
    @XmlAttribute
    private String j;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String q;
    @XmlAttribute
    private String qq;
    @XmlAttribute
    private String v;
    @XmlAttribute
    private String w;
    @XmlAttribute
    private String x;
    @XmlAttribute
    private String z;
    @XmlAttribute
    private String h;
    @XmlElementWrapper(name = "corraccounts")
    @XmlElement(name = "corracc")
    private List<TagCorrAccOfTagR> tagCorrAcc;
}
