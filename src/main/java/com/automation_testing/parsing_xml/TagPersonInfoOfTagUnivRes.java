package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagPersonInfoOfTagUnivRes {
    @XmlElement(name = "org")
    private List<TagOrgOfTagPersonInfo> listOrg;
}
