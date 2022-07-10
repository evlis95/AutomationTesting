package com.automation_testing.testruns;

import com.automation_testing.allrequests.authorization.*;
import com.automation_testing.allrequests.managedevice.BindManageDevice;
import com.automation_testing.allrequests.managedevice.UnBindManageDevice;
import com.automation_testing.allrequests.connect.*;
import com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req.*;
import com.automation_testing.allrequests.work_in_authorized_mode.create_letter.Letter;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.*;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.*;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.allrequests.work_in_authorized_mode.letters.*;
import com.automation_testing.allrequests.work_in_authorized_mode.mydocs.*;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.*;
import com.automation_testing.allrequests.work_in_authorized_mode.template.*;
import com.automation_testing.checks.Check;
import com.automation_testing.interfaces.Launchable;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestRunClassicBox {

    private final static Logger LOG = LogManager.getLogger(TestRunClassicBox.class);
    private static GetTemplate getTemplate;
    private static AvailableDocument availableDocument;
    private static PutDocAction putDoc;
    private static DocumentNumber docNumber;
    private final Bank BANK = new Bank();
    private final Localization LOCALIZATION = new Localization();
    private final ManagePushBind MANAGE_PUSH_BIND = new ManagePushBind();
    private final Style40 STYLE40 = new Style40();
    private final VersionInfo VERSION_INFO = new VersionInfo();
    private final AuthLogin AUTH_LOGIN = new AuthLogin();
    private final AuthMacIp AUTH_MAC_IP = new AuthMacIp();
    private final AuthCryptoprofCode AUTH_CRYPTO_PROFILES_CODE = new AuthCryptoprofCode();
    private final SmsAuthCode SMS_AUTH_CODE = new SmsAuthCode();
    private final SendAuthCode SEND_AUTH_CODE = new SendAuthCode();
    private final AuthAccess AUTH_ACCESS = new AuthAccess();
    private final BindManageDevice BIND_MANAGE_DEVICE = new BindManageDevice();
    private final UnBindManageDevice UNBIND_MANAGE_DEVICE = new UnBindManageDevice();
    private final MenuItem MENU_ITEM = new MenuItem();
    private final PushManagePushUserBind PUSH_MANAGE_PUSH_USER_BIND = new PushManagePushUserBind();
    private final UserFilter USER_FILTER = new UserFilter();
    private final Banner BANNER = new Banner();
    private final NotificationMandatoryCount NOTIFICATION_MANDATORY_COUNT = new NotificationMandatoryCount();
    private final UserAccount USER_ACCOUNT = new UserAccount();
    private final StatementDocsByDay STATEMENT_DOCS_BY_DAY = new StatementDocsByDay();
    private final CountAllDocsDocPayOrd COUNT_ALL_DOCS_DOCUMENT_PAYMENT_ORDER = new CountAllDocsDocPayOrd();
    private final GetDictRemoteCorrespDictionary GET_DICT_REMOTE_CORR = new GetDictRemoteCorrespDictionary();
    private final GetDictPaySendType GET_DICT_PAY_SEND_TYPE = new GetDictPaySendType();
    private final GetDictNDSCalType GET_DICT_NDS_CAL_TYPE = new GetDictNDSCalType();
    private final GetDictCustomerKPP GET_DICT_CUSTOMER_KPP = new GetDictCustomerKPP();
    private final GetDictSalaryAcc GET_DICT_SALARY_ACC = new GetDictSalaryAcc();
    private final TooltipPaymentOrder TOOLTIP_PAYMENT_ORDER = new TooltipPaymentOrder();
    private final GetFilterPartBankRu GET_FILTER_PART_BANK_RU = new GetFilterPartBankRu();
    private final GetFullBankRu GET_FULL_BANK_RU = new GetFullBankRu();
    private final GetDictStat1256 GET_DICT_STAT_1256 = new GetDictStat1256();
    private final GetDictPayGrndParam GET_DICT_PAY_GRND_PARAM = new GetDictPayGrndParam();
    private final GetDictMessageType GET_DICT_MESSAGE_TYPE = new GetDictMessageType();
    private final GetFilterPartCBCCodes GET_FILTER_PART_CBC_CODES = new GetFilterPartCBCCodes();
    private final CountAllAllDocsDoc COUNT_ALL_MY_DOCS = new CountAllAllDocsDoc();
    private final HeadersAllDocsDoc HEADERS_ALL_DOCS_OF_MY_DOCS = new HeadersAllDocsDoc();
    private final HeadersByDayPayOrd HEADERS_BY_DAY_PAY_ORD = new HeadersByDayPayOrd();
    private final TemplateHeadersPayOrd TEMPLATE_HEADERS_PAY_ORD = new TemplateHeadersPayOrd();
    private final HeadersFreeDocFromBank HEADERS_FREE_DOC_FROM_BANK = new HeadersFreeDocFromBank();
    private final HeadersFreeDocToBank HEADERS_FREE_DOC_TO_BANK = new HeadersFreeDocToBank();

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
        //запрос необходимый для блока запросов контрагенту и в бюджет
        requestMap.put("GetFullBankRu", GET_FULL_BANK_RU);
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
        requestMap.put("HeadersByDayPayOrd", HEADERS_BY_DAY_PAY_ORD);
        requestMap.put("AvailableDocument", availableDocument);
        requestMap.put("DocNumCanReq", docNumber);
        requestMap.put("PutCancellationRequestSignGo", putDoc);
        // справочник шаблонов платежей и запрос на получение созданного шаблона(указанного в ПП Контрагенту(поле TemplateName))
        requestMap.put("TemplateHeadersPaymentOrder", TEMPLATE_HEADERS_PAY_ORD);
        requestMap.put("GetTemplate", getTemplate);
        // письма
        requestMap.put("HeadersFreeDocFromBank", HEADERS_FREE_DOC_FROM_BANK);
        requestMap.put("HeadersFreeDocToBank", HEADERS_FREE_DOC_TO_BANK);
        requestMap.put("DocNumFreeDocToBankSave", docNumber);
        requestMap.put("PutFreeDocToBankSave", putDoc);
        requestMap.put("DocNumFreeDocToBankSignGo", docNumber);
        requestMap.put("PutFreeDocToBankSignGo", putDoc);

        LOG.info("Teстирование выполняется\n");
        try {
            for (Entry map : requestMap.entrySet())
                switch (map.getKey().toString()) {

                    case "DocNumPaymOrderKonSave",
                            "DocNumPaymOrderKonSign",
                            "DocNumPaymOrderKonSignGo",
                            "DocNumPaymOrderBudSave",
                            "DocNumPaymOrderBudSign",
                            "DocNumPaymOrderBudSignGo" -> new DocumentNumber("PaymentOrder").run();

                    case "DocNumCanReq" -> (docNumber = new DocumentNumber("CancellationRequest")).run();

                    case "DocNumPaymOrderYSSAve",
                            "DocNumPaymOrderYSSign",
                            "DocNumPaymOrderYSSignGo" -> {
                        if (Check.checkCountAvailableAccounts810()) {
                            LOG.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Запрос нового документа не будет произведен.
                                    """);
                        } else {
                            new DocumentNumber("PaymentOrder").run();
                        }
                    }

                    case "UserFilter" -> {
                        USER_FILTER.run();
                        if (!Check.checkEnabledD2BMAdvancedService()) {
                            return;
                        }
                    }
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

                    case "HeadersByDayPayOrd" -> {
                        Check.definitionOfConnServCanReq();
                        HEADERS_BY_DAY_PAY_ORD.run();
                    }

                    case "AvailableDocument" -> (availableDocument = new AvailableDocument("PaymentOrder", Check.definingPayOrdIDForCancellReq())).run();

                    case "PutCancellationRequestSignGo" -> (putDoc = new PutDocAction(DocumentAction.SIGN_GO, new CancellationRequest().initialCalReqFields(), DocumentType.CANCELLATION_REQUEST)).run();

                    case "GetTemplate" -> (getTemplate = new GetTemplate(TemplateHeadersPayOrd.templateID)).run();

                    case "DocNumFreeDocToBankSave" -> (docNumber = new DocumentNumber("FreeDocToBank")).run();

                    case "PutFreeDocToBankSave" -> (putDoc = new PutDocAction(DocumentAction.SAVE, new Letter().creatingLetterFields(), DocumentType.FREE_DOC_TO_BANK)).run();

                    case "PutFreeDocToBankSignGo" -> (putDoc = new PutDocAction(DocumentAction.SIGN_GO, new Letter().creatingLetterFields(), DocumentType.FREE_DOC_TO_BANK)).run();

                    case "DocNumFreeDocToBankSignGo" -> (docNumber = new DocumentNumber("FreeDocToBank")).run();
                    ////////////////////////////////////////////////////////////////////////////////////
                    default -> {
                        Launchable request = (Launchable) map.getValue();
                        request.run();
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