package com.autotest.allrequests.work_in_authorized_mode.dictionary;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictStat1256 extends Post {

    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetDictStat1256");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag stat1256 = new UniversalRequestRootTag();

        stat1256.setC("getdict");
        stat1256.setT("dictionary");
        stat1256.setN("stat1256");
        stat1256.setV(1.0);
        stat1256.setS(AuthLogin.sessionID);

        marshallSetting(stat1256);
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
