package com.autotest.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagReqActOfUnivReq {
    @XmlAttribute
    private String v;
    @XmlAttribute(name = "DocID")
    private String DocID;

    public void setV(String v) {
        this.v = v;
    }

    public void setDocID(String DocID) {
        this.DocID = DocID;
    }
}
