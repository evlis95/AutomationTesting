package com.autotest.allrequests.work_in_authorized_mode.create_pay_ord;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagReqActOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class PutPaymentOrderDocFORCE extends Post {

    private final String documentID;
    private String documentBankID;
    private UniversalResponseRootTag rootTag;

    public UniversalResponseRootTag getRootTag() {
        return rootTag;
    }

    public String getDocumentBankID() {
        return documentBankID;
    }

    public PutPaymentOrderDocFORCE(String documentID) {
        this.documentID = documentID;
    }

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "FORCE");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag force = new UniversalRequestRootTag();
        TagReqActOfUnivReq tagReqAct = new TagReqActOfUnivReq();
        force.setC("put");
        force.setT("document");
        force.setN("PaymentOrder");
        force.setV(3.1);
        force.setS(AuthLogin.sessionID);
        tagReqAct.setV("FORCE");
        tagReqAct.setDocID(documentID);
        force.setTagReqAct(tagReqAct);
        marshallSetting(force);
    }

    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            documentBankID = rootTag.getListF().get(0).getI();


            checkTest();
        } else {
            failedResponseMessage();
        }
    }


}
