package com.autotest.allrequests.managedevice;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;
import com.autotest.testruns.TestRunClassicBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class UnBindManageDevice extends Post {
    private final CrypProfCodeManagDev crypProfCodeManagDev = new CrypProfCodeManagDev();
    private final GetDictManageDevList getDictManageDevList = new GetDictManageDevList();
    private final BindManageDevice bindManageDevice = new BindManageDevice();
    private final SmsCodeManageDev smsCodeManageDev = new SmsCodeManageDev();
    private final SendCodeManageDev sendCodeManageDev = new SendCodeManageDev();
    private final Logger log = LogManager.getLogger(UnBindManageDevice.class);
    public static UniversalResponseRootTag rootTag;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "UnBindManageDevice");
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
        marshallSetting(device);
    }

    private void unbindingAndBindingDevice() throws JAXBException, IOException, InterruptedException {
        crypProfCodeManagDev.run();
        smsCodeManageDev.run();
        sendCodeManageDev.run();
        if (SendCodeManageDev.condition.equals("0") || (SendCodeManageDev.condition.equals("2"))) {
            log.info("Проверка на отвязку устройства - PASS\n");
            Check.quantityPASS++;
            bindManageDevice.run();
        } else {
            log.error("Проверка на отвязку устройства - FAILED\n");
            Check.quantityFAILED++;
        }
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        getDictManageDevList.run();
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
            unbindingAndBindingDevice();
        } else {
            failedResponseMessage();
        }
    }
}



