package com.automation_testing.creatingxml;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Setter
@NoArgsConstructor
public class TagFOfTagP {
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
    @XmlElement(name = "s")
    List<TagSOfTagF> listS;

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
