package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
@Getter
public class TagVOfTagUnivRes {
    @XmlAttribute
    private String f;
    @XmlAttribute
    private String c;

}
