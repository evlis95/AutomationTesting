package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

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

        marshallSetting(userAccount);
    }

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "UserAccount");
    }



    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            printReqAndResInLog();
            checkTest();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
            } 
    }
}
