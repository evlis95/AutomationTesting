package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public class Bank extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "Bank");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag bank = new UniversalRequestRootTag();
        bank.setC("");
        bank.setT("dictionary");
        bank.setN("bank");
        bank.setV(6.0);
        bank.setTagP(new TagPOfUnivReq("xhdpi", "0"));
        marshalling(bank);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}







