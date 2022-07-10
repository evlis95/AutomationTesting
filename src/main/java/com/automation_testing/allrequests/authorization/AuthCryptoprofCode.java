package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class AuthCryptoprofCode extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "AuthCryptoProfilesCode");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authCryProCode = new UniversalRequestRootTag();
        authCryProCode.setC("cryptoprofiles");
        authCryProCode.setT("auth");
        authCryProCode.setN("code");
        authCryProCode.setV(1.0);
        authCryProCode.setS(AuthLogin.sessionID);
        marshalling(authCryProCode);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}