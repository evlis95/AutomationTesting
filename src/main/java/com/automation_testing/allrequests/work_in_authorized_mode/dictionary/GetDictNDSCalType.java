package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictNDSCalType extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetdictNDSCalType");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag ndsCalType = new UniversalRequestRootTag();
        ndsCalType.setC("getdict");
        ndsCalType.setT("dictionary");
        ndsCalType.setN("ndscalculationtype");
        ndsCalType.setV(1.0);
        ndsCalType.setS(AuthLogin.sessionID);
        marshallSetting(ndsCalType);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            printReqAndResInLog();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                Check.quantityFAILED++;
            }
    }
}