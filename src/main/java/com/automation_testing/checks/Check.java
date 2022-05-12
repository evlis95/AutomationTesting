package com.automation_testing.checks;

import com.automation_testing.allrequests.authorization.AuthCryptoprofCode;
import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.hibernate.pojo.MobileServices;
import com.automation_testing.hibernate.pojo.PaymentOrder;
import com.automation_testing.hibernate.service.MobileServicesService;
import com.automation_testing.hibernate.service.PaymentOrderService;
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

    public static boolean checkEnabledD2BMAdvancedService() {
        boolean result = false;
        for (int j = 0; j < UserFilter.rootTag.getListV().size(); j++) {
            if (UserFilter.rootTag.getListV().get(j).getAdv().equals("1")) {
                result = true;
                break;
            }
        }
        if (result) {
            LOG.info("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - PASS");
            Check.quantityPASS++;
        } else {
            LOG.error("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - FAILED. Тестирование будет заверщено.");
            Check.quantityFAILED++;
        }
        return result;
    }

    public static boolean checkCountAvailableAccounts810() {
        int accAvailable810 = 0;
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getT().equals("1") & UserAccount.rootTag.getListA().get(i).getV().equals("810"))
                accAvailable810++;
        }
        return accAvailable810 <= 1;
    }

    public static void checkCountAvailableSPForce(UniversalResponseRootTag rootTag) {

        if (PutDocAction.rootTag.getListC() != null) {
            if (PutDocAction.rootTag.getListC().get(0).getCe().equals("0")) {
                if (rootTag.getListK() != null) {
                    for (int i = 0; i < rootTag.getListK().size(); i++) {
                        if (rootTag.getListK().get(i).getT().equals("1")) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        LOG.info("Проверка на наличие хотя бы одного СП OTP для операции подписи - PASS");
                        quantityPASS++;
                    } else {
                        LOG.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED");
                        quantityFAILED++;
                    }
                } else {
                    quantityFAILED++;
                    LOG.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED");
                }
            }
        }
    }

    public static void checkCountAvailableSPSign(@NotNull UniversalResponseRootTag rootTag) {
        if (rootTag.getListK() == null & rootTag.getListC() == null) {
            LOG.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED");
            quantityFAILED++;

        } else if (rootTag.getListK() != null & rootTag.getListC() == null) {
            count = 0;
            for (int i = 0; i < rootTag.getListK().size(); i++) {
                if (rootTag.getListK().get(i).getT().equals("1")) {
                    count++;
                }
            }
            if (count > 0) {
                LOG.info("Проверка на наличие хотя бы одного СП OTP для операции подписи - PASS");
                quantityPASS++;
            } else {
                LOG.error("Проверка на наличие хотя бы одного СП OTP для операции подписи - FAILED");

                quantityFAILED++;
            }

        } else if (rootTag.getListK() == null & rootTag.getListC() != null) {
            if (rootTag.getListC().get(0).getCe().equals("1")) {
                LOG.warn("Проверка на наличие хотя бы одного СП OTP для операции подписи не проводится, из за наличия жестких контролей");
            } else {
                LOG.warn("Проверка на наличие хотя бы одного СП OTP для операции подписи не будет проведена из за наличия мягких контролей(данные СП будут в запросе FORCE)");
            }
        }
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

    public static void definitionOfConnServCanReq() {
        boolean result = false;
        MobileServicesService ms = new MobileServicesService();
        List<MobileServices> mobileServicesList = ms.findAllSerMob();
        for (int i = 0; i < mobileServicesList.size(); i++) {
            if (mobileServicesList.get(i).getAdv().equals("1") & mobileServicesList.get(i).getReq().equals("1")) {
                result = true;
            }
        }
        if (result) {
            LOG.info("Поиск хотя бы 1 подразделения c подключенными услугами D2BM.Adv + D2BM. Запрос на отзыв - PASS.");
            Check.quantityPASS++;
        } else {
            LOG.error("Поиск хотя бы 1 подразделения c подключенными услугами D2BM.Adv + D2BM. Запрос на отзыв - FAILED.");
            Check.quantityFAILED++;
        }

    }

    public static String definingPayOrdIDForCancellReq() {
        String result = null;
        PaymentOrderService pos = new PaymentOrderService();
        List<PaymentOrder> paymentOrderList = pos.findAllPaymentOrder();
        if (paymentOrderList != null) {
            for (int i = 0; i < paymentOrderList.size(); i++) {
                if (paymentOrderList.get(i).getAvailForCanReq().equals("1")) {
                    result = paymentOrderList.get(i).getDocBankID();
                }
            }
        }
        return result;
    }

}


