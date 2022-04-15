package com.autotest.parsingxml;

import javax.xml.bind.annotation.XmlAttribute;

public class TagBOfTagUnivRes {
    @XmlAttribute(name = "a")
    private String a; //%МеждународноеНазвание%
    @XmlAttribute(name = "b")
    private String b; //%БИК%
    @XmlAttribute(name = "dt")
    private String dt; //%ЧасовойПояс%
    @XmlAttribute(name = "e")
    private String e; //%ЭлектронныйАдрес% Значение параметра "E-mail подразделения банка"
    @XmlAttribute(name = "i")
    private String i; //%УникальныйНомерСистемыДБО% Передается идентификатор подразделения в Correqts
    @XmlAttribute(name = "n")
    private String n; //%Название подр по умолчанию в МБК%
    @XmlAttribute(name = "p")
    private String p; //%Телефон% Значение параметра "Телефон подразделения банка"
    @XmlAttribute(name = "s")
    private String s; //%СистемаДБО% Название системы ДБО: 0 – ДБОх64, 1 – Correqts, 2 – РЦК
    @XmlAttribute(name = "t")
    private String t; //%ДатаАктуальностиКарточки%

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getDt() {
        return dt;
    }

    public String getE() {
        return e;
    }

    public String getI() {
        return i;
    }

    public String getN() {
        return n;
    }

    public String getP() {
        return p;
    }

    public String getS() {
        return s;
    }

    public String getT() {
        return t;
    }

    @Override
    public String toString() {
        return "TagBOfTagUnivRes{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", dt='" + dt + '\'' +
                ", e='" + e + '\'' +
                ", i='" + i + '\'' +
                ", n='" + n + '\'' +
                ", p='" + p + '\'' +
                ", s='" + s + '\'' +
                ", t='" + t + '\'' +
                '}';
    }
}
