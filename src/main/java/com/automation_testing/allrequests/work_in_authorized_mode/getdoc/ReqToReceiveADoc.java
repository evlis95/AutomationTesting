package com.autotest.allrequests.work_in_authorized_mode.getdoc;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ReqToReceiveADoc extends Post {

    public static UniversalResponseRootTag rootTag;
    private final String documentBankID;

    public ReqToReceiveADoc(String documentBankID) {
        this.documentBankID = documentBankID;
    }

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "ReqToReceiveADoc");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag docNum = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        docNum.setC("get");
        docNum.setT("document");
        docNum.setN("PaymentOrder");
        docNum.setV(3.0);
        docNum.setS(AuthLogin.sessionID);
        tagP.setI(documentBankID);
        docNum.setTagP(tagP);
        marshallSetting(docNum);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }

}
