package com.automation_testing.test;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
public class Account {
    private String a;
    private String b;
    private String f;
    private String o;
    private String t;
    private String y;
    private String u;
    private String d;
    private String c;
    private String h;
    private String v;
    private String i;
    private String e;
    private String card;
    private String id;
    private String clientName;
    private String sdoc;
    private String withAccept;
    private String sbpPay;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

