package com.automation_testing.creatingxml;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagCOfTagP {
    @XmlAttribute
    private String n;
}
