package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class TooltipPaymentOrder extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "TooltipPaymentOrder");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag tooltip = new UniversalRequestRootTag();

        tooltip.setC("tooltip");
        tooltip.setT("document");
        tooltip.setN("PaymentOrder");
        tooltip.setV(1.0);
        tooltip.setS(AuthLogin.sessionID);

        marshalling(tooltip);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if(codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
