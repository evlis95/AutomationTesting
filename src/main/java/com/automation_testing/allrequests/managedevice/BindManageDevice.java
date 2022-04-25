package com.automation_testing.allrequests.managedevice;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class BindManageDevice extends Post {

    public static boolean resultBinding;
    final static Logger LOG = LogManager.getLogger(BindManageDevice.class);
    public static UniversalResponseRootTag rootTag;
    private final CrypProfCodeManagDev crypProfCodeManagDev = new CrypProfCodeManagDev();
    private final SmsCodeManageDev smsCodeManageDev = new SmsCodeManageDev();
    private final SendCodeManageDev sendCodeManageDev = new SendCodeManageDev();


    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "BindManageDevice");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("");
        device.setT("managedevice");
        device.setN("bind");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        device.setTagP(new TagPOfUnivReq("d8eb432fb028c2b3"));
        marshallSetting(device);
    }

    private void bindingDevice() throws JAXBException, IOException, InterruptedException {
        if (rootTag.getListA().get(0).getV().equals("0")) {
           LOG.error("""
                    Внимание! Добавление/удаление устройства в списке доверенных невозможно.
                    За дополнительной информацией, пожалуйста, обратитесь в банк.
                    Настройка Конфигурация ДБО. Мобильный клиент. Доступность работы с доверенными устройствами значение false.
                      """);


        } else if (rootTag.getListA().get(0).getV().equals("11")) {
           LOG.error("Доступно подтверждение только через сервис PayControl.");

        } else {
            crypProfCodeManagDev.run();
            smsCodeManageDev.run();
            sendCodeManageDev.run();
            if (SendCodeManageDev.condition.equals("1")) {
               LOG.info("Доступ разрешен (устройство привязано). Проверка на привязку устройства - PASS.\n");
                Check.quantityPASS++;
                resultBinding = true;
            } else {
               LOG.error("Проверка привязки устройства - FAILED.");
                Check.quantityFAILED++;
                resultBinding = false;
            }
        }
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            bindingDevice();
        }
    }
}



