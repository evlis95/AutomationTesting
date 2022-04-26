package com.automation_testing.parsingxml;

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
