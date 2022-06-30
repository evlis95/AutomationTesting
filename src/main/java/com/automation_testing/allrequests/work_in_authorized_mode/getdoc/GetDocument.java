package com.automation_testing.allrequests.work_in_authorized_mode.getdoc;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDocument extends Post {

    public static UniversalResponseRootTag rootTag;
    private final String documentBankID;
    private final String DOC_TYPE;


    public GetDocument(String documentBankID, String docType) {
        this.documentBankID = documentBankID;
        this.DOC_TYPE = docType;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDocument");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag docNum = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        docNum.setC("get");
        docNum.setT("document");
        docNum.setN(DOC_TYPE);
        docNum.setV(3.0);
        docNum.setS(AuthLogin.sessionID);
        tagP.setI(documentBankID);

        docNum.setTagP(tagP);
        marshalling(docNum);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
