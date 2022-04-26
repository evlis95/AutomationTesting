package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagDOfTafUnivRes {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String i;
    @XmlAttribute
    private String p;
    @XmlAttribute
    private String pc;
    @XmlAttribute
    private String pm;
    @XmlAttribute
    private String ti;
    @XmlAttribute
    private String count;
    @XmlAttribute
    private String type;
    @XmlElement(name = "c")
    private List<TagCOfTagD> listC;
}
