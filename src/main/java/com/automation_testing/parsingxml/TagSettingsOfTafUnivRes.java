package com.automation_testing.parsingxml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
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
}
