package com.autotest.allrequests.connect;

import com.autotest.checks.Check;
import com.autotest.creatingxml.TagAboutOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;

import com.autotest.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;

public class Style40 extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
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
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                failedResponseMessage();
            }
    }
}