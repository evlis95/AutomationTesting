package com.autotest.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagBROfTagT {
    @XmlAttribute
    private String id;

    public TagBROfTagT(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
