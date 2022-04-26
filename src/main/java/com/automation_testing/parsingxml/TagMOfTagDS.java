package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagMOfTagDS {
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String cNC;
    @XmlAttribute
    private String d;
    @XmlAttribute
    private String dNC;
    @XmlAttribute
    private String n;
    @XmlElement(name = "d")
    private List<TagDOfTagM> listD;
}
