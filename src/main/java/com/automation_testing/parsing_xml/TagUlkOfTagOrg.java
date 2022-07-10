package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
@Getter
public class TagUlkOfTagOrg {
    @XmlAttribute
    private String email;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String patr;
    @XmlAttribute
    private String phone;
    @XmlAttribute
    private String surname;
}
