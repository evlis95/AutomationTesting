package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class AuthAccess extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "AuthAccess");
    }



    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authAccess = new UniversalRequestRootTag();
        authAccess.setC("");
        authAccess.setT("auth");
        authAccess.setN("access");
        authAccess.setV(1.0);
        authAccess.setS(AuthLogin.sessionID);

        marshallSetting(authAccess);
    }


    @Override
    public void run() throws IOException, InterruptedException, JAXBException {

            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
                printReqAndResInLog();
            } else {
                printReqAndResInLog();
                Check.quantityFAILED++;
            }
    }
}