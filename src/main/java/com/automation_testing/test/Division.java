package com.automation_testing.test;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class Division {
    private String id;
    private String n;
    private String m;
    private String b;
    private String p;
    private String gbn;
    private String c;
    private String a;
    private String d;
    private String g;
    private String q;
    private String s;
    private String z;
    private String x;
    private String u;
    private String w;
    private String e;
    private String r;
    private String dt;
    private ArrayList<Account> accountList = new ArrayList<>();

    public void addAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public String toString() {
        return "Division{" +
                "id='" + id + '\'' +
                ", p='" + p + '\'' +
                '}';
    }
}
