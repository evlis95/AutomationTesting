package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictPayGrndParam extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetDictPayGrndParam");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag payGRND = new UniversalRequestRootTag();

        payGRND.setC("getdict");
        payGRND.setT("dictionary");
        payGRND.setN("paygrndparam");
        payGRND.setV(1.0);
        payGRND.setS(AuthLogin.sessionID);
        marshallSetting(payGRND);
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