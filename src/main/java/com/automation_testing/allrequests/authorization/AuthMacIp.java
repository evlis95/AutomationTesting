package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.settings.Settings;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

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
        tagP.setTermsDate(Long.toString(System.currentTimeMillis()));

        authMacip.setTagP(tagP);
        marshalling(authMacip);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
