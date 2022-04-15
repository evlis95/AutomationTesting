package com.autotest.allrequests.work_in_authorized_mode.dictionary;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictSalaryAcc extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetDictSalaryAccount");
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
            request();
            writeBodyResponseInFile();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                failedResponseMessage();
            }
    }
}