package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TagSettingsOfTafUnivRes {
    @XmlAttribute
    private String CheckPIN;
    @XmlAttribute
    private String banksOnMap;
    @XmlAttribute
    private String currEx;
    @XmlAttribute
    private String skipEnterDeviceName;
    @XmlAttribute
    private String urlTariffs;
    @XmlElement(name = "corpcard")
    private TagCorpCardOfTagSettings tagCorpCard;
    @XmlElement(name = "chat")
    private TagChatOfTagSettings tagChat;
    @XmlElement(name = "freeDocToBank")
    private TagFreeDocToBankOfTagSettings tagFreeDocToBank;
    @XmlElement(name = "law")
    private TagLawOfTagSettings tagLaw;
    @XmlElement(name = "statement")
    private TagStatementOfTagSettings tagStatement;
    @XmlElement(name = "smscrypto")
    private TagSmsCryptoOfTagSettings tagSmsCrypto;
    @XmlElement(name = "accounts")
    private TagAccountsOfTagSettings tagAccounts;
    @XmlElement(name = "ui")
    private TagUIOfTagSettings tagUI;
    @XmlElement(name = "paymentOrder")
    private TagPayControlOfTagSettings tagPaymentOrder;
    @XmlElement(name = "auth")
    private TagAuthOfTagSettings tagAuth;
    @XmlElement(name = "paycontrol")
    private TagPayControlOfTagSettings tagPayControl;
    @XmlElement(name = "commonPush")
    private TagCommonPushOfTagSettings tagCommonPush;
    @XmlElement(name = "trustedDevice")
    private TagTrustedDeviceOfTagSettings tagTrustedDevice;
    @XmlElement(name = "restoreAuthAccess")
    private TagRestoreAuthAccessOfTagSettings tagRestoreAuthAccess;
    @XmlElement(name = "menu")
    private TagMenuOfTagSettings tagMenu;
    @XmlElement(name = "licence")
    private TagLicenceOfTagSettings tagLicence;
    @XmlElement(name = "onlineCurConv")
    private TagOnlineCurConvOfTagSettings tagOnlineCurConv;
    @XmlElement(name = "sdk")
    private TagSDKOfTagSettings tagSDK;
    @XmlElement(name = "tariffs")
    private TagTariffsOfTagSettings tagTariffs;
    @XmlElement(name = "systemFastPay")
    private TagSystemFastpayOfTagSettings tagSystemFastPay;
    @XmlElement(name = "investments")
    private TagInvestmentsOfTagSettings tagInvestments;
    @XmlElement(name = "credits")
    private TagCreditsOfTagSettings tagCredits;
    @XmlElement(name = "docfrombank")
    private TagDocFromBankOfTagSettings tagDocFromBank;
    @XmlElement(name = "servManagement")
    private TagServManagementOfTagSettings tagServManagement;

    public String getCheckPIN() {
        return CheckPIN;
    }

    public String getBanksOnMap() {
        return banksOnMap;
    }

    public String getCurrEx() {
        return currEx;
    }

    public String getSkipEnterDeviceName() {
        return skipEnterDeviceName;
    }

    public String getUrlTariffs() {
        return urlTariffs;
    }

    public TagCorpCardOfTagSettings getTagCorpCard() {
        return tagCorpCard;
    }

    public TagChatOfTagSettings getTagChat() {
        return tagChat;
    }

    public TagFreeDocToBankOfTagSettings getTagFreeDocToBank() {
        return tagFreeDocToBank;
    }

    public TagLawOfTagSettings getTagLaw() {
        return tagLaw;
    }

    public TagStatementOfTagSettings getTagStatement() {
        return tagStatement;
    }

    public TagSmsCryptoOfTagSettings getTagSmsCrypto() {
        return tagSmsCrypto;
    }

    public TagAccountsOfTagSettings getTagAccounts() {
        return tagAccounts;
    }

    public TagUIOfTagSettings getTagUI() {
        return tagUI;
    }

    public TagPayControlOfTagSettings getTagPaymentOrder() {
        return tagPaymentOrder;
    }

    public TagAuthOfTagSettings getTagAuth() {
        return tagAuth;
    }

    public TagPayControlOfTagSettings getTagPayControl() {
        return tagPayControl;
    }

    public TagCommonPushOfTagSettings getTagCommonPush() {
        return tagCommonPush;
    }

    public TagTrustedDeviceOfTagSettings getTagTrustedDevice() {
        return tagTrustedDevice;
    }

    public TagRestoreAuthAccessOfTagSettings getTagRestoreAuthAccess() {
        return tagRestoreAuthAccess;
    }

    public TagMenuOfTagSettings getTagMenu() {
        return tagMenu;
    }

    public TagLicenceOfTagSettings getTagLicence() {
        return tagLicence;
    }

    public TagOnlineCurConvOfTagSettings getTagOnlineCurConv() {
        return tagOnlineCurConv;
    }

    public TagSDKOfTagSettings getTagSDK() {
        return tagSDK;
    }

    public TagTariffsOfTagSettings getTagTariffs() {
        return tagTariffs;
    }

    public TagSystemFastpayOfTagSettings getTagSystemFastPay() {
        return tagSystemFastPay;
    }

    public TagInvestmentsOfTagSettings getTagInvestments() {
        return tagInvestments;
    }

    public TagCreditsOfTagSettings getTagCredits() {
        return tagCredits;
    }

    public TagDocFromBankOfTagSettings getTagDocFromBank() {
        return tagDocFromBank;
    }

    public TagServManagementOfTagSettings getTagServManagement() {
        return tagServManagement;
    }
}
