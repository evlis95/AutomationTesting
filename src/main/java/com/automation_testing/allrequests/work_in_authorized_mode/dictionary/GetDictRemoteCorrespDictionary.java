package com.autotest.allrequests.work_in_authorized_mode.dictionary;


import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;

public class GetDictRemoteCorrespDictionary extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetDictRemoteCorr");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag getDictRemoteCorr = new UniversalRequestRootTag();
        getDictRemoteCorr.setC("getdict");
        getDictRemoteCorr.setT("dictionary");
        getDictRemoteCorr.setN("remotecorresp");
        getDictRemoteCorr.setV(1.0);
        getDictRemoteCorr.setS(AuthLogin.sessionID);
        marshallSetting(getDictRemoteCorr);
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