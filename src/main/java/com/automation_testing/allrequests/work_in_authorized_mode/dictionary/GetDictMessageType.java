package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDictMessageType extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictMessageType");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag messType = new UniversalRequestRootTag();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        messType.setC("getdict");
        messType.setT("dictionary");
        messType.setN("messagetype");
        messType.setV(1.0);
        messType.setS(AuthLogin.sessionID);
        tagP.setG(UserFilter.rootTag.getListC().get(0).getI());
        listP.add(tagP);
        messType.setListP(listP);
        marshalling(messType);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = unmarshalling();
        }
    }
}