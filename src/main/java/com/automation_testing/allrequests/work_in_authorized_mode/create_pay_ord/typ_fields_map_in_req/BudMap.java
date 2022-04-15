package com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.typ_fields_map_in_req;

import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFilterPartCBCCodes;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFullBankRuBud;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class BudMap {
    private final Map<String, String> mapBud = new LinkedHashMap<>();
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

    public BudMap() {
    }

    public Map<String, String> getMapBud() {
        return mapBud;
    }

    {
        definingPayerData();
        definingDinField();
        definingPayerBicAndPayBankNameAndCorrAcc();
        mapBud.put("BankRecordID", "");
        mapBud.put("Status", "0");
        mapBud.put("DocumentDate", createTime());
        mapBud.put("DocumentNumber", "");
        mapBud.put("SenderOfficials", "");
        mapBud.put("CustomerBankRecordID", UserFilter.rootTag.getListC().get(0).getI());
        mapBud.put("BranchBankRecordID", branchBankRecordId);
        mapBud.put("Amount", "25000.0");
        mapBud.put("CBCcode", GetFilterPartCBCCodes.cbcCodeValue);
        mapBud.put("NDS", "0.0");
        mapBud.put("Payer", payerName);
        mapBud.put("PayerAccount", payerAccount);
        mapBud.put("PayerBIC", payerBIC);
        mapBud.put("PayerINN", payerINN);
        mapBud.put("Receiver", "Федеральное казначейство");
        mapBud.put("ReceiverAccount", "40702810011111111111");
        mapBud.put("ReceiverBIC", GetFullBankRuBud.receiverGeneralBIC);
        mapBud.put("ReceiverBankName", receiverBankName);
        mapBud.put("ReceiverINN", "7710568760");
        mapBud.put("Ground", "\nНДС не облагается");
        mapBud.put("CurrCode", "810");
        mapBud.put("KNFCode", "");
        mapBud.put("OKATOcode", "12345678");
        mapBud.put("OperType", "01");
        mapBud.put("OrderPayer", "");
        mapBud.put("OrderPayerAccount", "");
        mapBud.put("OrderReceiver", "");
        mapBud.put("OrderReceiverAccount", "");
        mapBud.put("PayUntil", "0");
        mapBud.put("PayerBankName", payerBankName);
        mapBud.put("PayerBankType", "");
        mapBud.put("PayerCorrAccount", payerCorrAccount);
        mapBud.put("PayerKPP", payerKPP);
        mapBud.put("PayerPlace", payerPlace);
        mapBud.put("PayerPlaceType", payerPlaceType);
        mapBud.put("PayerPropertyType", payerPropertyType);
        mapBud.put("PaymentUrgent", "5");
        mapBud.put("ReceiverBankType", "00");
        mapBud.put("ReceiverCorrAccount", "");
        mapBud.put("ReceiverKPP", "770101001");
        mapBud.put("ReceiverPlace", GetFullBankRuBud.receiverPlace);
        mapBud.put("ReceiverPlaceType", GetFullBankRuBud.receiverPlaceType);
        mapBud.put("ReceiverPropertyType", "");
        mapBud.put("SendType", "");
        mapBud.put("SendTypeCode", "");
        mapBud.put("NDSCalculationType", "3");
        mapBud.put("NDSPercent", "0.0");
        mapBud.put("Stat1256", "01");
        mapBud.put("TaxPeriodParam1", "0");
        mapBud.put("TaxPeriodParam2", "");
        mapBud.put("TaxPeriodParam3", "");
        mapBud.put("DocDateParam1", "29");
        mapBud.put("DocDateParam2", "03");
        mapBud.put("DocDateParam3", "2022");
        mapBud.put("DocNumParam1", "");
        mapBud.put("DocNumParam2", "12345");
        mapBud.put("PayGrndParam", "АП");
        mapBud.put("PayTypeParam", "");
        mapBud.put("CodeUIP", "0");
        mapBud.put("NDSSystemName", "VatZero");
        mapBud.put("PaymentType", "3");
        mapBud.put("OperCode", "");
        mapBud.put("TrafficLightColor", "");
        mapBud.put("TrafficLightDescription", "");
        mapBud.put("Reserv23", "");
        mapBud.put("IncomeTypeCode", "");
        mapBud.put("SaveTemplate", "0");
        mapBud.put("TemplateName", "");
        mapBud.put("Phone", "");
        mapBud.put("Email", "");
    }

    private void definingDinField() {
        payerINN = UserFilter.rootTag.getListC().get(0).getA();
        payerKPP = UserFilter.rootTag.getListC().get(0).getW();
        payerPropertyType = UserFilter.rootTag.getListC().get(0).getE();
        receiverBankName = GetFullBankRuBud.receiverBankName.replaceAll("\"", "&quot;");
    }

    private @NotNull String createTime() {
        long currentTime = System.currentTimeMillis();
        String editTime = Long.toString(currentTime);
        editTime = editTime.substring(0, 8) + "00000";
        return editTime;
    }

    private void definingPayerData() {
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810")) {
                branchBankRecordId = UserAccount.rootTag.getListA().get(i).getF();
                payerAccount = UserAccount.rootTag.getListA().get(i).getA();
                break;
            }
        }
    }

    private void definingPayerBicAndPayBankNameAndCorrAcc() {
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(branchBankRecordId)) {
                payerBIC = UserFilter.rootTag.getListF().get(i).getB();

                payerBankName = UserFilter.rootTag.getListF().get(i).getN();
                payerBankName = payerBankName.replaceAll("\"", ("&quot;"));

                payerCorrAccount = UserFilter.rootTag.getListF().get(i).getA();
                payerPlace = UserFilter.rootTag.getListF().get(i).getG();
                payerPlaceType = UserFilter.rootTag.getListF().get(i).getD();

                payerName = UserFilter.rootTag.getListC().get(0).getN();
                payerName = payerName.replaceAll("\"", ("&quot;"));
            }
        }
    }
}
