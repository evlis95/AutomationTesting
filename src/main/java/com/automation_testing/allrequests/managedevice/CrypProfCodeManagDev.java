package com.automation_testing.allrequests.managedevice;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class CrypProfCodeManagDev extends Post {

    private final static Logger log = LogManager.getLogger(CrypProfCodeManagDev.class);
    public static UniversalResponseRootTag rootTag;
    public static String spID;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "CrypProfCodeManagDev");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("cryptoprofiles");
        device.setT("managedevice");
        device.setN("code");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        marshallSetting(device);
    }

    private void definingSPID() {
        if (rootTag.getListS() != null) {
            for (int i = 0; i < rootTag.getListS().size(); i++) {
                if (rootTag.getListS().get(i).getT().equals("1")) {
                    spID = rootTag.getListS().get(i).getU();
                    break;
                }
            }
        } else {
            log.error("Проверка наличия хотя бы 1 СП OTP для подписи действия с доверенными устройствами - FAILED");
        }
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            definingSPID();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}