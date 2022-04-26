package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictSalaryAcc extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictSalaryAccount");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag salaryAcc = new UniversalRequestRootTag();
        salaryAcc.setC("getdict");
        salaryAcc.setT("dictionary");
        salaryAcc.setN("salaryaccount");
        salaryAcc.setV(1.0);
        salaryAcc.setS(AuthLogin.sessionID);
        marshallSetting(salaryAcc);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            executingRequest();
            writeBodyResponseInFile();
            printReqAndResInLog();
            checkTest();
            if (codeStatusResponse == 200) {
                rootTag = parsingResponseBody();
            } 
    }
}