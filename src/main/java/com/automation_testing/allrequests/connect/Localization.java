package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class Localization extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag localization = new UniversalRequestRootTag();
        localization.setT("dictionary");
        localization.setC("getdict");
        localization.setN("localization");
        localization.setV(1.0);
        localization.setTagP(new TagPOfUnivReq("IDEA", "", ""));
        marshallSetting(localization);
    }

    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "Localization");
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
                rootTag = parsingResponseBody();
            }
    }
}