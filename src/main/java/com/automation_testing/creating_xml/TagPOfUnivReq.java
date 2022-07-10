package com.automation_testing.creating_xml;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Setter
@NoArgsConstructor
public class TagPOfUnivReq {

    @XmlAttribute
    private String deviceos;
    @XmlAttribute
    private String hash;
    @XmlAttribute
    private String langid;
    @XmlAttribute
    private String d;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String login;
    @XmlAttribute
    private String pass;
    @XmlAttribute
    private String apc;
    @XmlAttribute
    private String apv;
    @XmlAttribute
    private String i;
    @XmlAttribute
    private String m;
    @XmlAttribute
    private String model;
    @XmlAttribute
    private String osv;
    @XmlAttribute
    private String osvk;
    @XmlAttribute
    private String pn;
    @XmlAttribute
    private String termsDate;
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String e;
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String p;
    @XmlAttribute
    private String card;
    @XmlAttribute
    private String g;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String r;
    @XmlAttribute
    private String v;
    @XmlAttribute
    private String did;
    @XmlAttribute
    private String dnm;
    @XmlAttribute
    private String ms;
    @XmlAttribute
    private String dph;
    @XmlAttribute
    private String os;
    @XmlAttribute
    private String pcpushid;
    @XmlAttribute
    private String pushid;
    @XmlElement(name = "a")
    private List<TagAOfTagP> listA;
    @XmlElement(name = "c")
    private List<TagCOfTagP> listC;
    @XmlElement(name = "c")
    private TagCOfTagP tagC;
    @XmlElement(name = "t")
    private List<TagTOfTagP> listT;
    @XmlElement(name = "t")
    private TagTOfTagP tagT;
    @XmlElement(name = "f")
    private List<TagFOfTagP> listF;
    @XmlElement(name = "f")
    private TagFOfTagP tagF;


    public TagPOfUnivReq(String i) {
        this.i = i;
    }

    public TagPOfUnivReq(String deviceos, String hash, String langid) {
        this.deviceos = deviceos;
        this.hash = hash;
        this.langid = langid;
    }

    public TagPOfUnivReq(String d, String t) {
        this.d = d;
        this.t = t;
    }

    public TagPOfUnivReq(TagFOfTagP tagF) {
        this.tagF = tagF;
    }

    public TagPOfUnivReq(String p, String g, List<TagAOfTagP> listA, TagFOfTagP tagF) {
        this.p = p;
        this.g = g;
        this.listA = listA;
        this.tagF = tagF;
    }

    public TagPOfUnivReq(String g, String p, List<TagTOfTagP> listT, List<TagFOfTagP> listF) {
        this.g = g;
        this.p = p;
        this.listT = listT;
        this.listF = listF;
    }
}
