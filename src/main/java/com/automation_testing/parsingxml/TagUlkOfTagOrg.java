package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagUlkOfTagOrg {
    @XmlAttribute
    private String email;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String patr;
    @XmlAttribute
    private String phone;
    @XmlAttribute
    private String surname;

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPatr() {
        return patr;
    }

    public String getPhone() {
        return phone;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "TagUlkOfTagOrg{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", patr='" + patr + '\'' +
                ", phone='" + phone + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
