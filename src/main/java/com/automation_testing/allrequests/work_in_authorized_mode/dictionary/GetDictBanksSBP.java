package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictBanksSBP extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag sbp = new UniversalRequestRootTag();
        sbp.setC("getdict");
        sbp.setT("dictionary");
        sbp.setN("bankssbp");
        sbp.setV(1.0);
        sbp.setS(AuthLogin.sessionID);

        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setD("");
        tagP.setP("0");

        sbp.setTagP(tagP);

        marshalling(sbp);
    }

    @Override
    protected void checkTest() throws IOException, JAXBException {
        Check.checkCode200(codeStatusResponse, "GetDictBanksSBP");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        rootTag = Post.rootTag;
    }
}
