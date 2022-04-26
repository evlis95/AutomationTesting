package com.automation_testing.parsingxml;

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
