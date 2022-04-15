package com.autotest.allrequests.work_in_authorized_mode.dictionary;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetFilterPartBankRu extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetFilterPartBankRuDict");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag getFilterPart = new UniversalRequestRootTag();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        getFilterPart.setC("getfilterpart");
        getFilterPart.setT("dictionary");
        getFilterPart.setN("bankru");
        getFilterPart.setV(1.0);
        getFilterPart.setS(AuthLogin.sessionID);
        tagP.setD("044525700");
        tagP.setP("0");
        listP.add(tagP);
        getFilterPart.setListP(listP);
        marshallSetting(getFilterPart);
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
