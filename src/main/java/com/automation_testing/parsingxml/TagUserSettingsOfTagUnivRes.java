package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlElement;

public class TagUserSettingsOfTagUnivRes {
    @XmlElement(name = "corpcards")
    private TagCorpCardsOfTagUnivRes tagCorpCards;
    @XmlElement(name = "freedocstobank")
    private TagFreeDocsToBankOfTagUnivRes tagFreeDocsToBank;
    @XmlElement(name = "servManagement")
    private TagServManagementOfTagUnivRes tagServManagement;

    public TagCorpCardsOfTagUnivRes getTagCorpCards() {
        return tagCorpCards;
    }

    public TagFreeDocsToBankOfTagUnivRes getTagFreeDocsToBank() {
        return tagFreeDocsToBank;
    }

    public TagServManagementOfTagUnivRes getTagServManagement() {
        return tagServManagement;
    }

    @Override
    public String toString() {
        return "TagUserSettingsOfTagUnivRes{" +
                "tagCorpCards=" + tagCorpCards +
                ", tagFreeDocsToBank=" + tagFreeDocsToBank +
                ", tagServManagement=" + tagServManagement +
                '}';
    }
}
