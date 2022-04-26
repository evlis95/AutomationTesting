package com.automation_testing.creatingxml;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;

@Setter
@NoArgsConstructor
public class TagTOfTagP {
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String st;
    @XmlElement(name = "a")
    List<TagAOfTagT> listA;
    @XmlElement(name = "br")
    List<TagBROfTagT> listBR;

    public TagTOfTagP(String n) {
        this.n = n;
    }
}
