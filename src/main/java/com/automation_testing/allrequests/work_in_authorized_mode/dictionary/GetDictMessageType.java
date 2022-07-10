package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictMessageType extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictMessageType");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag messType = new UniversalRequestRootTag();


        TagPOfUnivReq tagP = new TagPOfUnivReq();

        messType.setC("getdict");
        messType.setT("dictionary");
        messType.setN("messagetype");
        messType.setV(1.0);
        messType.setS(AuthLogin.sessionID);
        tagP.setG(UserFilter.rootTag.getListC().get(0).getI());

        messType.setTagP(tagP);
        marshalling(messType);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}