package com.autotest.allrequests.authorization;

import com.autotest.checks.Check;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;

public class AuthCryptoprofCode extends Post {

    public static UniversalResponseRootTag rootTag;



    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "AuthCryptoProfilesCode");
    }



    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authCryProCode = new UniversalRequestRootTag();
        authCryProCode.setC("cryptoprofiles");
        authCryProCode.setT("auth");
        authCryProCode.setN("code");
        authCryProCode.setV(1.0);
        authCryProCode.setS(AuthLogin.sessionID);

        marshallSetting(authCryProCode);
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