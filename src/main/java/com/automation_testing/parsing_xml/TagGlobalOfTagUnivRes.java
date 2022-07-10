package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagGlobalOfTagUnivRes {
    @XmlElement(name = "a")
    private List<TagAGeneralForList> listA;
}
