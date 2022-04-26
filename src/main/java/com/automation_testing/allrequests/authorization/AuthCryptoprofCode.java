package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class AuthCryptoprofCode extends Post {

    public static UniversalResponseRootTag rootTag;


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

        marshallSetting(authCryProCode);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = parsingResponseBody();
        }
    }
}