package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class AuthAccess extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "AuthAccess");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authAccess = new UniversalRequestRootTag();
        authAccess.setC("");
        authAccess.setT("auth");
        authAccess.setN("access");
        authAccess.setV(1.0);
        authAccess.setS(AuthLogin.sessionID);

        marshalling(authAccess);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}