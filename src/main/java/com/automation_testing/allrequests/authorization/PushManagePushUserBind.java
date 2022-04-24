package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class PushManagePushUserBind extends Post {


    public static UniversalResponseRootTag rootTag;


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag managePushUserBind = new UniversalRequestRootTag();

        managePushUserBind.setC("push");
        managePushUserBind.setT("managepush");
        managePushUserBind.setN("userbind");
        managePushUserBind.setV(1.0);
        managePushUserBind.setS(AuthLogin.sessionID);
        managePushUserBind.setP("cBPV8WtMQAqGVBFpqNrZgZ:APA91bFpVr7dMTAnwgYO6Uwvyor5OOBQjS2Eq45PC3wwL1-8GgFe24tI7E_NG75BC0FLAoaCQmH_Csfw8AW9UnX3rYxdTTwy1DLvgMgTCEFngy2ZnLlX7qW-zBxBpkqgNJjSy3CuE2nN");
        marshallSetting(managePushUserBind);
    }

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "PushManagePushUserBind");
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
            printReqAndResInLog();
            Check.quantityFAILED++;
        }
    }
}