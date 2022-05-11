package com.automation_testing.allrequests.work_in_authorized_mode.template;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetTemplate extends Post {

    private final String templateID;
    public static UniversalResponseRootTag rootTag;

    public GetTemplate(String templateID) {
        this.templateID = templateID;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetTemplate");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag rootTagRequest = new UniversalRequestRootTag();

        rootTagRequest.setC("gettemplate");
        rootTagRequest.setT("document");
        rootTagRequest.setN("PaymentOrder");
        rootTagRequest.setV(1.0);
        rootTagRequest.setS(AuthLogin.sessionID);

        TagPOfUnivReq tagP = new TagPOfUnivReq(templateID);
        rootTagRequest.setTagP(tagP);

        marshalling(rootTagRequest);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if(codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
