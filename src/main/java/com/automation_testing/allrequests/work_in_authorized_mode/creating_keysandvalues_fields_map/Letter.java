package com.automation_testing.allrequests.work_in_authorized_mode.creating_keysandvalues_fields_map;

import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetDictMessageType;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.utils.DateUtils;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Letter {

    private String bankRecordID;
    private String status;
    private String documentDate;
    private String documentNumber;
    private String title;
    private String message;
    private String noteFromBank;
    private String customerBankRecordID;
    private String branchBankRecordID;
    private String branchName;
    private String messageType;
    private String messageTypeID;

    public Map<String, String> creatingLetterFields() {
        initiatingDevision();
        initiatingMessageType();
        initiatingFields();
        Map<String, String> map = new HashMap<>();
        map.put("BankRecordID", bankRecordID);
        map.put("Status", status);
        map.put("DocumentDate", documentDate);
        map.put("DocumentNumber", documentNumber);
        map.put("Title", title);
        map.put("Message", message);
        map.put("NoteFromBank", noteFromBank);
        map.put("CustomerBankRecordID", customerBankRecordID);
        map.put("BranchBankRecordID", branchBankRecordID);
        map.put("BranchName", branchName);
        map.put("MessageType", messageType);
        map.put("MessageTypeID", messageTypeID);
        return map;
    }

    private void initiatingFields() {
        bankRecordID = "";
        status = "";
        documentDate = DateUtils.definitionCurrentTime();
        documentNumber = DocumentNumber.docNum;
        title = "tema";
        message = "message";
        noteFromBank = "";
        customerBankRecordID = UserFilter.orgId;

    }

    private void initiatingDevision() {
        for (int i = 0; i < UserFilter.orgList.size(); i++) {
            for (int j = 0; j < UserFilter.orgList.get(i).getDivisionList().size(); j++) {
            //    if (UserFilter.orgList.get(i).getTb().equals("1")) {
                    branchBankRecordID = UserFilter.orgList.get(i).getDivisionList().get(j).getId();
                    branchName = UserFilter.orgList.get(i).getDivisionList().get(j).getN().replaceAll("\"", "&quot;");
                    break;
             //   }
            }
        }
    }

    private void initiatingMessageType() {
        for (int i = 0; i < GetDictMessageType.rootTag.getListR().size(); i++) {
            if (GetDictMessageType.rootTag.getListR().get(i).getT().contains("Письмо")) {
                messageType = GetDictMessageType.rootTag.getListR().get(i).getT();
                messageTypeID = GetDictMessageType.rootTag.getListR().get(i).getA();
            }
        }
    }
}
