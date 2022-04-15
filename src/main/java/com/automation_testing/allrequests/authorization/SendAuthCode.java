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

public class SendAuthCode extends Post {

    public static UniversalResponseRootTag rootTag;
    

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "SendAuthCode");
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
        tagP.setC("1");

        for (int i = 0; i < AuthCryptoprofCode.rootTag.getListS().size(); i++) {
            if (AuthCryptoprofCode.rootTag.getListS().get(i).getT().equals("1")) {
                sendAuthCode.setTagU((AuthCryptoprofCode.rootTag.getListS().get(i).getU()));
                break;
            }
        }

        listP.add(tagP);
        sendAuthCode.setListP(listP);

        marshallSetting(sendAuthCode);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                failedResponseMessage();
            }
    }
}