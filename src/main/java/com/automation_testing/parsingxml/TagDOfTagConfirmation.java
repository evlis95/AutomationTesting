package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagDOfTagConfirmation {

    @XmlAttribute
    private String d;
    @XmlAttribute
    private String sign;
    @XmlAttribute
    private String type;

    public String getD() {
        return d;
    }

    public String getSign() {
        return sign;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TagDOfTagConfirmation{" +
                "d='" + d + '\'' +
                ", sign='" + sign + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
