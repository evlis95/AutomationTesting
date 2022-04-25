package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class TooltipPaymentOrder extends Post {

    public static UniversalResponseRootTag rootTag;

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "TooltipPaymentOrder");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag tooltip = new UniversalRequestRootTag();
        tooltip.setC("tooltip");
        tooltip.setT("document");
        tooltip.setN("PaymentOrder");
        tooltip.setV(1.0);
        tooltip.setS(AuthLogin.sessionID);
        marshallSetting(tooltip);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            checkTest();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
            } 
    }
}
