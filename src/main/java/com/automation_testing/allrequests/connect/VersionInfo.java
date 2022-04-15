package com.autotest.allrequests.connect;

import com.autotest.checks.Check;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class VersionInfo extends Post {

    public static UniversalResponseRootTag rootTagA;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "VersionInfo");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag versionInfo = new UniversalRequestRootTag();
        versionInfo.setT("dictionary");
        versionInfo.setC("getdict");
        versionInfo.setN("versionsinfo");
        versionInfo.setV(1.0);
        marshallSetting(versionInfo);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            if (getCodeStatusResponse() == 200) {
                rootTagA = parseXmlBodyResponse();
                checkTest();
            } else {
                failedResponseMessage();
            }
    }
}