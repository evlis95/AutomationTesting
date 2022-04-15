package com.autotest.allrequests.authorization;

import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;

import com.autotest.post_request_type.Post;

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
