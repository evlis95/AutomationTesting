package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
@Getter
public class TagVOfTagUnivRes {
    @XmlAttribute
    private String depAdv;
    @XmlAttribute
    private String aPay;
    @XmlAttribute
    private String addAcc;
    @XmlAttribute
    private String adv;
    @XmlAttribute
    private String backpay;
    @XmlAttribute
    private String bn;
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String cc;
    @XmlAttribute
    private String cr;
    @XmlAttribute
    private String ctr;
    @XmlAttribute
    private String curracc;
    @XmlAttribute
    private String dcc;
    @XmlAttribute
    private String dep;
    @XmlAttribute
    private String dfb;
    @XmlAttribute
    private String docflow;
    @XmlAttribute
    private String dtb;
    @XmlAttribute
    private String exch;
    @XmlAttribute
    private String f;
    @XmlAttribute
    private String gPay;
    @XmlAttribute
    private String info;
    @XmlAttribute
    private String minBalance;
    @XmlAttribute
    private String newqr;
    @XmlAttribute
    private String offer;
    @XmlAttribute
    private String paybc;
    @XmlAttribute
    private String pc;
    @XmlAttribute
    private String ph;
    @XmlAttribute
    private String push;
    @XmlAttribute
    private String req;
    @XmlAttribute
    private String sPay;
    @XmlAttribute
    private String sm;
    @XmlAttribute
    private String sv;
    @XmlAttribute
    private String warn;
    @XmlElementWrapper(name = "contracts")
    @XmlElement(name = "contract")
    private List<TagContractOfTagContracts> listContract;
}
