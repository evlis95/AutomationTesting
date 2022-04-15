package com.autotest.allrequests.connect;

import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;


import javax.xml.bind.JAXBException;
import java.io.*;


public class Bank extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
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
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}







