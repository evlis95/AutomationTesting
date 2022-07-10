package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

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
        marshalling(localization);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "Localization");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}