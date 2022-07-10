package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@Getter
public class TagUserSettingsOfTagUnivRes {
    @XmlElement(name = "corpcards")
    private TagCorpCardsOfTagUnivRes tagCorpCards;
    @XmlElement(name = "freedocstobank")
    private TagFreeDocsToBankOfTagUnivRes tagFreeDocsToBank;
    @XmlElement(name = "servManagement")
    private TagServManagementOfTagUnivRes tagServManagement;
}
