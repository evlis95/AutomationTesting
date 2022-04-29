package com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord;

import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFilterPartCBCCodes;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetFullBankRu;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
@Getter
public class PaymentOrder {
    private final PaymentOrderTarget PAY_ORD_TARGET;
    private final Map<String, String> MAP = new LinkedHashMap<>();
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
        this.PAY_ORD_TARGET = paymentOrderTarget;
    }

    public Map<String, String> creating() {

        switch (PAY_ORD_TARGET) {
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

        MAP.put("BankRecordID", bankRecordID);
        MAP.put("Status", status);
        MAP.put("DocumentDate", documentDate);
        MAP.put("DocumentNumber", documentNumber);
        MAP.put("SenderOfficials", senderOfficials);
        MAP.put("CustomerBankRecordID", customerBankRecordID);
        MAP.put("BranchBankRecordID", branchBankRecordID);
        MAP.put("Amount", amount);
        MAP.put("CBCcode", cbcCode);
        MAP.put("NDS", nds);
        MAP.put("Payer", payer);
        MAP.put("PayerAccount", payerAccount);
        MAP.put("PayerBIC", payerBIC);
        MAP.put("PayerINN", payerINN);
        MAP.put("Receiver", receiver);
        MAP.put("ReceiverAccount", receiverAccount);
        MAP.put("ReceiverBIC", receiverBIC);
        MAP.put("ReceiverBankName", receiverBankName);
        MAP.put("ReceiverINN", receiverINN);
        MAP.put("Ground", ground);
        MAP.put("CurrCode", currCode);
        MAP.put("KNFCode", knfCode);
        MAP.put("OKATOcode", okatoCode);
        MAP.put("OperType", operType);
        MAP.put("OrderPayer", orderPayer);
        MAP.put("OrderPayerAccount", orderPayerAccount);
        MAP.put("OrderReceiver", orderReceiver);
        MAP.put("OrderReceiverAccount", orderReceiverAccount);
        MAP.put("PayUntil", payUntil);
        MAP.put("PayerBankName", payerBankName);
        MAP.put("PayerBankType", payerBankType);
        MAP.put("PayerCorrAccount", payerCorrAccount);
        MAP.put("PayerKPP", payerKPP);
        MAP.put("PayerPlace", payerPlace);
        MAP.put("PayerPlaceType", payerPlaceType);
        MAP.put("PayerPropertyType", payerPropertyType);
        MAP.put("PaymentUrgent", paymentUrgent);
        MAP.put("ReceiverBankType", receiverBankType);
        MAP.put("ReceiverCorrAccount", receiverCorrAccount);
        MAP.put("ReceiverKPP", receiverKPP);
        MAP.put("ReceiverPlace", receiverPlace);
        MAP.put("ReceiverPlaceType", receiverPlaceType);
        MAP.put("ReceiverPropertyType", receiverPropertyType);
        MAP.put("SendType", sendType);
        MAP.put("SendTypeCode", sendTypeCode);
        MAP.put("NDSCalculationType", ndsCalculationType);
        MAP.put("NDSPercent", ndsPercent);
        MAP.put("Stat1256", stat1256);
        MAP.put("TaxPeriodParam1", taxPeriodParam1);
        MAP.put("TaxPeriodParam2", taxPeriodParam2);
        MAP.put("TaxPeriodParam3", taxPeriodParam3);
        MAP.put("DocDateParam1", docDateParam1);
        MAP.put("DocDateParam2", docDateParam2);
        MAP.put("DocDateParam3", docDateParam3);
        MAP.put("DocNumParam1", docNumParam1);
        MAP.put("DocNumParam2", docNumParam2);
        MAP.put("PayGrndParam", payGrndParam);
        MAP.put("PayTypeParam", payTypeParam);
        MAP.put("CodeUIP", codeUIP);
        MAP.put("NDSSystemName", ndsSystemName);
        MAP.put("PaymentType", paymentType);
        MAP.put("OperCode", operCode);
        MAP.put("TrafficLightColor", trafficLightColor);
        MAP.put("TrafficLightDescription", trafficLightDescription);
        MAP.put("Reserv23", reserv23);
        MAP.put("IncomeTypeCode", incomeTypeCode);
        MAP.put("SaveTemplate", saveTemplate);
        MAP.put("TemplateName", templateName);
        MAP.put("Phone", phone);
        MAP.put("Email", email);

        return MAP;
    }

    private void payToCounterpartyInitialVar() {
        amount = "1200.0";
        nds = "200.0";
        receiver = "OOO BSS";
        receiverAccount = "12345810611111111111";
        receiverBIC = GetFullBankRu.receiverBIC;
        receiverBankName = GetFullBankRu.receiverBankName.replaceAll("\"", "&quot;");
        receiverINN = "1126587769";
        ground = "\nВ том числе НДС 20.00 % - 200.00 р.";
        receiverBankType = "20";
        receiverCorrAccount = GetFullBankRu.receiverCorrAcc;
        receiverKPP = "772601001";
        receiverPlace = GetFullBankRu.receiverPlace;
        receiverPlaceType = GetFullBankRu.receiverPlaceType;
        ndsCalculationType = "1";
        ndsPercent = "20.0";
        ndsSystemName = "Vat1";
        paymentType = "2";
        templateName = "template";
        saveTemplate = "1";
    }

    private void payToBudgetInitialVar() {
        amount = "5000.0";
        cbcCode = GetFilterPartCBCCodes.cbcCodeValue;
        nds = "";
        receiver = "Федеральное казначейство";
        receiverAccount = "40702810611111111111";
        receiverBIC = GetFullBankRu.receiverBIC;
        receiverBankName = GetFullBankRu.receiverBankName.replaceAll("\"", "&quot;");
        receiverINN = "1110568760";
        ground = "\nНДС не облагается";
        receiverBankType = "00";
        receiverCorrAccount = GetFullBankRu.receiverCorrAcc;
        receiverKPP = "770101001";
        receiverPlace = GetFullBankRu.receiverPlace;
        receiverPlaceType = GetFullBankRu.receiverPlaceType;
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
