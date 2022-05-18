package com.automation_testing.testruns;

import com.automation_testing.allrequests.authorization.*;
import com.automation_testing.allrequests.connect.Bank;
import com.automation_testing.allrequests.connect.Style40;
import com.automation_testing.allrequests.connect.VersionInfo;
import com.automation_testing.allrequests.managedevice.BindManageDevice;
import com.automation_testing.allrequests.managedevice.UnBindManageDevice;
import com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req.AvailableDocument;
import com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req.HeadersByDayPayOrd;
import com.automation_testing.allrequests.work_in_authorized_mode.creating_keysandvalues_fields_map.Letter;
import com.automation_testing.allrequests.work_in_authorized_mode.creating_keysandvalues_fields_map.PaymentOrder;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.PaymentOrderTarget;
import com.automation_testing.allrequests.work_in_authorized_mode.creating_keysandvalues_fields_map.SBP;
import com.automation_testing.allrequests.work_in_authorized_mode.dictionary.*;
import com.automation_testing.allrequests.work_in_authorized_mode.docnumber.DocumentNumber;
import com.automation_testing.allrequests.work_in_authorized_mode.letters.HeadersFreeDocFromBank;
import com.automation_testing.allrequests.work_in_authorized_mode.letters.HeadersFreeDocToBank;
import com.automation_testing.allrequests.work_in_authorized_mode.mydocs.CountAllAllDocsDoc;
import com.automation_testing.allrequests.work_in_authorized_mode.mydocs.HeadersAllDocsDoc;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.DocumentAction;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.DocumentType;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.allrequests.work_in_authorized_mode.sbp.CountAllDocsSBP;
import com.automation_testing.allrequests.work_in_authorized_mode.sbp.SBPHeadersByDay;
import com.automation_testing.allrequests.work_in_authorized_mode.template.GetTemplate;
import com.automation_testing.allrequests.work_in_authorized_mode.template.TemplateHeadersPayOrd;
import com.automation_testing.checks.Check;
import com.automation_testing.interfaces.Runnable;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestRunClassicBox {

    final static Logger LOG = LogManager.getLogger(TestRunClassicBox.class);
    public static GetTemplate getTemplate;
    public static AvailableDocument availableDocument;
    public static PutDocAction putDoc;
    public static DocumentNumber docNumber;
    final Bank BANK = new Bank();
    final Style40 STYLE40 = new Style40();
    final VersionInfo VERSION_INFO = new VersionInfo();
    final AuthLogin AUTH_LOGIN = new AuthLogin();
    final AuthMacIp AUTH_MAC_IP = new AuthMacIp();
    final AuthCryptoprofCode AUTH_CRYPTO_PROFILES_CODE = new AuthCryptoprofCode();
    final SmsAuthCode SMS_AUTH_CODE = new SmsAuthCode();
    final SendAuthCode SEND_AUTH_CODE = new SendAuthCode();
    final AuthAccess AUTH_ACCESS = new AuthAccess();
    final AuthRoles AUTH_ROLES = new AuthRoles();
    final BindManageDevice BIND_MANAGE_DEVICE = new BindManageDevice();
    final UnBindManageDevice UNBIND_MANAGE_DEVICE = new UnBindManageDevice();
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
    final GetFilterPartBankRu GET_FILTER_PART_BANK_RU = new GetFilterPartBankRu();
    final GetFullBankRu GET_FULL_BANK_RU = new GetFullBankRu();
    final GetDictStat1256 GET_DICT_STAT_1256 = new GetDictStat1256();
    final GetDictPayGrndParam GET_DICT_PAY_GRND_PARAM = new GetDictPayGrndParam();
    final GetDictMessageType GET_DICT_MESSAGE_TYPE = new GetDictMessageType();
    final GetFilterPartCBCCodes GET_FILTER_PART_CBC_CODES = new GetFilterPartCBCCodes();
    final CountAllAllDocsDoc COUNT_ALL_MY_DOCS = new CountAllAllDocsDoc();
    final HeadersAllDocsDoc HEADERS_ALL_DOCS_OF_MY_DOCS = new HeadersAllDocsDoc();
    final HeadersByDayPayOrd HEADERS_BY_DAY_PAY_ORD = new HeadersByDayPayOrd();
    final TemplateHeadersPayOrd TEMPLATE_HEADERS_PAY_ORD = new TemplateHeadersPayOrd();
    final GetDictTSP GET_DICT_TSP = new GetDictTSP();
    final CountAllDocsSBP COUNT_ALL_DOCS_SBP = new CountAllDocsSBP();
    final SBPHeadersByDay SBP_HEADERS_BY_DAY = new SBPHeadersByDay();
    final GetDictBanksSBP GET_DICT_BANKS_SBP = new GetDictBanksSBP();
    final GetDictIncomeType GET_DICT_INCOME_TYPE = new GetDictIncomeType();
    final HeadersFreeDocFromBank HEADERS_FREE_DOC_FROM_BANK = new HeadersFreeDocFromBank();
    final HeadersFreeDocToBank HEADERS_FREE_DOC_TO_BANK = new HeadersFreeDocToBank();

    public TestRunClassicBox() {
    }

    public void run() {
        //порядов запросов
        Map<String, Post> requestMap = new LinkedHashMap<>();
        //блок connect
        requestMap.put("VersionInfo", VERSION_INFO);
        requestMap.put("Style40", STYLE40);
        requestMap.put("Bank", BANK);
        //блок authorization
        requestMap.put("AuthLogin", AUTH_LOGIN);
        requestMap.put("AuthMacIp", AUTH_MAC_IP);
        requestMap.put("AuthCryptoprofCode", AUTH_CRYPTO_PROFILES_CODE);
        requestMap.put("SmsAuthCode", SMS_AUTH_CODE);
        requestMap.put("SendAuthCode", SEND_AUTH_CODE);
        requestMap.put("AuthAccess", AUTH_ACCESS);
        requestMap.put("Banner", BANNER);
        requestMap.put("AuthRoles", AUTH_ROLES);
        requestMap.put("UserFilter", USER_FILTER);
        requestMap.put("NotificationMandatoryCount", NOTIFICATION_MANDATORY_COUNT);
        requestMap.put("UserAccount", USER_ACCOUNT);
        requestMap.put("StatementDocsByDay", STATEMENT_DOCS_BY_DAY);
        requestMap.put("CountAllDocsDocPayOrd", COUNT_ALL_DOCS_DOCUMENT_PAYMENT_ORDER);
        //справочники
        requestMap.put("GetDictRemoteCorrespDictionary", GET_DICT_REMOTE_CORR);
        requestMap.put("GetDictPaySendType", GET_DICT_PAY_SEND_TYPE);
        requestMap.put("GetDictNDSCalType", GET_DICT_NDS_CAL_TYPE);
        requestMap.put("GetDictCustomerKPP", GET_DICT_CUSTOMER_KPP);
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
        //блок сохранение документа в бюджет
        requestMap.put("DocNumPaymOrderBudSave", docNumber);
        requestMap.put("PutPaymentOrderDocBudSave", putDoc);
        //блок сохранение документа себе
        requestMap.put("DocNumPaymOrderYSSAve", docNumber);
        requestMap.put("PutPaymentOrderDoсYSSave", putDoc);
        // мои документы
        requestMap.put("CountAllAllDocsDoc", COUNT_ALL_MY_DOCS);
        requestMap.put("HeadersAllDocsDocOfMyDocs", HEADERS_ALL_DOCS_OF_MY_DOCS);
        // создание запроса на отзыв
        requestMap.put("HeadersByDayPayOrd", HEADERS_BY_DAY_PAY_ORD);
        requestMap.put("AvailableDocument", availableDocument);
        requestMap.put("DocNumCanReq", docNumber);
        // справочник шаблонов платежей и запрос на получение созданного шаблона(указанного в ПП Контрагенту(поле TemplateName))
        requestMap.put("TemplateHeadersPaymentOrder", TEMPLATE_HEADERS_PAY_ORD);
        requestMap.put("GetTemplate", getTemplate);
        // сбп
        requestMap.put("GetDictTSP", GET_DICT_TSP);
        requestMap.put("CountAllDocsSBP", COUNT_ALL_DOCS_SBP);
        requestMap.put("SBPHeadersByDay", SBP_HEADERS_BY_DAY);
        requestMap.put("DocNumSystemFastPay", docNumber);
        requestMap.put("GetDictBanksSBP", GET_DICT_BANKS_SBP);
        requestMap.put("GetDictIncomeType", GET_DICT_INCOME_TYPE);
        requestMap.put("PutSBPDocSign", putDoc);
        // письма
        requestMap.put("HeadersFreeDocFromBank", HEADERS_FREE_DOC_FROM_BANK);
        requestMap.put("HeadersFreeDocToBank", HEADERS_FREE_DOC_TO_BANK);
        requestMap.put("DocNumFreeDocToBank", docNumber);
        requestMap.put("PutFreeDocToBankSave", putDoc);

        LOG.info("Teстирование выполняется\n");
        try {
            for (Entry map : requestMap.entrySet())
                switch (map.getKey().toString()) {

                    case "DocNumPaymOrderKonSave",
                            "DocNumPaymOrderBudSave" -> new DocumentNumber("PaymentOrder").run();

                    case "DocNumCanReq" -> new DocumentNumber("CancellationRequest").run();

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

                    case "PutPaymentOrderDocBudSave" -> new PutDocAction(DocumentAction.SAVE, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_BUDGET).creating(), DocumentType.PAYMENT_ORDER).run();


                    case "PutPaymentOrderDoсYSSave" -> {
                        if (Check.checkCountAvailableAccounts810()) {
                            LOG.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Платеж себе не будет создан.
                                    """);
                        } else {
                            if ("PutPaymentOrderDoсYSSave".equals(map.getKey().toString())) {
                                new PutDocAction(DocumentAction.SAVE, new PaymentOrder(PaymentOrderTarget.PAYMENT_TO_YOURSELF).creating(), DocumentType.PAYMENT_ORDER).run();
                            }
                        }
                    }

                    case "GetTemplate" -> (getTemplate = new GetTemplate(TemplateHeadersPayOrd.templateID)).run();

                    case "AvailableDocument" -> (availableDocument = new AvailableDocument("PaymentOrder", HeadersByDayPayOrd.docID)).run();

                    case "DocNumSystemFastPay" -> (docNumber = new DocumentNumber("SystemFastPay")).run();

                    case "PutSBPDocSign" -> (putDoc = new PutDocAction(DocumentAction.SIGN, new SBP().creatingDocSBP(), DocumentType.SYSTEM_FAST_PAY)).run();

                    case "DocNumFreeDocToBank" -> (docNumber = new DocumentNumber("FreeDocToBank")).run();

                    case "PutFreeDocToBankSave" -> (putDoc = new PutDocAction(DocumentAction.SAVE, new Letter().creatingLetterFields(), DocumentType.FREE_DOC_TO_BANK)).run();
                    ////////////////////////////////////////////////////////////////////////////////////
                    default -> {
                        Runnable request = (Runnable) map.getValue();
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