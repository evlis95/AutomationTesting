package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;


import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictRemoteCorrespDictionary extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictRemoteCorr");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag getDictRemoteCorr = new UniversalRequestRootTag();
        getDictRemoteCorr.setC("getdict");
        getDictRemoteCorr.setT("dictionary");
        getDictRemoteCorr.setN("remotecorresp");
        getDictRemoteCorr.setV(1.0);
        getDictRemoteCorr.setS(AuthLogin.sessionID);
        marshallSetting(getDictRemoteCorr);
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