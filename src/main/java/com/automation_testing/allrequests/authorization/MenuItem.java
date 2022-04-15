package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class MenuItem extends Post {


    public static UniversalResponseRootTag rootTag;


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "MenuItem");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag menuItem = new UniversalRequestRootTag();
        menuItem.setC("getdict");
        menuItem.setT("dictionary");
        menuItem.setN("menuitem");
        menuItem.setV(1.0);
        menuItem.setS(AuthLogin.sessionID);

        marshallSetting(menuItem);
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

