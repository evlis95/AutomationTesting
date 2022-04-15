package com.autotest.allrequests.work_in_authorized_mode.dictionary;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.allrequests.authorization.UserFilter;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDictMessageType extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetDictMessageType");
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
        marshallSetting(messType);
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