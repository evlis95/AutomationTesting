package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;

import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthLogin extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String sessionID;


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authLogin = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        authLogin.setT("auth");
        authLogin.setC("");
        authLogin.setN("login");
        authLogin.setV(1.0);

        tagP.setD("cbb99cc0763eb5c2");
        tagP.setLogin("izh");
        tagP.setPass("1");

        listP.add(tagP);
        authLogin.setListP(listP);
        marshallSetting(authLogin);
    }


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "AuthLogin");
    }


    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            sessionID = rootTag.getListS().get(0).getV();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}
