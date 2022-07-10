package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagDOfTagDS {
    @XmlElement(name = "f")
    private List<TagFOfTagD> listF;
}
