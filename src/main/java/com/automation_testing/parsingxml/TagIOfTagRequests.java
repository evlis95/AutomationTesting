package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagIOfTagRequests {

    @XmlAttribute
    private String c;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String v;

    public String getC() {
        return c;
    }

    public String getN() {
        return n;
    }

    public String getT() {
        return t;
    }

    public String getV() {
        return v;
    }

    @Override
    public String toString() {
        return "TagIOfTagRequests{" +
                "c='" + c + '\'' +
                ", n='" + n + '\'' +
                ", t='" + t + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
