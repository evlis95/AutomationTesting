package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class SmsAuthCode extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "SMSAuthCode");
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
        marshalling(smsAuthCode);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}