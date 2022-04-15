package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

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

    public String getCe() {
        return ce;
    }

    public List<TagFForList> getListF() {
        return listF;
    }

    public TagAdOfTagC getTagAd() {
        return tagAd;
    }

    public TagConfirmationOfTagC getTagConfirmation() {
        return tagConfirmation;
    }

    public String getA() {
        return a;
    }

    public String getAa() {
        return aa;
    }

    public String getAs() {
        return as;
    }

    public String getCc() {
        return cc;
    }

    public String getCh() {
        return ch;
    }

    public String getCr() {
        return cr;
    }

    public String getCt() {
        return ct;
    }

    public String getE() {
        return e;
    }

    public String getEr() {
        return er;
    }

    public String getErdt() {
        return erdt;
    }

    public String getFb() {
        return fb;
    }

    public String getI() {
        return i;
    }

    public String getIdsbp() {
        return idsbp;
    }

    public String getLi() {
        return li;
    }

    public String getLp() {
        return lp;
    }

    public String getM() {
        return m;
    }

    public String getN() {
        return n;
    }

    public String getOkpo() {
        return okpo;
    }

    public String getOu() {
        return ou;
    }

    public String getPh() {
        return ph;
    }

    public String getQ() {
        return q;
    }

    public String getR() {
        return r;
    }

    public String getSv() {
        return sv;
    }

    public String getTb() {
        return tb;
    }

    public String getW() {
        return w;
    }

    public String getZku() {
        return zku;
    }


}
