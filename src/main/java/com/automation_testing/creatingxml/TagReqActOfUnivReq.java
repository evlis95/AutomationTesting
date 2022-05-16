package com.automation_testing.creatingxml;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagReqActOfUnivReq {
    @XmlAttribute
    private String v;
    @XmlAttribute(name = "DocID")
    private String DocID;
    @XmlAttribute
    private String cm;

    public TagReqActOfUnivReq(String v) {
        this.v = v;
    }

    public TagReqActOfUnivReq(String v, String cm) {
        this.v = v;
        this.cm = cm;
    }
}
