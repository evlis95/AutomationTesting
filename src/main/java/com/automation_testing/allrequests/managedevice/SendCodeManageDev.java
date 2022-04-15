package com.autotest.allrequests.managedevice;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SendCodeManageDev extends Post {

    private final static Logger log = LogManager.getLogger(SendCodeManageDev.class);
    public static UniversalResponseRootTag rootTag;
    public static String successfullyCode;
    public static String condition;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "SendCodeManageDev");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("send");
        device.setT("managedevice");
        device.setN("code");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        device.setTagU(CrypProfCodeManagDev.spID);
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setC("1");
        device.setTagP(tagP);
        marshallSetting(device);
    }

    private void info() {
        successfullyCode = rootTag.getListS().get(0).getV();
        condition = rootTag.getListS().get(0).getZ();
        if (successfullyCode.equals("1")) {
            log.info("Проверка кода подтверждения операции - PASS\n");
            Check.quantityPASS++;
        } else {
            log.error("Проверка кода подтверждения операции - FAILED\n");
            Check.quantityFAILED++;
        }
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
            info();
        } else {
            failedResponseMessage();
        }
    }
}