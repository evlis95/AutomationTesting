package com.automation_testing.allrequests.managedevice;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.SmsAuthCode;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.utils.CryptoUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SendCodeManageDev extends Post {

    private final Logger LOG = LogManager.getLogger(SendCodeManageDev.class);
    public static UniversalResponseRootTag rootTag;
    public static String successfullyCode;
    public static String condition;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "SendCodeManageDev");
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
        tagP.setC(CryptoUtils.generateSignForAuthCode("555555",
                AuthLogin.sessionID,
                SmsCodeManageDev.rootTag.getListP().get(0).getH(),
                SmsCodeManageDev.rootTag.getListP().get(0).getU(),
                SmsCodeManageDev.rootTag.getListP().get(0).getJ(),
                SmsCodeManageDev.rootTag.getListP().get(0).getI(),
                SmsCodeManageDev.rootTag.getListP().get(0).getK(),
                SmsCodeManageDev.rootTag.getListP().get(0).getAtrL(),
                SmsCodeManageDev.rootTag.getListP().get(0).getA(),
                SmsCodeManageDev.rootTag.getListP().get(0).getB()));
        device.setTagP(tagP);
        marshalling(device);
    }

    private void info() {
        successfullyCode = rootTag.getListS().get(0).getV();
        condition = rootTag.getListS().get(0).getZ();
        if (successfullyCode.equals("1")) {
            LOG.info("Проверка кода подтверждения операции - PASS\n");
            Check.quantityPASS++;
        } else {
            LOG.error("Проверка кода подтверждения операции - FAILED\n");
            Check.quantityFAILED++;
        }
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if(codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            info();
        }
    }
}