package com.automation_testing.creating_xml;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@AllArgsConstructor
public class TagBROfTagT {
    @XmlAttribute
    private String id;
}