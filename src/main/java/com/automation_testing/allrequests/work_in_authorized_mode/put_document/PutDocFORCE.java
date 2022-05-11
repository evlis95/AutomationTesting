package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class PutDocFORCE extends Post {

    private final String DOC_ID;
    private String documentBankID;
    public static UniversalResponseRootTag rootTag;

    public UniversalResponseRootTag getRootTag() {
        return rootTag;
    }

    public String getDocumentBankID() {
        return documentBankID;
    }

    public PutDocFORCE(String documentID) {
        this.DOC_ID = documentID;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "FORCE");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag force = new UniversalRequestRootTag();
        TagReqActOfUnivReq tagReqAct = new TagReqActOfUnivReq();
        force.setC("put");
        force.setT("document");
        force.setN(PutDocAction.documentTypeString);
        force.setV(3.1);
        force.setS(AuthLogin.sessionID);
        tagReqAct.setV("FORCE");
        tagReqAct.setDocID(DOC_ID);
        force.setTagReqAct(tagReqAct);
        marshalling(force);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if(codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            documentBankID = rootTag.getListF().get(0).getI();
        }
    }
}
