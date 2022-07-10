package com.automation_testing.creating_xml;

import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;
@Setter
@XmlRootElement(name = "R")
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
}
