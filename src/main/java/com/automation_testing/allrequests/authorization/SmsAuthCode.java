package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class SmsAuthCode extends Post {

    public static UniversalResponseRootTag rootTag;


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "SMSAuthCode");
    }


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag smsAuthCode = new UniversalRequestRootTag();
        smsAuthCode.setT("auth");
        smsAuthCode.setC("sms");
        smsAuthCode.setN("code");
        smsAuthCode.setV(1.0);
        smsAuthCode.setS(AuthLogin.sessionID);

        for (int i = 0; i < AuthCryptoprofCode.rootTag.getListS().size(); i++) {
            if (AuthCryptoprofCode.rootTag.getListS().get(i).getT().equals("1")) {
                smsAuthCode.setTagU(AuthCryptoprofCode.rootTag.getListS().get(i).getU());
                break;
            }
        }
        marshallSetting(smsAuthCode);
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