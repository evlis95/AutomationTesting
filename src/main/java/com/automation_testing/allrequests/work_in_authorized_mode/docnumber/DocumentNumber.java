package com.automation_testing.allrequests.work_in_authorized_mode.docnumber;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.utils.DateUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class DocumentNumber extends Post {

    public static String docNum;
    public static UniversalResponseRootTag rootTag;
    private String docType;

    public DocumentNumber(String docType) {
        this.docType = docType;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "DocumentNumber");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag docNum = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        docNum.setC("documentnumber");
        docNum.setT("document");
        docNum.setN(docType);
        docNum.setV(1.0);
        docNum.setS(AuthLogin.sessionID);

        tagP.setA(DateUtils.definitionCurrentTime());
        tagP.setB(UserFilter.rootTag.getListC().get(0).getI());

        docNum.setTagP(tagP);

        marshalling(docNum);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            docNum = rootTag.getListF().get(0).getV();
        }
    }
}