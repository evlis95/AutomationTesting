package com.autotest.allrequests.work_in_authorized_mode.dictionary;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetFilterPartCBCCodes extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String cbcCodeValue;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetFilterPartCBCCodes");
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
        marshallSetting(cbcCodes);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            cbcCodeValue = rootTag.getListP().get(0).getListR().get(0).getD();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}
