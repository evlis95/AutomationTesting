package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.utils.CookiesUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
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

        tagP.setD("097e2a18390d4111");
        tagP.setLogin("1111111111");
        tagP.setPass("1111111111");

        listP.add(tagP);
        authLogin.setListP(listP);
        marshalling(authLogin);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "AuthLogin");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            sessionID = rootTag.getListS().get(0).getV();
            Post.addCookies(CookiesUtils.initiationSID());
            Post.editRTSRequest(sessionID);
        }
    }
}
