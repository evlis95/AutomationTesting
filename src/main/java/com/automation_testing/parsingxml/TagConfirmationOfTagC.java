package com.automation_testing.parsingxml;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TagConfirmationOfTagC {
    @XmlElement(name = "d")
    private List<TagDOfTagConfirmation> listD;

    public List<TagDOfTagConfirmation> getListD() {
        return listD;
    }

    @Override
    public String toString() {
        return "TagConfirmationOfTagC{" +
                "listD=" + listD +
                '}';
    }
}
