package com.automation_testing.allrequests.work_in_authorized_mode.create_letter;

import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetDictMessageType;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Divisions;
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
    private String conversationID;
    private String replyForMessageID;
    private String senderOfficials;
    private String phoneOfficials;

    public Map<String, String> creatingLetterFields() {
        initiatingDivisionAndDivName();
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
        map.put("ConversationID", conversationID);
        map.put("ReplyForMessageID", replyForMessageID);
        map.put("SenderOfficials", senderOfficials);
        map.put("PhoneOfficials", phoneOfficials);
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
        conversationID = "";
        replyForMessageID = "";
        senderOfficials = "";
        phoneOfficials = "";
    }


    private void initiatingMessageType() {
        for (int i = 0; i < GetDictMessageType.rootTag.getListR().size(); i++) {
            if (GetDictMessageType.rootTag.getListR().get(i).getT().contains("Письмо")) {
                messageType = GetDictMessageType.rootTag.getListR().get(i).getT();
                messageTypeID = GetDictMessageType.rootTag.getListR().get(i).getA();
            }
        }
    }

    private void initiatingDivisionAndDivName() {
        for (int i = 0; i < UserFilter.rootTag.getListV().size(); i++) {
            if(UserFilter.rootTag.getListV().get(i).getDtb().equals("1") || UserFilter.rootTag.getListV().get(i).getDfb().equals("1")) {
                for (int j = 0; j < UserFilter.rootTag.getListF().size(); j++) {
                    if(UserFilter.rootTag.getListV().get(i).getF().equals(UserFilter.rootTag.getListF().get(j).getI())) {
                        branchBankRecordID = UserFilter.rootTag.getListF().get(j).getI();
                        branchName = UserFilter.rootTag.getListF().get(j).getN().replaceAll("\"","&quot;");
                    }
                }
            }
        }
    }
}
