package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetFilterPartCBCCodes extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String cbcCodeValue;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetFilterPartCBCCodes");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag cbcCodes = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        cbcCodes.setV(1.0);
        cbcCodes.setC("getfilterpart");
        cbcCodes.setN("cbccodes");
        cbcCodes.setT("dictionary");
        cbcCodes.setS(AuthLogin.sessionID);

        tagP.setD("18210101011011000110");
        tagP.setP("0");

        cbcCodes.setTagP(tagP);
        marshalling(cbcCodes);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            cbcCodeValue = rootTag.getListP().get(0).getListR().get(0).getD();
        }
    }
}
