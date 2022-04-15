package com.automation_testing.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagAOfTagP {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String f;

    public TagAOfTagP(String a, String f) {
        this.a = a;
        this.f = f;
    }

    public TagAOfTagP(String a) {
        this.a = a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setF(String f) {
        this.f = f;
    }
}
