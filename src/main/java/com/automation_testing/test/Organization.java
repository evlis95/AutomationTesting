package com.automation_testing.test;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Organization {
    private String id;
    private String n;
    private String a;
    private String m;
    private String q;
    private String w;
    private String e;
    private String r;
    private String t;
    private String y;
    private String u;
    private String li;
    private String lp;
    private String sv;
    private String ph;
    private String zku;
    private String eqr;
    private String pas;
    private String pcb;
    private String idsbp;
    private String cr;
    private String cc;
    private String as;
    private String aa;
    private String ou;
    private String tb;
    private String fb;
    private String ct;
    private String sbp;
    private ArrayList<Division> divisionList = new ArrayList<>();

    public void addDivision(Division division) {
        divisionList.add(division);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", n='" + n + '\'' +
                ", a='" + a + '\'' +
                ", m='" + m + '\'' +
                ", q='" + q + '\'' +
                ", w='" + w + '\'' +
                ", e='" + e + '\'' +
                ", r='" + r + '\'' +
                ", t='" + t + '\'' +
                ", y='" + y + '\'' +
                ", u='" + u + '\'' +
                ", li='" + li + '\'' +
                ", lp='" + lp + '\'' +
                ", sv='" + sv + '\'' +
                ", ph='" + ph + '\'' +
                ", zku='" + zku + '\'' +
                ", eqr='" + eqr + '\'' +
                ", pas='" + pas + '\'' +
                ", pcb='" + pcb + '\'' +
                ", idsbp='" + idsbp + '\'' +
                ", cr='" + cr + '\'' +
                ", cc='" + cc + '\'' +
                ", as='" + as + '\'' +
                ", aa='" + aa + '\'' +
                ", ou='" + ou + '\'' +
                ", tb='" + tb + '\'' +
                ", fb='" + fb + '\'' +
                ", ct='" + ct + '\'' +
                ", sbp='" + sbp + '\'' +
                ", divisionList=" + divisionList +
                '}';
    }
}

