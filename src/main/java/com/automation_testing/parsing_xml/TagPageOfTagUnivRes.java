package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagPageOfTagUnivRes {
    @XmlElement(name = "r")
    private List<TagROfTagPage> listR;
    @XmlAttribute
    private String n;
}
