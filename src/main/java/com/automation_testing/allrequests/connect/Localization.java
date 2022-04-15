package com.autotest.allrequests.connect;

import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

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

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "Localization");
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