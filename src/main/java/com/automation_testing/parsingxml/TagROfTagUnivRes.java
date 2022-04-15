package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

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

    public String getA() {
        return a;
    }

    public String getD() {
        return d;
    }

    public String getK() {
        return k;
    }

    public String getS() {
        return s;
    }

    public String getF() {
        return f;
    }

    public String getG() {
        return g;
    }

    public String getSn() {
        return sn;
    }

    public String getC() {
        return c;
    }

    public String getI() {
        return i;
    }

    public String getO() {
        return o;
    }

    public String getT() {
        return t;
    }

    public String getY() {
        return y;
    }

    public String getB() {
        return b;
    }

    public String getGbn() {
        return gbn;
    }

    public String getJ() {
        return j;
    }

    public String getN() {
        return n;
    }

    public String getQ() {
        return q;
    }

    public String getQq() {
        return qq;
    }

    public String getV() {
        return v;
    }

    public String getW() {
        return w;
    }

    public String getX() {
        return x;
    }

    public String getZ() {
        return z;
    }

    public List<TagCorrAccOfTagR> getTagCorrAcc() {
        return tagCorrAcc;
    }

    public String getH() {
        return h;
    }
}
