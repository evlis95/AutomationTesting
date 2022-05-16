package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class AuthRoles extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag roles = new UniversalRequestRootTag();
        roles.setC("");
        roles.setT("auth");
        roles.setN("roles");
        roles.setV(1.0);
        roles.setS(AuthLogin.sessionID);
        marshalling(roles);
    }

    @Override
    protected void checkTest() throws IOException, JAXBException {
        Check.checkCode200(codeStatusResponse,"AuthRoles");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        rootTag = Post.rootTag;
    }
}
