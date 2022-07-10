package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagOrgOfTagPersonInfo {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String ps;
    @XmlElement(name = "ulk")
    private List<TagUlkOfTagOrg> listULK;
}
