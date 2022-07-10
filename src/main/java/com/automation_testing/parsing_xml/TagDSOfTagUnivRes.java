package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagDSOfTagUnivRes {
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String l;
    @XmlElement(name = "m")
    private List<TagMOfTagDS> listM;
    @XmlElement(name = "d")
    List<TagDOfTagDS> listD;
}
