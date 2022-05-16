package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class UserAccount extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag userAccount = new UniversalRequestRootTag();
        userAccount.setC("user");
        userAccount.setT("dictionary");
        userAccount.setN("account");
        userAccount.setV(3.1);
        userAccount.setS(AuthLogin.sessionID);

        marshalling(userAccount);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "UserAccount");
    }

    private void parsingDataAndSaveInBD() {

    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            parsingDataAndSaveInBD();
        }
    }
}
