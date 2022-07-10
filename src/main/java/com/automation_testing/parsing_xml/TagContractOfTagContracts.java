package com.automation_testing.parsing_xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
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
}
