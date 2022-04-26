package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictStat1256 extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictStat1256");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag stat1256 = new UniversalRequestRootTag();

        stat1256.setC("getdict");
        stat1256.setT("dictionary");
        stat1256.setN("stat1256");
        stat1256.setV(1.0);
        stat1256.setS(AuthLogin.sessionID);

        marshallSetting(stat1256);
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
