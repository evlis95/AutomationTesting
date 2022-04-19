package com.automation_testing.checks;

import com.automation_testing.allrequests.authorization.AuthCryptoprofCode;
import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Check {
    private final static Logger log = LogManager.getLogger(Check.class);
    public static int quantityPASS;
    public static int quantityFAILED;
    private static int count;

    public static void checkCode200(@NotNull Integer value, String nameRequest) throws IOException {
        if (value.equals(200)) {
            log.info(String.format("Проверка кода 200 у ответа на запрос %s - PASS!\n", nameRequest));
            quantityPASS++;
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

    public static void checkEnabledServiceD2BMAdvanced() {
        boolean result = false;
        for (int j = 0; j < UserFilter.rootTag.getListV().size(); j++) {
            if (UserFilter.rootTag.getListV().get(j).getAdv().equals("1")) {
                result = true;
                break;
            }
        }
        if (result) {
            log.info("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - PASS\n");
            Check.quantityPASS++;
        } else {
            log.error("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - FAILED. ВНИМАНИЕ!!!.\n");
            Check.quantityFAILED++;
        }
    }

    public static void checkCountAvailableSPForce(UniversalResponseRootTag rootTag) {
        if (PutDocAction.rootTag.getListC() != null) {
            if (PutDocAction.rootTag.getListC().get(0).getCe().equals("0")) {
                if (rootTag.getListK() != null) {
                    count = 0;
                    for (int i = 0; i < rootTag.getListK().size(); i++) {
                        if (rootTag.getListK().get(i).getT().equals("1")) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        log.info("Проверка на наличие хотя бы одного СП OTP для операции подписи - PASS\n");
                        quantityPASS++;
                    } else {
                        log.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED\n");
                        quantityFAILED++;
                    }
                } else {
                    quantityFAILED++;
                    log.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED\n");
                }
            }
        }
    }

    public static void checkCountAvailableSPSign(@NotNull UniversalResponseRootTag rootTag) {
        if (rootTag.getListK() == null & rootTag.getListC() == null) {
            log.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED\n");
            quantityFAILED++;

        } else if (rootTag.getListK() != null & rootTag.getListC() == null) {
            count = 0;
            for (int i = 0; i < rootTag.getListK().size(); i++) {
                if (rootTag.getListK().get(i).getT().equals("1")) {
                    count++;
                }
            }
            if (count > 0) {
                log.info("Проверка на наличие хотя бы одного СП OTP для операции подписи - PASS\n");
                quantityPASS++;
            } else {
                log.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED\n");

                quantityFAILED++;
            }

        } else if (rootTag.getListK() == null & rootTag.getListC() != null) {
            if (rootTag.getListC().get(0).getCe().equals("1")) {
                log.warn("Проверка на наличие хотя бы одного СП OTP для операции подписи не проводится, из за наличия жестких контролей\n");
            } else {
                log.warn("Проверка на наличие хотя бы одного СП OTP для операции подписи не будет проведена из за наличия мягких контролей(данные СП будут в запросе FORCE)\n");
            }
        }
    }

    public static boolean checkAvailableSignatureToolOTP() throws IOException {
        boolean result = true;
        if (AuthCryptoprofCode.rootTag.getListS() != null) {
            for (int i = 0; i < AuthCryptoprofCode.rootTag.getListS().size(); i++) {
                if (AuthCryptoprofCode.rootTag.getListS().get(i).getT().equals("1")) {
                    log.info("Проверка на наличие хотя бы одного СП OTP для операции подписи - PASS\n");
                    quantityPASS++;
                    break;
                } else {
                    log.error("Проверка на наличие хотя бы одного СП OTP - FAILED" +
                            "Тестирование будет прервано");
                    quantityFAILED++;
                    result = false;
                }
            }
        } else {
            result = false;
            log.error("Проверка на наличие хотя бы одного СП OTP - FAILED" +
                    "Тестирование будет прервано");
            quantityFAILED++;
        }
        return result;
    }

}


