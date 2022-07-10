package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagPageOfTagLocalization {
    @XmlAttribute
    private String n;
    @XmlElement(name = "f")
    private List<TagFOfTagPage> listF;
}
