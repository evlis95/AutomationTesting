package com.automation_testing.creatingxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;

public class TagTOfTagP {
    @XmlAttribute
    private String n;
    @XmlAttribute
    private String st;
    @XmlElement(name = "a")
    List<TagAOfTagT> listA;
    @XmlElement(name = "br")
    List<TagBROfTagT> listBR;

    public void setN(String n) {
        this.n = n;
    }

    public TagTOfTagP(String n) {
        this.n = n;
    }

    public TagTOfTagP() {
    }

    public void setSt(String st) {
        this.st = st;
    }

    public void setListA(List<TagAOfTagT> listA) {
        this.listA = listA;
    }

    public void setListBR(List<TagBROfTagT> listBR) {
        this.listBR = listBR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagTOfTagP that = (TagTOfTagP) o;
        return n.equals(that.n);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
