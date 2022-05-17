package com.automation_testing.allrequests.work_in_authorized_mode.create_sbp;


import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetDictBanksSBP;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetDictTSP;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.utils.DateUtils;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SBP {

    private String bankRecordID;
    private String status;
    private String documentDate;
    private String documentNumber;
    private String senderOfficials;
    private String customerBankRecordID;
    private String branchBankRecordID;
    private String receiverID;
    private String receiverPAM;
    private String receiverUserINN;
    private String receiverName;
    private String receiverMiddleName;
    private String receiverSurname;
    private String receiverSbpBankName;
    private String receiverSbpBankBIC;
    private String receiverSbpBankMemberID;
    private String receiverAccount;
    private String payerAccount;
    private String payerBankBIC;
    private String payerName;
    private String payerINN;
    private String amount;
    private String currCode;
    private String ground;
    private String incomeCode;
    private String merchantName;
    private String merchantRegName;
    private String merchantId;

    public Map<String, String> creatingDocSBP() {
        Map<String, String> map = new HashMap<>();
        definingPayAcc();
        initiatingFields();
        map.put("BankRecordID", bankRecordID);
        map.put("Status", status);
        map.put("DocumentDate", documentDate);
        map.put("DocumentNumber", documentNumber);
        map.put("SenderOfficials", senderOfficials);
        map.put("CustomerBankRecordID", customerBankRecordID);
        map.put("BranchBankRecordID", branchBankRecordID);
        map.put("ReceiverID", receiverID);
        map.put("ReceiverPam", receiverPAM);
        map.put("ReceiverUserINN", receiverUserINN);
        map.put("ReceiverName", receiverName);
        map.put("ReceiverMiddleName", receiverMiddleName);
        map.put("ReceiverSurname", receiverSurname);
        map.put("ReceiverSbpBankName", receiverSbpBankName);
        map.put("ReceiverSbpBankBIC", receiverSbpBankBIC);
        map.put("ReceiverSbpBankMemberID", receiverSbpBankMemberID);
        map.put("ReceiverAccount", receiverAccount);
        map.put("PayerAccount", payerAccount);
        map.put("PayerBankBIC", payerBankBIC);
        map.put("PayerName", payerName);
        map.put("PayerINN", payerINN);
        map.put("Amount", amount);
        map.put("CurrCode", currCode);
        map.put("Ground", ground);
        map.put("IncomeCode", incomeCode);
        map.put("MerchantName", merchantName);
        map.put("MerchantRegName", merchantRegName);
        map.put("MerchantId", merchantId);

        return map;
    }

    private void initiatingFields() {
        bankRecordID = "";
        status = "0";
        documentDate = DateUtils.definitionCurrentTime();
        documentNumber = DocumentNumber.docNum;
        senderOfficials = "";
        customerBankRecordID = UserFilter.orgId;
        receiverID = "+79999999999";
        receiverPAM = "";
        receiverUserINN = "7726587769";
        receiverName = "";
        receiverMiddleName = "";
        receiverSurname = "";
        receiverSbpBankName = GetDictBanksSBP.rootTag.getListDS().get(0).getListR().get(0).getNamemem();
        receiverSbpBankBIC = GetDictBanksSBP.rootTag.getListDS().get(0).getListR().get(0).getBic();
        receiverSbpBankMemberID = GetDictBanksSBP.rootTag.getListDS().get(0).getListR().get(0).getIdmemsbp();
        receiverAccount = "";
        amount = "50000";
        ground = "";
        incomeCode = "1";
        merchantName = GetDictTSP.rootTag.getListDS().get(0).getListR().get(0).getUsermerch();
        merchantRegName = GetDictTSP.rootTag.getListDS().get(0).getListR().get(0).getNametsp();
        merchantId = GetDictTSP.rootTag.getListDS().get(0).getListR().get(0).getIdtsp();
        payerBankBIC = UserFilter.orgINN;
        payerName = UserFilter.orgName.replaceAll("\"", "&quot;");
        payerINN = UserFilter.orgINN;

    }

    private void definingPayAcc() {
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810") & UserAccount.rootTag.getListA().get(i).getO().equals(UserFilter.rootTag.getListC().get(0).getI())) {
                branchBankRecordID = UserAccount.rootTag.getListA().get(i).getF();
                payerAccount = UserAccount.rootTag.getListA().get(i).getA();
                currCode = UserAccount.rootTag.getListA().get(i).getY();
                break;
            }
        }
    }
}
