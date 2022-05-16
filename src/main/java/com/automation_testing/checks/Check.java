package com.automation_testing.checks;

import com.automation_testing.allrequests.authorization.AuthCryptoprofCode;
import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class Check {
    private static final Logger LOG = LogManager.getLogger(Check.class);
    public static int quantityPASS;
    public static int quantityFAILED;
    private static int count;

    public static void checkCode200(@NotNull Integer value, String nameRequest) throws IOException {
        if (value.equals(200)) {
            LOG.info(String.format("Проверка кода 200 у ответа на запрос %s - PASS!", nameRequest));
            quantityPASS++;
        } else {
            LOG.error(String.format("Проверка кода 200 у ответа на запрос %s - FAILED!", nameRequest));
            quantityFAILED++;
        }
    }

    public static boolean checkCountAvailableAccounts810() {
        int accAvailable810 = 0;
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810"))
                accAvailable810++;
        }
        return accAvailable810 <= 1;
    }

    public static boolean checkAvailableSignatureToolOTP() throws IOException {
        boolean result = true;
        if (AuthCryptoprofCode.rootTag.getListS() != null) {
            for (int i = 0; i < AuthCryptoprofCode.rootTag.getListS().size(); i++) {
                if (AuthCryptoprofCode.rootTag.getListS().get(i).getT().equals("1")) {
                    LOG.info("Проверка на наличие хотя бы одного СП OTP для операции подписи - PASS");
                    quantityPASS++;
                    break;
                } else {
                    LOG.error("Проверка на наличие хотя бы одного СП OTP - FAILED" +
                            "Тестирование будет прервано");
                    quantityFAILED++;
                    result = false;
                }
            }
        } else {
            result = false;
            LOG.error("Проверка на наличие хотя бы одного СП OTP - FAILED" +
                    "Тестирование будет прервано");
            quantityFAILED++;
        }
        return result;
    }


}


