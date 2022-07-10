package com.automation_testing.allrequests.work_in_authorized_mode.create_letter;

import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetDictMessageType;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.parsing_xml.TagFOfTagUnivRes;
import com.automation_testing.parsing_xml.TagROfTagUnivRes;
import com.automation_testing.parsing_xml.TagVOfTagUnivRes;
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
        for (TagROfTagUnivRes tagR : GetDictMessageType.rootTag.getListR()) {
            if (tagR.getT().contains("Письмо")) {
                messageType = tagR.getT();
                messageTypeID = tagR.getA();
            }
        }
    }

    private void initiatingDivisionAndDivName() {
        for (TagVOfTagUnivRes tagV : UserFilter.rootTag.getListV()) {
            if (tagV.getDtb().equals("1") || tagV.getDfb().equals("1")) {
                for (TagFOfTagUnivRes tagF : UserFilter.rootTag.getListF()) {
                    if (tagV.getF().equals(tagF.getI())) {
                        branchBankRecordID = tagF.getI();
                        branchName = tagF.getN().replaceAll("\"", "&quot;");
                    }
                }
            }
        }
    }
}
