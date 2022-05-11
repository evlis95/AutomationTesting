package com.automation_testing.allrequests.managedevice;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class UnBindManageDevice extends Post {
    private final CrypProfCodeManagDev CRYPT_PROF_MANAGE_DEVICE = new CrypProfCodeManagDev();
    private final GetDictManageDevList GET_DICT_MAN_DEV = new GetDictManageDevList();
    private final BindManageDevice BIND = new BindManageDevice();
    private final SmsCodeManageDev SMS_CODE_MAN_DEV = new SmsCodeManageDev();
    private final SendCodeManageDev SEND_CODE_MAN_DEV = new SendCodeManageDev();
    private final Logger LOG = LogManager.getLogger(UnBindManageDevice.class);
    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "UnBindManageDevice");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("");
        device.setT("managedevice");
        device.setN("unbind");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setA(GetDictManageDevList.deviceBankID);
        device.setTagP(tagP);
        marshalling(device);
    }

    private void unbindingAndBindingDevice() throws JAXBException, IOException, InterruptedException {
        CRYPT_PROF_MANAGE_DEVICE.run();
        SMS_CODE_MAN_DEV.run();
        SEND_CODE_MAN_DEV.run();
        if (SendCodeManageDev.condition.equals("0") || (SendCodeManageDev.condition.equals("2"))) {
            LOG.info("Проверка на отвязку устройства - PASS\n");
            Check.quantityPASS++;
            BIND.run();
        } else {
            LOG.error("Проверка на отвязку устройства - FAILED\n");
            Check.quantityFAILED++;
        }
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        GET_DICT_MAN_DEV.run();
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = unmarshalling();
            unbindingAndBindingDevice();
        }
    }
}



