package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagCreditsOfTagSettings {
    @XmlElement(name = "f")
    List<TagFForList> listF;
}