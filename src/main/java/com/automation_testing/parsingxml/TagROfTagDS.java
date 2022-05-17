package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
@Getter
public class TagROfTagDS {
    @XmlAttribute
    private String idmemsbp;
    @XmlAttribute
    private String namemem;
    @XmlAttribute
    private String nameint;
    @XmlAttribute
    private String bic;
    @XmlAttribute
    private String orgId;
    @XmlAttribute
    private String idtsp;
    @XmlAttribute
    private String nametsp;
    @XmlAttribute
    private String dttsp;
    @XmlAttribute
    private String usermerch;
    @XmlAttribute
    private String mcc;
    @XmlAttribute
    private String city;
    @XmlAttribute
    private String add;
    @XmlAttribute
    private String cpn;
}
