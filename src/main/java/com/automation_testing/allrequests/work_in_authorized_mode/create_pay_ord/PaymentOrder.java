package com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord;

import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFilterPartCBCCodes;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFullBankRuBud;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFullBankRuKon;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class PaymentOrder {
    private final PaymentOrderTarget paymentOrderTarget;
    private final Map<String, String> map = new LinkedHashMap<>();
    private String bankRecordID;
    private String status;
    private String documentDate;
    private String documentNumber;
    private String senderOfficials;
    private String customerBankRecordID;
    private String branchBankRecordID;
    private String amount;
    private String cbcCode;
    private String nds;
    private String payer;
    private String payerAccount;
    private String payerBIC;
    private String payerINN;
    private String receiver;
    private String receiverAccount;
    private String receiverBIC;
    private String receiverBankName;
    private String receiverINN;
    private String ground;
    private String currCode;
    private String knfCode;
    private String okatoCode;
    private String operType;
    private String orderPayer;
    private String orderPayerAccount;
    private String orderReceiver;
    private String orderReceiverAccount;
    private String payUntil;
    private String payerBankName;
    private String payerBankType;
    private String payerCorrAccount;
    private String payerKPP;
    private String payerPlace;
    private String payerPlaceType;
    private String payerPropertyType;
    private String paymentUrgent;
    private String receiverBankType;
    private String receiverCorrAccount;
    private String receiverKPP;
    private String receiverPlace;
    private String receiverPlaceType;
    private String receiverPropertyType;
    private String sendType;
    private String sendTypeCode;
    private String ndsCalculationType;
    private String ndsPercent;
    private String stat1256;
    private String taxPeriodParam1;
    private String taxPeriodParam2;
    private String taxPeriodParam3;
    private String docDateParam1;
    private String docDateParam2;
    private String docDateParam3;
    private String docNumParam1;
    private String docNumParam2;
    private String payGrndParam;
    private String payTypeParam;
    private String codeUIP;
    private String ndsSystemName;
    private String paymentType;
    private String operCode;
    private String trafficLightColor;
    private String trafficLightDescription;
    private String reserv23;
    private String incomeTypeCode;
    private String saveTemplate;
    private String templateName;
    private String phone;
    private String email;
    private String receiverDivID;

    public PaymentOrder(PaymentOrderTarget paymentOrderTarget) {
        this.paymentOrderTarget = paymentOrderTarget;
    }

    public Map<String, String> creating() {

        switch (paymentOrderTarget) {
            case PAYMENT_TO_COUNTERPARTY -> {
                generalInitialVar();
                payToCounterpartyInitialVar();
            }
            case PAYMENT_TO_BUDGET -> {
                generalInitialVar();
                payToBudgetInitialVar();
            }
            case PAYMENT_TO_YOURSELF -> {
                generalInitialVar();
                payToYourSelfInitialVar();
            }
        }

        map.put("BankRecordID", bankRecordID);
        map.put("Status", status);
        map.put("DocumentDate", documentDate);
        map.put("DocumentNumber", documentNumber);
        map.put("SenderOfficials", senderOfficials);
        map.put("CustomerBankRecordID", customerBankRecordID);
        map.put("BranchBankRecordID", branchBankRecordID);
        map.put("Amount", amount);
        map.put("CBCcode", cbcCode);
        map.put("NDS", nds);
        map.put("Payer", payer);
        map.put("PayerAccount", payerAccount);
        map.put("PayerBIC", payerBIC);
        map.put("PayerINN", payerINN);
        map.put("Receiver", receiver);
        map.put("ReceiverAccount", receiverAccount);
        map.put("ReceiverBIC", receiverBIC);
        map.put("ReceiverBankName", receiverBankName);
        map.put("ReceiverINN", receiverINN);
        map.put("Ground", ground);
        map.put("CurrCode", currCode);
        map.put("KNFCode", knfCode);
        map.put("OKATOcode", okatoCode);
        map.put("OperType", operType);
        map.put("OrderPayer", orderPayer);
        map.put("OrderPayerAccount", orderPayerAccount);
        map.put("OrderReceiver", orderReceiver);
        map.put("OrderReceiverAccount", orderReceiverAccount);
        map.put("PayUntil", payUntil);
        map.put("PayerBankName", payerBankName);
        map.put("PayerBankType", payerBankType);
        map.put("PayerCorrAccount", payerCorrAccount);
        map.put("PayerKPP", payerKPP);
        map.put("PayerPlace", payerPlace);
        map.put("PayerPlaceType", payerPlaceType);
        map.put("PayerPropertyType", payerPropertyType);
        map.put("PaymentUrgent", paymentUrgent);
        map.put("ReceiverBankType", receiverBankType);
        map.put("ReceiverCorrAccount", receiverCorrAccount);
        map.put("ReceiverKPP", receiverKPP);
        map.put("ReceiverPlace", receiverPlace);
        map.put("ReceiverPlaceType", receiverPlaceType);
        map.put("ReceiverPropertyType", receiverPropertyType);
        map.put("SendType", sendType);
        map.put("SendTypeCode", sendTypeCode);
        map.put("NDSCalculationType", ndsCalculationType);
        map.put("NDSPercent", ndsPercent);
        map.put("Stat1256", stat1256);
        map.put("TaxPeriodParam1", taxPeriodParam1);
        map.put("TaxPeriodParam2", taxPeriodParam2);
        map.put("TaxPeriodParam3", taxPeriodParam3);
        map.put("DocDateParam1", docDateParam1);
        map.put("DocDateParam2", docDateParam2);
        map.put("DocDateParam3", docDateParam3);
        map.put("DocNumParam1", docNumParam1);
        map.put("DocNumParam2", docNumParam2);
        map.put("PayGrndParam", payGrndParam);
        map.put("PayTypeParam", payTypeParam);
        map.put("CodeUIP", codeUIP);
        map.put("NDSSystemName", ndsSystemName);
        map.put("PaymentType", paymentType);
        map.put("OperCode", operCode);
        map.put("TrafficLightColor", trafficLightColor);
        map.put("TrafficLightDescription", trafficLightDescription);
        map.put("Reserv23", reserv23);
        map.put("IncomeTypeCode", incomeTypeCode);
        map.put("SaveTemplate", saveTemplate);
        map.put("TemplateName", templateName);
        map.put("Phone", phone);
        map.put("Email", email);

        return map;
    }

    private void payToCounterpartyInitialVar() {
        amount = "1200.0";
        nds = "200.0";
        receiver = "OOO BSS";
        receiverAccount = "12345810611111111111";
        receiverBIC = GetFullBankRuKon.receiverBIC;
        receiverBankName = GetFullBankRuKon.receiverBankName.replaceAll("\"", "&quot;");
        receiverINN = "1126587769";
        ground = "\nВ том числе НДС 20.00 % - 200.00 р.";
        receiverBankType = "20";
        receiverCorrAccount = GetFullBankRuKon.receiverCorrAcc;
        receiverKPP = "772601001";
        receiverPlace = GetFullBankRuKon.receiverPlace;
        receiverPlaceType = GetFullBankRuKon.receiverPlaceType;
        ndsCalculationType = "1";
        ndsPercent = "20.0";
        ndsSystemName = "Vat1";
        paymentType = "2";
    }

    private void payToBudgetInitialVar() {
        amount = "5000.0";
        cbcCode = GetFilterPartCBCCodes.cbcCodeValue;
        nds = "";
        receiver = "Федеральное казначейство";
        receiverAccount = "40702810011111111111";
        receiverBIC = GetFullBankRuBud.receiverGeneralBIC;
        receiverBankName = GetFullBankRuBud.receiverBankName.replaceAll("\"", "&quot;");
        receiverINN = "1110568760";
        ground = "\nНДС не облагается";
        receiverBankType = "00";
        receiverCorrAccount = "";
        receiverKPP = "770101001";
        receiverPlace = GetFullBankRuBud.receiverPlace;
        receiverPlaceType = GetFullBankRuBud.receiverPlaceType;
        ndsCalculationType = "3";
        ndsPercent = "0.0";
        stat1256 = "01";
        taxPeriodParam1 = "0";
        docDateParam1 = "29";
        docDateParam2 = "03";
        docDateParam3 = "2022";
        docNumParam1 = "";
        docNumParam2 = "12345";
        payGrndParam = "АП";
        codeUIP = "0";
        ndsSystemName = "VatZero";
        paymentType = "3";
        okatoCode = "12345678";
    }

    private void payToYourSelfInitialVar() {
        amount = "10000.0";
        nds = "";
        ground = "\nПеревод собственных средств. НДС не облагается";
        receiver = UserFilter.orgName.replaceAll("\"", ("&quot;"));
        // метод инициализирует поля:
        // receiverAccount
        // branchBankRecordID
        // receiverDivID
        // receiverBankName
        // receiverCorrAccount
        // receiverBIC
        // receiverPlace
        // receiverPlaceType
        // в платеже Себе
        definingReceiverDataPayYourSelf();
        receiverINN = UserFilter.orgINN;
        receiverBankType = "";
        receiverKPP = UserFilter.orgKPP;
        ndsCalculationType = "3";
        ndsPercent = "0.0";
        ndsSystemName = "VatZero";
        paymentType = "1";
    }

    private void generalInitialVar() {
        bankRecordID = "";
        status = "0";
        documentDate = createTime();
        documentNumber = DocumentNumber.docNum;
        senderOfficials = "";
        customerBankRecordID = UserFilter.orgId;
        //метод инициализирует общие для каждого типа платежа поля:
        // payerAccount
        // branchBankRecordID
        definingPayAccAndBranchBankRecID();
        payer = UserFilter.orgName.replaceAll("\"", ("&quot;"));
        //метод инициализирует общие для каждого типа платежа поля:
        // payerBIC
        // payerBankName
        // payerCorrAccount
        // payerPlace
        // payerPlaceType
        payerKPP = UserFilter.orgKPP;
        definingPayerData();
        payerINN = UserFilter.orgINN;
        knfCode = "";
        operType = "01";
        orderPayer = "";
        orderPayerAccount = "";
        orderReceiver = "";
        orderReceiverAccount = "";
        payUntil = "0";
        payerBankType = "";
        payerPropertyType = UserFilter.rootTag.getListC().get(0).getE();
        paymentUrgent = "5";
        receiverPropertyType = "";
        sendType = "";
        sendTypeCode = "";
        taxPeriodParam2 = "";
        taxPeriodParam3 = "";
        payTypeParam = "";
        operCode = "";
        trafficLightColor = "";
        trafficLightDescription = "";
        reserv23 = "";
        incomeTypeCode = "";
        saveTemplate = "0";
        templateName = "";
        phone = "";
        email = "";
        stat1256 = "";
        taxPeriodParam1 = "";
        docDateParam1 = "";
        docDateParam2 = "";
        docDateParam3 = "";
        docNumParam1 = "";
        docNumParam2 = "";
        payGrndParam = "";
        codeUIP = "";
        currCode = "810";
        cbcCode = "";
        okatoCode = "";
    }

    private @NotNull String createTime() {
        long currentTime = System.currentTimeMillis();
        String editTime = Long.toString(currentTime);
        editTime = editTime.substring(0, 8) + "00000";
        return editTime;
    }

    private void definingPayAccAndBranchBankRecID() {
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810")) {
                branchBankRecordID = UserAccount.rootTag.getListA().get(i).getF();
                payerAccount = UserAccount.rootTag.getListA().get(i).getA();
                break;
            }
        }
    }

    private void definingPayerData() {
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(branchBankRecordID)) {
                payerBIC = UserFilter.rootTag.getListF().get(i).getB();
                payerBankName = UserFilter.rootTag.getListF().get(i).getN().replaceAll("\"", ("&quot;"));
                payerCorrAccount = UserFilter.rootTag.getListF().get(i).getA();
                payerPlace = UserFilter.rootTag.getListF().get(i).getG();
                payerPlaceType = UserFilter.rootTag.getListF().get(i).getD();
                break;
            }
        }
    }

    private void definingReceiverDataPayYourSelf() {
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810") & !(UserAccount.rootTag.getListA().get(i).getA().equals(payerAccount))) {
                receiverAccount = UserAccount.rootTag.getListA().get(i).getA();
                receiverDivID = UserAccount.rootTag.getListA().get(i).getF();
                break;
            }
        }
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(receiverDivID)) {
                receiverBankName = UserFilter.rootTag.getListF().get(i).getN().replaceAll("\"", "&quot;");
                receiverCorrAccount = UserFilter.rootTag.getListF().get(i).getA();
                receiverBIC = UserFilter.rootTag.getListF().get(i).getB();
                receiverPlace = UserFilter.rootTag.getListF().get(i).getG();
                receiverPlaceType = UserFilter.rootTag.getListF().get(i).getD();
            }
        }
    }
}
