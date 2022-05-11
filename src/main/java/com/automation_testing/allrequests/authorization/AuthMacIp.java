package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.generalsettings.Settings;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthMacIp extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "AuthMacip");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authMacip = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        List<TagPOfUnivReq> listP = new ArrayList<>();

        authMacip.setT("auth");
        authMacip.setC("");
        authMacip.setN("macip");
        authMacip.setV(3.0);
        authMacip.setS(AuthLogin.sessionID);

        tagP.setApc("");
        tagP.setApv(Settings.APP_VERSION_NAME);
        tagP.setD("d8eb432fb028c2b3");
        tagP.setI("");
        tagP.setM("");
        tagP.setModel("");
        tagP.setOsv("Autotest");
        tagP.setOsvk("");
        tagP.setPn("com.bssys.mbcphone");
        long time = System.currentTimeMillis();
        String currentTime = Long.toString(time);
        tagP.setTermsDate(currentTime);

        listP.add(tagP);
        authMacip.setListP(listP);

        marshalling(authMacip);
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
