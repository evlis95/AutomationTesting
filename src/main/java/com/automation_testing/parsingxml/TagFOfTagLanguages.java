package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagFOfTagLanguages {
    @XmlAttribute
    private String hash;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String in;
    @XmlAttribute
    private String md;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String sl;
    @XmlAttribute
    private String sn;

    public String getHash() {
        return hash;
    }

    public String getId() {
        return id;
    }

    public String getIn() {
        return in;
    }

    public String getMd() {
        return md;
    }

    public String getN() {
        return n;
    }

    public String getSl() {
        return sl;
    }

    public String getSn() {
        return sn;
    }

    @Override
    public String toString() {
        return "TagFOfTagLanguages{" +
                "hash='" + hash + '\'' +
                ", id='" + id + '\'' +
                ", in='" + in + '\'' +
                ", md='" + md + '\'' +
                ", n='" + n + '\'' +
                ", sl='" + sl + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }
}
