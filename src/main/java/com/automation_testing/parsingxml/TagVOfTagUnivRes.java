package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

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

    public List<TagContractOfTagContracts> getListContract() {
        return listContract;
    }

    public String getaPay() {
        return aPay;
    }

    public String getAddAcc() {
        return addAcc;
    }

    public String getAdv() {
        return adv;
    }

    public String getBackpay() {
        return backpay;
    }

    public String getBn() {
        return bn;
    }

    public String getC() {
        return c;
    }

    public String getCc() {
        return cc;
    }

    public String getCr() {
        return cr;
    }

    public String getCtr() {
        return ctr;
    }

    public String getCurracc() {
        return curracc;
    }

    public String getDcc() {
        return dcc;
    }

    public String getDep() {
        return dep;
    }

    public String getDfb() {
        return dfb;
    }

    public String getDocflow() {
        return docflow;
    }

    public String getDtb() {
        return dtb;
    }

    public String getExch() {
        return exch;
    }

    public String getF() {
        return f;
    }

    public String getgPay() {
        return gPay;
    }

    public String getInfo() {
        return info;
    }

    public String getMinBalance() {
        return minBalance;
    }

    public String getNewqr() {
        return newqr;
    }

    public String getOffer() {
        return offer;
    }

    public String getPaybc() {
        return paybc;
    }

    public String getPc() {
        return pc;
    }

    public String getPh() {
        return ph;
    }

    public String getPush() {
        return push;
    }

    public String getReq() {
        return req;
    }

    public String getsPay() {
        return sPay;
    }

    public String getSm() {
        return sm;
    }

    public String getSv() {
        return sv;
    }

    public String getWarn() {
        return warn;
    }

    public String getDepAdv() {
        return depAdv;
    }
}
