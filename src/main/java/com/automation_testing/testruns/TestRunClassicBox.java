package com.automation_testing.testruns;

import com.automation_testing.allrequests.authorization.*;
import com.automation_testing.allrequests.connect.*;
import com.automation_testing.allrequests.managedevice.*;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.DocumentAction;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.DocumentType;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req.HeadersByDayPayOrd;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.*;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.GetDictRemoteCorrespDictionary;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.*;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.allrequests.work_in_authorized_mode.mydocs.CountAllAllDocsDoc;
import com.automation_testing.allrequests.work_in_authorized_mode.mydocs.HeadersAllDocsDoc;
import com.automation_testing.checks.Check;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TestRunClassicBox {

    final static Logger LOG = LogManager.getLogger(TestRunClassicBox.class);

    final Bank BANK = new Bank();
    final Localization LOCALIZATION = new Localization();
    final ManagePushBind MANAGE_PUSH_BIND = new ManagePushBind();
    final Style40 STYLE40 = new Style40();
    final VersionInfo VERSION_INFO = new VersionInfo();
    final AuthLogin AUTH_LOGIN = new AuthLogin();
    final AuthMacIp AUTH_MAC_IP = new AuthMacIp();
    final AuthCryptoprofCode AUTH_CRYPTO_PROFILES_CODE = new AuthCryptoprofCode();
    final SmsAuthCode SMS_AUTH_CODE = new SmsAuthCode();
    final SendAuthCode SEND_AUTH_CODE = new SendAuthCode();
    final AuthAccess AUTH_ACCESS = new AuthAccess();
    final BindManageDevice BIND_MANAGE_DEVICE = new BindManageDevice();
    final UnBindManageDevice UNBIND_MANAGE_DEVICE = new UnBindManageDevice();
    final MenuItem MENU_ITEM = new MenuItem();
    final PushManagePushUserBind PUSH_MANAGE_PUSH_USER_BIND = new PushManagePushUserBind();
    final UserFilter USER_FILTER = new UserFilter();
    final Banner BANNER = new Banner();
    final NotificationMandatoryCount NOTIFICATION_MANDATORY_COUNT = new NotificationMandatoryCount();
    final UserAccount USER_ACCOUNT = new UserAccount();
    final StatementDocsByDay STATEMENT_DOCS_BY_DAY = new StatementDocsByDay();
    final CountAllDocsDocPayOrd COUNT_ALL_DOCS_DOCUMENT_PAYMENT_ORDER = new CountAllDocsDocPayOrd();
    final GetDictRemoteCorrespDictionary GET_DICT_REMOTE_CORR = new GetDictRemoteCorrespDictionary();
    final GetDictPaySendType GET_DICT_PAY_SEND_TYPE = new GetDictPaySendType();
    final GetDictNDSCalType GET_DICT_NDS_CAL_TYPE = new GetDictNDSCalType();
    final GetDictCustomerKPP GET_DICT_CUSTOMER_KPP = new GetDictCustomerKPP();
    final GetDictSalaryAcc GET_DICT_SALARY_ACC = new GetDictSalaryAcc();
    final TooltipPaymentOrder TOOLTIP_PAYMENT_ORDER = new TooltipPaymentOrder();
    final GetFilterPartBankRu GET_FILTER_PART_BANK_RU = new GetFilterPartBankRu();
    final GetFullBankRuKon GET_FULL_BANKRU_KON = new GetFullBankRuKon();
    final GetDictStat1256 GET_DICT_STAT_1256 = new GetDictStat1256();
    final GetDictPayGrndParam GET_DICT_PAY_GRND_PARAM = new GetDictPayGrndParam();
    final GetDictMessageType GET_DICT_MESSAGE_TYPE = new GetDictMessageType();
    final GetFilterPartCBCCodes GET_FILTER_PART_CBC_CODES = new GetFilterPartCBCCodes();
    final GetFullBankRuBud GET_FULL_BANKRU_BUD = new GetFullBankRuBud();
    final CountAllAllDocsDoc COUNT_ALL_MY_DOCS = new CountAllAllDocsDoc();
    final HeadersAllDocsDoc HEADERS_ALL_DOCS_OF_MY_DOCS = new HeadersAllDocsDoc();
    final HeadersByDayPayOrd HEADERS_BY_DAY_PAY_ORD = new HeadersByDayPayOrd();
    public static PutDocAction putDoc;
    public static DocumentNumber docNumber;

    public TestRunClassicBox() {
    }

    public void run() {
        //порядов запросов
        Map<String, Post> requestMap = new LinkedHashMap<>();
        //блок connect
        requestMap.put("Bank", BANK);
        requestMap.put("Localization", LOCALIZATION);
        requestMap.put("ManagePushBind", MANAGE_PUSH_BIND);
        requestMap.put("Style40", STYLE40);
        requestMap.put("VersionInfo", VERSION_INFO);
        //блок authorization
        requestMap.put("AuthLogin", AUTH_LOGIN);
        requestMap.put("AuthMacIp", AUTH_MAC_IP);
        requestMap.put("AuthCryptoprofCode", AUTH_CRYPTO_PROFILES_CODE);
        requestMap.put("SmsAuthCode", SMS_AUTH_CODE);
        requestMap.put("SendAuthCode", SEND_AUTH_CODE);
        requestMap.put("AuthAccess", AUTH_ACCESS);
        requestMap.put("MenuItem", MENU_ITEM);
        requestMap.put("PushManagePushUserBind", PUSH_MANAGE_PUSH_USER_BIND);
        requestMap.put("UserFilter", USER_FILTER);
        requestMap.put("Banner", BANNER);
        requestMap.put("NotificationMandatoryCount", NOTIFICATION_MANDATORY_COUNT);
        requestMap.put("UserAccount", USER_ACCOUNT);
        requestMap.put("StatementDocsByDay", STATEMENT_DOCS_BY_DAY);
        requestMap.put("CountAllDocsDocPayOrd", COUNT_ALL_DOCS_DOCUMENT_PAYMENT_ORDER);
        //справочники
        requestMap.put("GetDictRemoteCorrespDictionary", GET_DICT_REMOTE_CORR);
        requestMap.put("GetDictPaySendType", GET_DICT_PAY_SEND_TYPE);
        requestMap.put("GetDictNDSCalType", GET_DICT_NDS_CAL_TYPE);
        requestMap.put("GetDictCustomerKPP", GET_DICT_CUSTOMER_KPP);
        requestMap.put("TooltipPaymentOrder", GET_DICT_SALARY_ACC);
        requestMap.put("GetDictSalaryAcc", TOOLTIP_PAYMENT_ORDER);
        requestMap.put("GetFilterPartBankRu", GET_FILTER_PART_BANK_RU);
        requestMap.put("GetDictStat1256", GET_DICT_STAT_1256);
        requestMap.put("GetDictPayGrndParam", GET_DICT_PAY_GRND_PARAM);
        requestMap.put("GetDictMessageType", GET_DICT_MESSAGE_TYPE);
        requestMap.put("GetFilterPartCBCCodes", GET_FILTER_PART_CBC_CODES);
        //запрос необходимый для блока запросов контрагенту
        requestMap.put("GetFullBankRuKon", GET_FULL_BANKRU_KON);
        //запрос необходимый для блока запросов в бюджет
        requestMap.put("GetFullBankRuBud", GET_FULL_BANKRU_BUD);
        //блок сохранение документа контрагенту
        requestMap.put("DocNumPaymOrderKonSave", docNumber);
        requestMap.put("PutPaymentOrderDocKonSave", putDoc);
        //блок подписи документа контрагенту
        requestMap.put("DocNumPaymOrderKonSign", docNumber);
        requestMap.put("PutPaymentOrderDocKonSign", putDoc);
        //блок подписи и отправки документа контрагенту
        requestMap.put("DocNumPaymOrderKonSignGo", docNumber);
        requestMap.put("PutPaymentOrderDocKonSignGo", putDoc);
        //блок сохранение документа в бюджет
        requestMap.put("DocNumPaymOrderBudSave", docNumber);
        requestMap.put("PutPaymentOrderDocBudSave", putDoc);
        //блок подписи документа в бюджет
        requestMap.put("DocNumPaymOrderBudSign", docNumber);
        requestMap.put("PutPaymentOrderDocBudSign", putDoc);
        //блок подписи и отправки документа в бюджет
        requestMap.put("DocNumPaymOrderBudSignGo", docNumber);
        requestMap.put("PutPaymentOrderDocBudSignGo", putDoc);
        //блок сохранение документа себе
        requestMap.put("DocNumPaymOrderYSSAve", docNumber);
        requestMap.put("PutPaymentOrderDoсYSSave", putDoc);
        //блок подписи документа себе
        requestMap.put("DocNumPaymOrderYSSign", docNumber);
        requestMap.put("PutPaymentOrderDoсYSSign", putDoc);
        //блок подписи и отправки документа себе
        requestMap.put("DocNumPaymOrderYSSignGo", docNumber);
        requestMap.put("PutPaymentOrderDoсYSSignGo", putDoc);
        // мои документы
        requestMap.put("CountAllAllDocsDoc", COUNT_ALL_MY_DOCS);
        requestMap.put("HeadersAllDocsDocOfMyDocs", HEADERS_ALL_DOCS_OF_MY_DOCS);
        // создание запроса на отзыв
        requestMap.put("DocNumCanReq", docNumber);
        requestMap.put("HeadersByDayPayOrd", HEADERS_BY_DAY_PAY_ORD);

        LOG.info("Teстирование выполняется\n");
        try {
            for (Entry map : requestMap.entrySet())
                switch (map.getKey().toString()) {
                    case "DocNumPaymOrderKonSave",
                            "DocNumPaymOrderKonSign",
                            "DocNumPaymOrderKonSignGo",
                            "DocNumPaymOrderBudSave",
                            "DocNumPaymOrderBudSign",
                            "DocNumPaymOrderBudSignGo",
                            "DocNumCanReq" -> new DocumentNumber().run();

                    case "DocNumPaymOrderYSSAve",
                            "DocNumPaymOrderYSSign",
                            "DocNumPaymOrderYSSignGo" -> {
                        if (Check.checkCountAvailableAccounts810()) {
                            LOG.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Запрос нового документа не будет произведен.
                                    """);
                        } else {
                            new DocumentNumber().run();
                        }
                    }
                    case "UserFilter" -> USER_FILTER.run();
/*                        boolean result = false;  /// убрать проверку в класс Check
                        for (int j = 0; j < UserFilter.rootTag.getListV().size(); j++) {
                            if (UserFilter.rootTag.getListV().get(j).getAdv().equals("1")) {
                                result = true;
                                break;
                            }
                        }
                        if (result) {
                           LOG.info("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - PASS\n");
                            Check.quantityPASS++;
                        } else {
                           LOG.error("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - FAILED. Тестирование будет заверщено.\n");
                            Check.quantityFAILED++;
                            return;
                        }*/
                    case "SmsAuthCode" -> {
                        if (Check.checkAvailableSignatureToolOTP()) {
                            SMS_AUTH_CODE.run();
                        } else {
                            return;
                        }
                    }
                    case "AuthAccess" -> {
                        AUTH_ACCESS.run();
                        if (!(AuthAccess.rootTag.getListS().get(0).getZ().equals("2") | AuthAccess.rootTag.getListS().get(0).getZ().equals("0"))) {
                            UNBIND_MANAGE_DEVICE.run();
                        } else {
                            BIND_MANAGE_DEVICE.run();
                        }
                        if (!BindManageDevice.resultBinding) {
                            return;
                        }
                    }
                    case "PutPaymentOrderDocKonSave" -> new PutDocAction(DocumentAction.SAVE, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_COUNTERPARTY).creating(), DocumentType.PAYMENT_ORDER).run();

                    case "PutPaymentOrderDocKonSign" -> new PutDocAction(DocumentAction.SIGN, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_COUNTERPARTY).creating(), DocumentType.PAYMENT_ORDER).run();

                    case "PutPaymentOrderDocKonSignGo" -> new PutDocAction(DocumentAction.SIGN_GO, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_COUNTERPARTY).creating(), DocumentType.PAYMENT_ORDER).run();

                    case "PutPaymentOrderDocBudSave" -> new PutDocAction(DocumentAction.SAVE, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_BUDGET).creating(), DocumentType.PAYMENT_ORDER).run();

                    case "PutPaymentOrderDocBudSign" -> new PutDocAction(DocumentAction.SIGN, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_BUDGET).creating(), DocumentType.PAYMENT_ORDER).run();

                    case "PutPaymentOrderDocBudSignGo" -> new PutDocAction(DocumentAction.SIGN_GO, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_BUDGET).creating(), DocumentType.PAYMENT_ORDER).run();

                    case "PutPaymentOrderDoсYSSave",
                            "PutPaymentOrderDoсYSSign",
                            "PutPaymentOrderDoсYSSignGo" -> {
                        if (Check.checkCountAvailableAccounts810()) {
                            LOG.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Платеж себе не будет создан.
                                    """);
                        } else {
                            switch (map.getKey().toString()) {
                                case "PutPaymentOrderDoсYSSave" -> new PutDocAction(DocumentAction.SAVE, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_YOURSELF).creating(), DocumentType.PAYMENT_ORDER).run();

                                case "PutPaymentOrderDoсYSSign" -> new PutDocAction(DocumentAction.SIGN, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_YOURSELF).creating(), DocumentType.PAYMENT_ORDER).run();

                                case "PutPaymentOrderDoсYSSignGo" -> new PutDocAction(DocumentAction.SIGN_GO, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_YOURSELF).creating(), DocumentType.PAYMENT_ORDER).run();

                            }
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////////
                    default -> {
                        Post post = (Post) map.getValue();
                        post.run();
                    }
                }
            LOG.info("Тестирование завершено");
            LOG.info("Количество успешных тестов - " + Check.quantityPASS + ". Количество проваленных - " + Check.quantityFAILED + ".");
        } catch (IOException | JAXBException |
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}