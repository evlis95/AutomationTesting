package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;


import javax.xml.bind.JAXBException;
import java.io.*;


public class Bank extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "Bank");
    }


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag bank = new UniversalRequestRootTag();
        bank.setC("");
        bank.setT("dictionary");
        bank.setN("bank");
        bank.setV(6.0);
        bank.setTagP(new TagPOfUnivReq("xhdpi", "0"));
        marshallSetting(bank);
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







