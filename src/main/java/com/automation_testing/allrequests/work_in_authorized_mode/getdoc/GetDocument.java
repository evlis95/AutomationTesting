package com.automation_testing.allrequests.work_in_authorized_mode.getdoc;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDocument extends Post {

    public static UniversalResponseRootTag rootTag;
    private final String documentBankID;
    private String docType;



    public GetDocument(String documentBankID, String docType) {
        this.documentBankID = documentBankID;
        this.docType = docType;
    }

    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDocument");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag docNum = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        docNum.setC("get");
        docNum.setT("document");
        docNum.setN(docType);
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
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = parsingResponseBody();
        }
    }


}
