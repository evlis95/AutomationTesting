package com.autotest.allrequests.managedevice;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetDictManageDevList extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String deviceBankID;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetDictManageDevList");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("getdict");
        device.setT("dictionary");
        device.setN("managedevicelist");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        marshallSetting(device);
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
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            definingDeviceBankID();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}
