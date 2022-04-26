package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class TagLanguagesOfTagUnivRes {
    @XmlElement(name = "f")
    private List<TagFOfTagLanguages> listF;
}
