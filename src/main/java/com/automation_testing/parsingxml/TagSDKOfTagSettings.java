package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagSDKOfTagSettings {
    @XmlAttribute
    private String sdka;
    @XmlAttribute
    private String sdki;

    public String getSdka() {
        return sdka;
    }

    public String getSdki() {
        return sdki;
    }

    @Override
    public String toString() {
        return "TagSDKOfTagSettings{" +
                "sdka='" + sdka + '\'' +
                ", sdki='" + sdki + '\'' +
                '}';
    }
}
