package com.autotest.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

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
    List<TagAOfTagP> listA;
    @XmlElement(name = "c")
    List<TagCOfTagP> listC;
    @XmlElement(name = "t")
    List<TagTOfTagP> listT;
    @XmlElement(name = "f")
    List<TagFOfTagP> listF;
    @XmlElement(name = "f")
    TagFOfTagP tagF;



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

    public TagPOfUnivReq() {
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

    public void setTagF(TagFOfTagP tagF) {
        this.tagF = tagF;
    }

    public void setDeviceos(String deviceos) {
        this.deviceos = deviceos;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setLangid(String langid) {
        this.langid = langid;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setT(String t) {
        this.t = t;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setApc(String apc) {
        this.apc = apc;
    }

    public void setApv(String apv) {
        this.apv = apv;
    }

    public void setI(String i) {
        this.i = i;
    }

    public void setM(String m) {
        this.m = m;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOsv(String osv) {
        this.osv = osv;
    }

    public void setOsvk(String osvk) {
        this.osvk = osvk;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public void setTermsDate(String termsDate) {
        this.termsDate = termsDate;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setG(String g) {
        this.g = g;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setP(String p) {
        this.p = p;
    }

    public void setN(String n) {
        this.n = n;
    }

    public void setR(String r) {
        this.r = r;
    }

    public void setV(String v) {
        this.v = v;
    }

    public void setListA(List<TagAOfTagP> listA) {
        this.listA = listA;
    }

    public void setListC(List<TagCOfTagP> listC) {
        this.listC = listC;
    }

    public void setListT(List<TagTOfTagP> listT) {
        this.listT = listT;
    }

    public void setListF(List<TagFOfTagP> listF) {
        this.listF = listF;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public void setDnm(String dnm) {
        this.dnm = dnm;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public void setDph(String dph) {
        this.dph = dph;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setPcpushid(String pcpushid) {
        this.pcpushid = pcpushid;
    }

    public void setPushid(String pushid) {
        this.pushid = pushid;
    }
}
