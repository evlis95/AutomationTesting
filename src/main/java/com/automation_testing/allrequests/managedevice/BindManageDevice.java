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

public class BindManageDevice extends Post {

    final static Logger LOG = LogManager.getLogger(BindManageDevice.class);
    public static boolean resultBinding;
    public static UniversalResponseRootTag rootTag;
    private final CrypProfCodeManagDev MANAGE_DEVICE = new CrypProfCodeManagDev();
    private final SmsCodeManageDev SMS_CODE_MANAGE_DEVICE = new SmsCodeManageDev();
    private final SendCodeManageDev SEND_CODE_MANAGE_DEVICE = new SendCodeManageDev();

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "BindManageDevice");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag device = new UniversalRequestRootTag();
        device.setC("");
        device.setT("managedevice");
        device.setN("bind");
        device.setV(1.0);
        device.setS(AuthLogin.sessionID);
        device.setTagP(new TagPOfUnivReq("097e2a18390d4111"));
        marshalling(device);
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
            MANAGE_DEVICE.run();
            SMS_CODE_MANAGE_DEVICE.run();
            SEND_CODE_MANAGE_DEVICE.run();
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
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            bindingDevice();
        }
    }
}



