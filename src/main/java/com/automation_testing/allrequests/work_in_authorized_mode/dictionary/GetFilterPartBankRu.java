package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetFilterPartBankRu extends Post {

    public static UniversalResponseRootTag rootTag;


    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetFilterPartBankRuDict");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag getFilterPart = new UniversalRequestRootTag();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        getFilterPart.setC("getfilterpart");
        getFilterPart.setT("dictionary");
        getFilterPart.setN("bankru");
        getFilterPart.setV(1.0);
        getFilterPart.setS(AuthLogin.sessionID);
        tagP.setD("044525700");
        tagP.setP("0");
        listP.add(tagP);
        getFilterPart.setListP(listP);
        marshallSetting(getFilterPart);
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
