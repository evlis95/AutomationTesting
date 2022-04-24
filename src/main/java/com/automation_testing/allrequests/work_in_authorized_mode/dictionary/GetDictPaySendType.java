package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictPaySendType extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetdictPaySendType");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag paySendType = new UniversalRequestRootTag();
        paySendType.setC("getdict");
        paySendType.setT("dictionary");
        paySendType.setN("paysendtype");
        paySendType.setV(1.0);
        paySendType.setS(AuthLogin.sessionID);
        marshallSetting(paySendType);
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


