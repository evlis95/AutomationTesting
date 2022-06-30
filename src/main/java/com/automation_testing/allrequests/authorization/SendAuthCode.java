package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.TagSOfUnivRes;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SendAuthCode extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "SendAuthCode");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag sendAuthCode = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        sendAuthCode.setC("send");
        sendAuthCode.setT("auth");
        sendAuthCode.setN("code");
        sendAuthCode.setV(1.0);
        sendAuthCode.setS(AuthLogin.sessionID);

        tagP.setC("1");

        for (TagSOfUnivRes tagS : AuthCryptoprofCode.rootTag.getListS()) {
            if (tagS.getT().equals("1")) {
                sendAuthCode.setTagU((tagS.getU()));
                break;
            }
        }

        sendAuthCode.setTagP(tagP);
        marshalling(sendAuthCode);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}