package com.autotest.allrequests.work_in_authorized_mode.create_pay_ord.typ_fields_map_in_req;

import com.autotest.allrequests.authorization.UserAccount;
import com.autotest.allrequests.authorization.UserFilter;
import com.autotest.allrequests.work_in_authorized_mode.dictionary.GetFullBankRuKon;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class KonMap {
    private final Map<String, String> mapKon = new LinkedHashMap<>();
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
    private String ground;
    private String branchBankRecordId;
    private String receiverBankName;

    public KonMap() {
    }

    public Map<String, String> getMapKon() {
        return mapKon;
    }

    {
        definingDinField();
        mapKon.put("BankRecordID", "");
        mapKon.put("Status", "0");
        mapKon.put("DocumentDate", createTime());
        mapKon.put("DocumentNumber", "");
        mapKon.put("SenderOfficials", "");
        mapKon.put("CustomerBankRecordID", UserFilter.rootTag.getListC().get(0).getI());
        mapKon.put("BranchBankRecordID", branchBankRecordId);
        mapKon.put("Amount", "1200.0");
        mapKon.put("CBCcode", "");
        mapKon.put("NDS", "200.0");
        mapKon.put("Payer", payerName);
        mapKon.put("PayerAccount", payerAccount);
        mapKon.put("PayerBIC", payerBIC);
        mapKon.put("PayerINN", payerINN);
        mapKon.put("Receiver", "OOO BSS");
        mapKon.put("ReceiverAccount", "12345810611111111111");
        mapKon.put("ReceiverBIC", GetFullBankRuKon.receiverBIC);
        mapKon.put("ReceiverBankName", receiverBankName);
        mapKon.put("ReceiverINN", "1126587769");
        mapKon.put("Ground", ground);
        mapKon.put("CurrCode", "810");
        mapKon.put("KNFCode", "");
        mapKon.put("OKATOcode", "");
        mapKon.put("OperType", "01");
        mapKon.put("OrderPayer", "");
        mapKon.put("OrderPayerAccount", "");
        mapKon.put("OrderReceiver", "");
        mapKon.put("OrderReceiverAccount", "");
        mapKon.put("PayUntil", "0");
        mapKon.put("PayerBankName", payerBankName);
        mapKon.put("PayerBankType", "");
        mapKon.put("PayerCorrAccount", payerCorrAccount);
        mapKon.put("PayerKPP", payerKPP);
        mapKon.put("PayerPlace", payerPlace);
        mapKon.put("PayerPlaceType", payerPlaceType);
        mapKon.put("PayerPropertyType", payerPropertyType);
        mapKon.put("PaymentUrgent", "5");
        mapKon.put("ReceiverBankType", "20");
        mapKon.put("ReceiverCorrAccount", GetFullBankRuKon.receiverCorrAcc);
        mapKon.put("ReceiverKPP", "772601001");
        mapKon.put("ReceiverPlace", GetFullBankRuKon.receiverPlace);
        mapKon.put("ReceiverPlaceType", GetFullBankRuKon.receiverPlaceType);
        mapKon.put("ReceiverPropertyType", "");
        mapKon.put("SendType", "");
        mapKon.put("SendTypeCode", "");
        mapKon.put("NDSCalculationType", "1");
        mapKon.put("NDSPercent", "20.0");
        mapKon.put("Stat1256", "");
        mapKon.put("TaxPeriodParam1", "");
        mapKon.put("TaxPeriodParam2", "");
        mapKon.put("TaxPeriodParam3", "");
        mapKon.put("DocDateParam1", "");
        mapKon.put("DocDateParam2", "");
        mapKon.put("DocDateParam3", "");
        mapKon.put("DocNumParam1", "");
        mapKon.put("DocNumParam2", "");
        mapKon.put("PayGrndParam", "");
        mapKon.put("PayTypeParam", "");
        mapKon.put("CodeUIP", "");
        mapKon.put("NDSSystemName", "Vat1");
        mapKon.put("PaymentType", "2");
        mapKon.put("OperCode", "");
        mapKon.put("TrafficLightColor", "");
        mapKon.put("TrafficLightDescription", "");
        mapKon.put("Reserv23", "");
        mapKon.put("IncomeTypeCode", "");
        mapKon.put("SaveTemplate", "0");
        mapKon.put("TemplateName", "");
        mapKon.put("Phone", "");
        mapKon.put("Email", "");
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
        ground = "\nВ том числе НДС 20.00 % - 200.00 р.";
        receiverBankName = GetFullBankRuKon.receiverBankName.replaceAll("\"", "&quot;");
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(branchBankRecordId)) {
                payerBIC = UserFilter.rootTag.getListF().get(i).getB();
                payerBankName = UserFilter.rootTag.getListF().get(i).getN().replaceAll("\"", ("&quot;"));
                payerCorrAccount = UserFilter.rootTag.getListF().get(i).getA();
                payerPlace = UserFilter.rootTag.getListF().get(i).getG();
                payerPlaceType = UserFilter.rootTag.getListF().get(i).getD();
                payerName = UserFilter.rootTag.getListC().get(0).getN().replaceAll("\"", ("&quot;"));
                break;
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
