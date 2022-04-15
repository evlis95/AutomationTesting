package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagContractOfTagContracts {
    @XmlAttribute
    private String contractId;
    @XmlAttribute
    private String date;
    @XmlAttribute
    private String num;
    @XmlAttribute
    private String tar;
    @XmlAttribute
    private String tariff;

    public String getContractId() {
        return contractId;
    }

    public String getDate() {
        return date;
    }

    public String getNum() {
        return num;
    }

    public String getTar() {
        return tar;
    }

    public String getTariff() {
        return tariff;
    }

    @Override
    public String toString() {
        return "TagContractOfTagContracts{" +
                "contractId='" + contractId + '\'' +
                ", date='" + date + '\'' +
                ", num='" + num + '\'' +
                ", tar='" + tar + '\'' +
                ", tariff='" + tariff + '\'' +
                '}';
    }
}
