package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagCOfTagUnivRes {
    @XmlElement(name = "f")
    List<TagFForList> listF;
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String aa;
    @XmlAttribute
    private String as;
    @XmlAttribute
    private String cc;
    @XmlAttribute
    private String ch;
    @XmlAttribute
    private String cr;
    @XmlAttribute
    private String ct;
    @XmlAttribute
    private String e;
    @XmlAttribute
    private String er;
    @XmlAttribute
    private String erdt;
    @XmlAttribute
    private String fb;
    @XmlAttribute
    private String i;
    @XmlAttribute
    private String idsbp;
    @XmlAttribute
    private String li;
    @XmlAttribute
    private String lp;
    @XmlAttribute
    private String m;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String okpo;
    @XmlAttribute
    private String ou;
    @XmlAttribute
    private String ph;
    @XmlAttribute
    private String q;
    @XmlAttribute
    private String r;
    @XmlAttribute
    private String ce;
    @XmlAttribute
    private String sv;
    @XmlAttribute
    private String tb;
    @XmlAttribute
    private String w;
    @XmlAttribute
    private String zku;
    @XmlElement(name = "ad")
    private TagAdOfTagC tagAd;
    @XmlElement(name = "confirmation")
    private TagConfirmationOfTagC tagConfirmation;
}
