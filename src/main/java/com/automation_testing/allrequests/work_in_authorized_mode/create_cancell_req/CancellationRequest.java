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
    private final Map<String, String> MAP = new LinkedHashMap<>();
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
        MAP.put("BankRecordID", "");
        MAP.put("Status", "0");
        MAP.put("DocumentDate", documentDate);
        MAP.put("DocumentNumber", documentNumber);
        MAP.put("SenderOfficial", "");
        MAP.put("CustomerBankRecordID", customerBankRecordID);
        MAP.put("BranchBankRecordID", branchBankRecordID);
        MAP.put("CancelDocNumber", cancelDocNumber);
        MAP.put("CancelDocType", cancelDocType);
        MAP.put("CancelDocDate", cancelDocDate);
        MAP.put("CancelDocAmount", cancelDocAmount);
        MAP.put("CancelDocCurrCode", cancelDocCurrCode);
        MAP.put("CancelDocBankRecordID", cancelDocBankRecordID);
        MAP.put("CancelDocMandatoryFields", "");
        MAP.put("CancelDocNotification", cancelDocNotification);
        MAP.put("CancelDocTariff", "");

        return MAP;
    }
}
