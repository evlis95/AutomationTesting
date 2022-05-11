package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class VersionInfo extends Post {

    public static UniversalResponseRootTag rootTagA;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "VersionInfo");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag versionInfo = new UniversalRequestRootTag();
        versionInfo.setT("dictionary");
        versionInfo.setC("getdict");
        versionInfo.setN("versionsinfo");
        versionInfo.setV(1.0);
        marshalling(versionInfo);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTagA = unmarshalling();
        }
    }
}