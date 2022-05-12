package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.utils.CryptoUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<TagPOfUnivReq> listP = new ArrayList<>();

        sendAuthCode.setC("send");
        sendAuthCode.setT("auth");
        sendAuthCode.setN("code");
        sendAuthCode.setV(1.0);
        sendAuthCode.setS(AuthLogin.sessionID);
        tagP.setC(CryptoUtils.generateSignForAuthCode(
                "555555",
                AuthLogin.sessionID,
                SmsAuthCode.rootTag.getListP().get(0).getH(),
                SmsAuthCode.rootTag.getListP().get(0).getU(),
                SmsAuthCode.rootTag.getListP().get(0).getJ(),
                SmsAuthCode.rootTag.getListP().get(0).getI(),
                SmsAuthCode.rootTag.getListP().get(0).getK(),
                SmsAuthCode.rootTag.getListP().get(0).getAtrL(),
                SmsAuthCode.rootTag.getListP().get(0).getA(),
                SmsAuthCode.rootTag.getListP().get(0).getB()));

        for (int i = 0; i < AuthCryptoprofCode.rootTag.getListS().size(); i++) {
            if (AuthCryptoprofCode.rootTag.getListS().get(i).getT().equals("1")) {
                sendAuthCode.setTagU((AuthCryptoprofCode.rootTag.getListS().get(i).getU()));
                break;
            }
        }

        listP.add(tagP);
        sendAuthCode.setListP(listP);

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