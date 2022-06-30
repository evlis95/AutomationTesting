package com.automation_testing.creatingxml;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@NoArgsConstructor
public class TagCOfTagP {
    @XmlAttribute
    private String n;

    public TagCOfTagP(String n) {
        this.n = n;
    }
}
