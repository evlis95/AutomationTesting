package com.autotest.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagFOfTagP {
    @XmlAttribute
    private String g;
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String e;
    @XmlElement(name = "s")
    List<TagSOfTagF> listS;

    public TagFOfTagP(String b, String e) {
        this.b = b;
        this.e = e;
    }

    public TagFOfTagP(String s, String t, List<TagSOfTagF> listS) {
        this.s = s;
        this.t = t;
        this.listS = listS;
    }

    public TagFOfTagP() {
    }

    public void setG(String g) {
        this.g = g;
    }

    public void setListS(List<TagSOfTagF> listS) {
        this.listS = listS;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setT(String t) {
        this.t = t;
    }
}
