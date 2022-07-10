package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@XmlRootElement(name = "A")
public class UniversalResponseRootTag {
    @XmlElement(name = "requests")
    private TagRequestsOfTagUnivResp tagRequests;
    @XmlElement(name = "loginPage")
    private TagLoginPageOfTagUnivRes tagLoginPage;
    @XmlElement(name = "global")
    private TagGlobalOfTagUnivRes tagGlobal;
    @XmlElement(name = "menuPage")
    private TagMenuPageOfTagUnivRes tagMenuPage;
    @XmlElement(name = "filterPage")
    private TagFilterPageOfTagUnivRes tagFilterPage;
    @XmlElement(name = "chatPage")
    private TagChatPageOfTagUnivRes tagChatPage;
    @XmlElement(name = "docCreateEditPage")
    private TagDocCreateEditPageOfTagUnivRes tagDocCreateEditPage;
    @XmlElement(name = "docViewPage")
    private TagDocViewPageOfTagUnivRes tagDocViewPage;
    @XmlElement(name = "aboutPage")
    private TagAboutPageOfTagUnivRes tagAboutPage;
    @XmlElement(name = "atmDepPage")
    private TagAtmDepPageOfTagUnivReq tagAtmDepPage;
    @XmlElement(name = "accountInfo")
    private TagAccountInfoOfTagUnivRes tagAccountInfo;
    @XmlElement(name = "corpCardPage")
    private TagCorpCardPageOfTagUnivRes tagCorpCardPage;
    @XmlElement(name = "depositLightPage")
    private TagDepositLightPageOfTagUnivRes tagDepositLightPage;
    @XmlElement(name = "hash")
    private TagHashOfTagUnivRes tagHash;
    @XmlElement(name = "languages")
    private TagLanguagesOfTagUnivRes tagLanguages;
    @XmlElement(name = "localization")
    private TagLocalizationOfTagUnivRes tagLocalization;
    @XmlElement(name = "b")
    private TagBOfTagUnivRes tagB;
    @XmlElement(name = "l")
    private TagLOfTagUnivRes tagL;
    @XmlElement(name = "s")
    private List<TagSOfUnivRes> listS;
    @XmlElement(name = "c")
    private List<TagCOfTagUnivRes> listC;
    @XmlElement(name = "u")
    private TagUOfUnivRes tagU;
    @XmlElement(name = "settings")
    private TagSettingsOfTafUnivRes tagSettings;
    @XmlElement(name = "webim")
    private TagWebimOfTagUnivRes tagWebim;
    @XmlElement(name = "fp")
    private TagFPOfTagUnivRes tagFP;
    @XmlElement(name = "lastAuth")
    private TagLastAuthOfTagUnivRes tagLastAuth;
    @XmlElement(name = "usersettings")
    private TagUserSettingsOfTagUnivRes tagUserSettings;
    @XmlElement(name = "personInfo")
    private TagPersonInfoOfTagUnivRes tagPersonInfo;
    @XmlElement(name = "d")
    private List<TagDOfTafUnivRes> listD;
    @XmlElement(name = "f")
    private List<TagFOfTagUnivRes> listF;
    @XmlElement(name = "v")
    private List<TagVOfTagUnivRes> listV;
    @XmlElement(name = "a")
    private List<TagAOfTagUnivRes> listA;
    @XmlElement(name = "ds")
    private List<TagDSOfTagUnivRes> listDS;
    @XmlElement(name = "page")
    private List<TagPageOfTagUnivRes> listPage;
    @XmlElement(name = "r")
    private List<TagROfTagUnivRes> listR;
    @XmlElement(name = "p")
    private List<TagPOfTagUnivRes> listP;
    @XmlElement(name = "k")
    private List<TagKOfTagUnivRes> listK;
    @XmlElement(name = "d")
    private String d;
    @XmlElementWrapper(name = "errorList")
    @XmlElement(name = "error")
    private List<TagErrorOfTagUnivRes> listError;
}

