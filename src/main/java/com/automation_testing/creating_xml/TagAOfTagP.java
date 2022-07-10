package com.automation_testing.creating_xml;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagAOfTagP {
    @XmlAttribute
    private String s;
    @XmlAttribute
    private String a;
    @XmlAttribute
    private String f;

    public TagAOfTagP(String a) {
        this.a = a;
    }

    public TagAOfTagP(String a, String f) {
        this.a = a;
        this.f = f;
    }
}
