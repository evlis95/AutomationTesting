package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictIncomeType extends Post {

    public  static UniversalResponseRootTag rootTag;

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag sbp = new UniversalRequestRootTag();
        sbp.setC("getdict");
        sbp.setT("dictionary");
        sbp.setN("incometype");
        sbp.setV(1.0);
        sbp.setS(AuthLogin.sessionID);

        marshalling(sbp);
    }

    @Override
    protected void checkTest() throws IOException, JAXBException {
        Check.checkCode200(codeStatusResponse,"GetDictIncomeType");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        rootTag = Post.rootTag;
    }
}
