package com.automation_testing.creating_xml;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@AllArgsConstructor
@Setter
public class TagAOfTagF {
    @XmlAttribute
    private String a;

}
