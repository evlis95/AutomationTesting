package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictCustomerKPP extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictCustomerKPP");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag cusKPP = new UniversalRequestRootTag();
        cusKPP.setC("getdict");
        cusKPP.setT("dictionary");
        cusKPP.setN("customerkpp");
        cusKPP.setV(1.0);
        cusKPP.setS(AuthLogin.sessionID);
        marshallSetting(cusKPP);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            printReqAndResInLog();
            checkTest();
            if (codeStatusResponse == 200) {
                rootTag = parseXmlBodyResponse();
            }
    }
}