package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagAboutOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;

import com.automation_testing.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;

public class Style40 extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "Style40");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag style40 = new UniversalRequestRootTag();
        TagAboutOfUnivReq tagAbout = new TagAboutOfUnivReq();
        style40.setT("dictionary");
        style40.setC("");
        style40.setN("style40");
        style40.setV(1.0);
        tagAbout.setH("auto");
        tagAbout.setW("auto");
        style40.setTagAbout(tagAbout);
        style40.setTagHash("");
        marshallSetting(style40);
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