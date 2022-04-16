package com.automation_testing.creatingxml;

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

    public TagReqActOfUnivReq(String v, String docID) {
        this.v = v;
        DocID = docID;
    }

    public TagReqActOfUnivReq() {
    }

    public TagReqActOfUnivReq(String v) {
        this.v = v;
    }
}
