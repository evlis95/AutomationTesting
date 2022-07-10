package com.automation_testing.utils;

import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.parsing_xml.TagVOfTagUnivRes;

public class ActivServicesAllDivision {
    public static boolean adv;
    public static boolean req;
    public static boolean cc_dcc;
    public static boolean exch;
    public static boolean ctr;
    public static boolean minBalance;
    public static boolean addAcc;
    public static boolean offer;
    public static boolean backPay;
    public static boolean payBC;
    public static boolean newQR;
    public static boolean dep;
    public static boolean cR;
    public static boolean sM;


    public static void definition() {
        for (TagVOfTagUnivRes tagV : UserFilter.rootTag.getListV()) {
            if (!adv) {
                if (tagV.getAdv().equals("1")) {
                    adv = true;
                }
            }
            if (!req) {
                if (tagV.getReq().equals("1")) {
                    req = true;
                }
            }
            if (!cc_dcc) {
                if (tagV.getCc().equals("1") || tagV.getDcc().equals("1")) {
                    cc_dcc = true;
                }
            }
            if (!exch) {
                if (tagV.getExch().equals("1")) {
                    exch = true;
                }
            }
            if (!ctr) {
                if (tagV.getCtr().equals("1")) {
                    ctr = true;
                }
            }
            if (!minBalance) {
                if (tagV.getMinBalance().equals("1")) {
                    minBalance = true;
                }
            }
            if (!addAcc) {
                if (tagV.getAddAcc().equals("1")) {
                    addAcc = true;
                }
            }
            if (!offer) {
                if (tagV.getOffer().equals("1")) {
                    offer = true;
                }
            }
            if (!backPay) {
                if (tagV.getBackpay().equals("1")) {
                    backPay = true;
                }
            }
            if (!payBC) {
                if (tagV.getPaybc().equals("1")) {
                    payBC = true;
                }
            }
            if (!newQR) {
                if (tagV.getNewqr().equals("1")) {
                    newQR = true;
                }
            }
            if (!dep) {
                if (tagV.getDep().equals("1")) {
                    dep = true;
                }
            }
            if (!cR) {
                if (tagV.getCr().equals("1")) {
                    cR = true;
                }
            }
            if (!sM) {
                if (tagV.getSm().equals("1")) {
                    sM = true;
                }
            }
        }
    }
}
