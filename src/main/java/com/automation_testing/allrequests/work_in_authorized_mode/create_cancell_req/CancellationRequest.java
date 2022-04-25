package com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req;


import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.PaymentOrder;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.PaymentOrderTarget;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocCHECKCODE;
import com.automation_testing.checks.Check;
import com.automation_testing.testruns.TestRunClassicBox;

import java.util.LinkedHashMap;
import java.util.Map;

public class CancellationRequest {
    private final Map<String, String> map = new LinkedHashMap<>();
    private String documentDate;
    private String documentNumber;
    private String customerBankRecordID;
    private String branchBankRecordID;
    private String cancelDocNumber;
    private String cancelDocType;
    private String cancelDocDate;
    private String cancelDocAmount;
    private String cancelDocCurrCode;
    private String cancelDocBankRecordID;
    private String cancelDocNotification;


    public Map<String, String> initialCalReqFields() {
        if ("PaymentOrder".equals(PutDocAction.documentTypeString)) {
            Map<String,String> mapPaymentOrder;
            if (Check.checkCountAvailableAccounts810()) {
                mapPaymentOrder = new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_YOURSELF).creating();
            } else {
                mapPaymentOrder = new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_BUDGET).creating();
            }
            documentDate = mapPaymentOrder.get("DocumentDate");
            documentNumber = DocumentNumber.docNum;
            customerBankRecordID = mapPaymentOrder.get("CustomerBankRecordID");
            branchBankRecordID = mapPaymentOrder.get("BranchBankRecordID");
            cancelDocNumber = PutDocCHECKCODE.documentNumber;
            cancelDocType = "PaymentOrder";
            cancelDocDate = mapPaymentOrder.get("DocumentDate");
            cancelDocAmount = mapPaymentOrder.get("Amount");
            cancelDocCurrCode = mapPaymentOrder.get("CurrCode");;
            cancelDocBankRecordID = PutDocCHECKCODE.documentBankID;
            cancelDocNotification = "message";
        }
        map.put("BankRecordID", "");
        map.put("Status", "0");
        map.put("DocumentDate", documentDate);
        map.put("DocumentNumber", documentNumber);
        map.put("SenderOfficial", "");
        map.put("CustomerBankRecordID", customerBankRecordID);
        map.put("BranchBankRecordID", branchBankRecordID);
        map.put("CancelDocNumber", cancelDocNumber);
        map.put("CancelDocType", cancelDocType);
        map.put("CancelDocDate", cancelDocDate);
        map.put("CancelDocAmount", cancelDocAmount);
        map.put("CancelDocCurrCode", cancelDocCurrCode);
        map.put("CancelDocBankRecordID", cancelDocBankRecordID);
        map.put("CancelDocMandatoryFields", "");
        map.put("CancelDocNotification", cancelDocNotification);
        map.put("CancelDocTariff", "");

        return map;
    }
}
