package com.automation_testing.allrequests.managedevice;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictManageDevList extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String deviceBankID;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetDictManageDevList");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("getdict");
        device.setT("dictionary");
        device.setN("managedevicelist");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        marshalling(device);
    }

    private void definingDeviceBankID() {
        for (int i = 0; i < rootTag.getListD().size(); i++) {
            if (rootTag.getListD().get(i).getI().equals("d8eb432fb028c2b3")) {
                deviceBankID = rootTag.getListD().get(i).getA();
                break;
            }
        }
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if(codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            definingDeviceBankID();
        }
    }
}
