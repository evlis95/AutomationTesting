package com.automation_testing.allrequests.managedevice;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.TagSOfUnivRes;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class CrypProfCodeManagDev extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String spID;
    private final Logger LOG = LogManager.getLogger(CrypProfCodeManagDev.class);

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "CrypProfCodeManagDev");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();

        device.setC("cryptoprofiles");
        device.setT("managedevice");
        device.setN("code");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);

        marshalling(device);
    }

    private void definingSPID() {
        if (rootTag.getListS() != null) {
            for (TagSOfUnivRes tagS : rootTag.getListS()) {
                if (tagS.getT().equals("1")) {
                    spID = tagS.getU();
                    break;
                }
            }
        } else {
            LOG.error("Проверка наличия хотя бы 1 СП OTP для подписи действия с доверенными устройствами - FAILED");
        }
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            definingSPID();
        }
    }
}