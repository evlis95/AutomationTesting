package com.autotest.creatingxml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "R")
@XmlAccessorType(XmlAccessType.NONE)
public class UniversalRequestRootTag {
    @XmlAttribute
    private double v;
    @XmlAttribute
    private String c;
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String s;

    @XmlElement(name = "RequestedAction")
    private TagReqActOfUnivReq tagReqAct;
    @XmlElement(name = "p")
    private List<TagPOfUnivReq> listP;
    @XmlElement(name = "p")
    private TagPOfUnivReq tagP;
    @XmlElement(name = "about")
    private TagAboutOfUnivReq tagAbout;
    @XmlElement(name = "hash")
    private String tagHash;
    @XmlElement(name = "u")
    private String tagU;

    @XmlElement(name = "c")
    private String tagC;
    @XmlElement(name = "p")
    private String p;
    @XmlElement(name = "u")
    private String u;

    public void setS(String s) {
        this.s = s;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setT(String t) {
        this.t = t;
    }

    public void setN(String n) {
        this.n = n;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void setListP(List<TagPOfUnivReq> listP) {
        this.listP = listP;
    }

    public void setTagAbout(TagAboutOfUnivReq tagAbout) {
        this.tagAbout = tagAbout;
    }

    public void setTagHash(String tagHash) {
        this.tagHash = tagHash;
    }

    public void setTagU(String tagU) {
        this.tagU = tagU;
    }

    public void setTagReqAct(TagReqActOfUnivReq tagReqAct) {
        this.tagReqAct = tagReqAct;
    }

    public void setTagC(String tagC) {
        this.tagC = tagC;
    }

    public void setP(String p) {
        this.p = p;
    }

    public void setU(String u) {
        this.u = u;
    }

    public void setTagP(TagPOfUnivReq tagP) {
        this.tagP = tagP;
    }
}
