package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagAtmDepPageOfTagUnivReq {
    @XmlElement(name = "a")
    private List<TagAGeneralForList> listA;
}
