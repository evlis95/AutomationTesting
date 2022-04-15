package com.automation_testing.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagErrorOfTagUnivRes {
    @XmlAttribute
    private String field;
    @XmlAttribute
    private String message;
    @XmlAttribute
    private String type;

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
