package com.automation_testing.creatingxml;

import com.automation_testing.parsingxml.TagCOfTagF;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Setter
@NoArgsConstructor
public class TagFOfTagP {
    @XmlAttribute
    private String o;
    @XmlAttribute
    private String w;
    @XmlAttribute
    private String g;
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String t;
    @XmlAttribute
    private String b;
    @XmlAttribute
    private String e;
    @XmlAttribute
    private String phone;
    @XmlAttribute
    private String tspId;
    @XmlAttribute
    private String fromDate;
    @XmlAttribute
    private String toDate;
    @XmlAttribute
    private String minAmount;
    @XmlAttribute
    private String maxAmount;
    @XmlElement(name = "s")
    private List<TagSOfTagF> listS;
    @XmlElement(name = "a")
    private List<TagAOfTagF> listA;
    @XmlElement(name = "g")
    private TagGOfTagF tagG;
    @XmlElement(name = "t")
    private TagTOfTagF tagT;
    @XmlElement(name = "c")
    private TagCOfTagF tagC;


    public TagFOfTagP(String b, String e) {
        this.b = b;
        this.e = e;
    }

    public TagFOfTagP(String s, String t, List<TagSOfTagF> listS) {
        this.s = s;
        this.t = t;
        this.listS = listS;
    }
}
