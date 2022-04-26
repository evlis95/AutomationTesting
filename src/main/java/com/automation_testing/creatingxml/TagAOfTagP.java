package com.automation_testing.creatingxml;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@AllArgsConstructor
public class TagAOfTagP {
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String f;

    public TagAOfTagP(String a) {
        this.a = a;
    }

}
