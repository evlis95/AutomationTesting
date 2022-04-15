package com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.typ_fields_map_in_req;

import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class YSMap {
    private final Map<String, String> mapYourSelf = new LinkedHashMap<>();
    private String payerAccount;
    private String payerBIC;
    private String payerName;
    private String payerINN;
    private String payerBankName;
    private String payerCorrAccount;
    private String payerKPP;
    private String payerPlace;
    private String payerPlaceType;
    private String payerPropertyType;
    private String branchBankRecordId;
    private String receiverBankName;
    private String receiverPlace;
    private String receiverPlaceType;
    private String receiverCorrAcc;
    private String receiverBIC;
    private String receiverAcc;
    private String receiverIdDiv;

    public YSMap() {
    }

    public Map<String, String> getMapYourSelf() {
        return mapYourSelf;
    }

    {
        definingDinField();
        definingReceiverData();
        mapYourSelf.put("BankRecordID", "");
        mapYourSelf.put("Status", "0");
        mapYourSelf.put("DocumentDate", createTime());
        mapYourSelf.put("DocumentNumber", "");
        mapYourSelf.put("SenderOfficials", "");
        mapYourSelf.put("CustomerBankRecordID", UserFilter.rootTag.getListC().get(0).getI());
        mapYourSelf.put("BranchBankRecordID", branchBankRecordId);
        mapYourSelf.put("Amount", "50000.0");
        mapYourSelf.put("CBCcode", "");
        mapYourSelf.put("NDS", "0.0");
        mapYourSelf.put("Payer", payerName);
        mapYourSelf.put("PayerAccount", payerAccount);
        mapYourSelf.put("PayerBIC", payerBIC);
        mapYourSelf.put("PayerINN", payerINN);
        mapYourSelf.put("Receiver", payerName);
        mapYourSelf.put("ReceiverAccount", receiverAcc);
        mapYourSelf.put("ReceiverBIC", receiverBIC);
        mapYourSelf.put("ReceiverBankName", receiverBankName);
        mapYourSelf.put("ReceiverINN", payerINN);
        mapYourSelf.put("Ground", "\nПеревод собственных средств. НДС не облагается");
        mapYourSelf.put("CurrCode", "810");
        mapYourSelf.put("KNFCode", "");
        mapYourSelf.put("OKATOcode", "");
        mapYourSelf.put("OperType", "01");
        mapYourSelf.put("OrderPayer", "");
        mapYourSelf.put("OrderPayerAccount", "");
        mapYourSelf.put("OrderReceiver", "");
        mapYourSelf.put("OrderReceiverAccount", "");
        mapYourSelf.put("PayUntil", "0");
        mapYourSelf.put("PayerBankName", payerBankName);
        mapYourSelf.put("PayerBankType", "");
        mapYourSelf.put("PayerCorrAccount", payerCorrAccount);
        mapYourSelf.put("PayerKPP", payerKPP);
        mapYourSelf.put("PayerPlace", payerPlace);
        mapYourSelf.put("PayerPlaceType", payerPlaceType);
        mapYourSelf.put("PayerPropertyType", payerPropertyType);
        mapYourSelf.put("PaymentUrgent", "5");
        mapYourSelf.put("ReceiverBankType", "");
        mapYourSelf.put("ReceiverCorrAccount", receiverCorrAcc);
        mapYourSelf.put("ReceiverKPP", payerKPP);
        mapYourSelf.put("ReceiverPlace", receiverPlace);
        mapYourSelf.put("ReceiverPlaceType", receiverPlaceType);
        mapYourSelf.put("ReceiverPropertyType", "");
        mapYourSelf.put("SendType", "");
        mapYourSelf.put("SendTypeCode", "");
        mapYourSelf.put("NDSCalculationType", "3");
        mapYourSelf.put("NDSPercent", "0.0");
        mapYourSelf.put("Stat1256", "");
        mapYourSelf.put("TaxPeriodParam1", "");
        mapYourSelf.put("TaxPeriodParam2", "");
        mapYourSelf.put("TaxPeriodParam3", "");
        mapYourSelf.put("DocDateParam1", "");
        mapYourSelf.put("DocDateParam2", "");
        mapYourSelf.put("DocDateParam3", "");
        mapYourSelf.put("DocNumParam1", "");
        mapYourSelf.put("DocNumParam2", "");
        mapYourSelf.put("PayGrndParam", "");
        mapYourSelf.put("PayTypeParam", "");
        mapYourSelf.put("CodeUIP", "");
        mapYourSelf.put("NDSSystemName", "VatZero");
        mapYourSelf.put("PaymentType", "1");
        mapYourSelf.put("OperCode", "");
        mapYourSelf.put("TrafficLightColor", "");
        mapYourSelf.put("TrafficLightDescription", "");
        mapYourSelf.put("Reserv23", "");
        mapYourSelf.put("IncomeTypeCode", "");
        mapYourSelf.put("SaveTemplate", "0");
        mapYourSelf.put("TemplateName", "");
        mapYourSelf.put("Phone", "");
        mapYourSelf.put("Email", "");


    }


    private void definingDinField() {

        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810")) {
                branchBankRecordId = UserAccount.rootTag.getListA().get(i).getF();
                payerAccount = UserAccount.rootTag.getListA().get(i).getA();
                break;
            }
        }
        payerINN = UserFilter.rootTag.getListC().get(0).getA();
        payerKPP = UserFilter.rootTag.getListC().get(0).getW();
        payerPropertyType = UserFilter.rootTag.getListC().get(0).getE();

        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810") & !(UserAccount.rootTag.getListA().get(i).getA().equals(payerAccount))) {
                receiverAcc = UserAccount.rootTag.getListA().get(i).getA();
                break;
            }
        }


        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(branchBankRecordId)) {
                payerBIC = UserFilter.rootTag.getListF().get(i).getB();
                payerBankName = UserFilter.rootTag.getListF().get(i).getN().replaceAll("\"", ("&quot;"));
                payerCorrAccount = UserFilter.rootTag.getListF().get(i).getA();
                payerPlace = UserFilter.rootTag.getListF().get(i).getG();
                payerPlaceType = UserFilter.rootTag.getListF().get(i).getD();
                payerName = UserFilter.rootTag.getListC().get(0).getN().replaceAll("\"", ("&quot;"));
            }
        }
    }

    private void definingReceiverData() {
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810") & !(UserAccount.rootTag.getListA().get(i).getA().equals(payerAccount))) {
                receiverAcc = UserAccount.rootTag.getListA().get(i).getA();
                receiverIdDiv = UserAccount.rootTag.getListA().get(i).getF();
                break;
            }
        }
        definingReceiverNameBankAndCorrAcc();
    }

    private void definingReceiverNameBankAndCorrAcc() {
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(receiverIdDiv)) {
                receiverBankName = UserFilter.rootTag.getListF().get(i).getN().replaceAll("\"", "&quot;");
                receiverCorrAcc = UserFilter.rootTag.getListF().get(i).getA();
                receiverBIC = UserFilter.rootTag.getListF().get(i).getB();
                receiverPlace = UserFilter.rootTag.getListF().get(i).getG();
                receiverPlaceType = UserFilter.rootTag.getListF().get(i).getD();
            }
        }
    }

    private @NotNull String createTime() {
        long currentTime = System.currentTimeMillis();
        String editTime = Long.toString(currentTime);
        editTime = editTime.substring(0, 8) + "00000";
        return editTime;
    }
}
