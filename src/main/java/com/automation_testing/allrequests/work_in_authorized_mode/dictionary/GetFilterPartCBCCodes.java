package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
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
        marshallSetting(cbcCodes);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = parsingResponseBody();
            cbcCodeValue = rootTag.getListP().get(0).getListR().get(0).getD();
        }
    }
}
