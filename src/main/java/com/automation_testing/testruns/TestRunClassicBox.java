package com.automation_testing.testruns;

import com.automation_testing.allrequests.authorization.*;
import com.automation_testing.allrequests.connect.*;
import com.automation_testing.allrequests.managedevice.*;
import com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req.AvailableDocument;
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
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocCHECKCODE;
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
    final ManagePushBind MANAGEPUSHBIND = new ManagePushBind();
    final Style40 STYLE40 = new Style40();
    final VersionInfo VERSIONINFO = new VersionInfo();
    final AuthLogin AUTHLOGIN = new AuthLogin();
    final AuthMacIp AUTHMACIP = new AuthMacIp();
    final AuthCryptoprofCode AUTH_CRYPTO_PROFILES_CODE = new AuthCryptoprofCode();
    final SmsAuthCode smsAuthCode = new SmsAuthCode();
    final SendAuthCode sendAuthCode = new SendAuthCode();
    final AuthAccess authAccess = new AuthAccess();
    final BindManageDevice bindManageDevice = new BindManageDevice();
    final UnBindManageDevice unBindManageDevice = new UnBindManageDevice();
    final MenuItem menuItem = new MenuItem();
    final PushManagePushUserBind pushManagePushUserBind = new PushManagePushUserBind();
    final UserFilter userFilter = new UserFilter();
    final Banner banner = new Banner();
    final NotificationMandatoryCount notificationMandatoryCount = new NotificationMandatoryCount();
    final UserAccount userAccount = new UserAccount();
    final StatementDocsByDay statementDocsByDay = new StatementDocsByDay();
    final CountAllDocsDocPayOrd countAllDocsDocumentPaymentOrder = new CountAllDocsDocPayOrd();
    final GetDictRemoteCorrespDictionary getDicRemoteCorresp = new GetDictRemoteCorrespDictionary();
    final GetDictPaySendType getDictPaySendType = new GetDictPaySendType();
    final GetDictNDSCalType getDictNDSCalType = new GetDictNDSCalType();
    final GetDictCustomerKPP getDictCustomerKPP = new GetDictCustomerKPP();
    final GetDictSalaryAcc getDictSalaryAcc = new GetDictSalaryAcc();
    final TooltipPaymentOrder tooltipPaymentOrder = new TooltipPaymentOrder();
    final GetFilterPartBankRu getFilterPartBankRu = new GetFilterPartBankRu();
    final GetFullBankRuKon getFullBankRuKon = new GetFullBankRuKon();
    final GetDictStat1256 getDictStat1256 = new GetDictStat1256();
    final GetDictPayGrndParam getDictPayGrndParam = new GetDictPayGrndParam();
    final GetDictMessageType getDictMessageType = new GetDictMessageType();
    final GetFilterPartCBCCodes getFilterPartCBCCodes = new GetFilterPartCBCCodes();
    final GetFullBankRuBud getFullBankRuBud = new GetFullBankRuBud();
    final CountAllAllDocsDoc countAllMyDocs = new CountAllAllDocsDoc();
    final HeadersAllDocsDoc headersAllDocsOfMyDocs = new HeadersAllDocsDoc();
    final HeadersByDayPayOrd headersByDayPayOrd = new HeadersByDayPayOrd();
    public static PutDocAction putDoc;
    public static DocumentNumber docNumber;
    public static AvailableDocument availableDocument;

    public TestRunClassicBox() {
    }

    public void run() {
        //порядов запросов
        Map<String, Post> requestMap = new LinkedHashMap<>();
        //блок connect
        requestMap.put("Bank", BANK);
        requestMap.put("Localization", LOCALIZATION);
        requestMap.put("ManagePushBind", MANAGEPUSHBIND);
        requestMap.put("Style40", STYLE40);
        requestMap.put("VersionInfo", VERSIONINFO);
        //блок authorization
        requestMap.put("AuthLogin", AUTHLOGIN);
        requestMap.put("AuthMacIp", AUTHMACIP);
        requestMap.put("AuthCryptoprofCode", AUTH_CRYPTO_PROFILES_CODE);
        requestMap.put("SmsAuthCode", smsAuthCode);
        requestMap.put("SendAuthCode", sendAuthCode);
        requestMap.put("AuthAccess", authAccess);
        requestMap.put("MenuItem", menuItem);
        requestMap.put("PushManagePushUserBind", pushManagePushUserBind);
        requestMap.put("UserFilter", userFilter);
        requestMap.put("Banner", banner);
        requestMap.put("NotificationMandatoryCount", notificationMandatoryCount);
        requestMap.put("UserAccount", userAccount);
        requestMap.put("StatementDocsByDay", statementDocsByDay);
        requestMap.put("CountAllDocsDocPayOrd", countAllDocsDocumentPaymentOrder);
        //справочники
        requestMap.put("GetDictRemoteCorrespDictionary", getDicRemoteCorresp);
        requestMap.put("GetDictPaySendType", getDictPaySendType);
        requestMap.put("GetDictNDSCalType", getDictNDSCalType);
        requestMap.put("GetDictCustomerKPP", getDictCustomerKPP);
        requestMap.put("TooltipPaymentOrder", getDictSalaryAcc);
        requestMap.put("GetDictSalaryAcc", tooltipPaymentOrder);
        requestMap.put("GetFilterPartBankRu", getFilterPartBankRu);
        requestMap.put("GetDictStat1256", getDictStat1256);
        requestMap.put("GetDictPayGrndParam", getDictPayGrndParam);
        requestMap.put("GetDictMessageType", getDictMessageType);
        requestMap.put("GetFilterPartCBCCodes", getFilterPartCBCCodes);
        //запрос необходимый для блока запросов контрагенту
        requestMap.put("GetFullBankRuKon", getFullBankRuKon);
        //запрос необходимый для блока запросов в бюджет
        requestMap.put("GetFullBankRuBud", getFullBankRuBud);
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
        requestMap.put("CountAllAllDocsDoc", countAllMyDocs);
        requestMap.put("HeadersAllDocsDocOfMyDocs", headersAllDocsOfMyDocs);
        // создание запроса на отзыв ПП
        requestMap.put("DocNumCanReq", docNumber);
        requestMap.put("HeadersByDayPayOrd", headersByDayPayOrd);
        /*requestMap.put("AvailableDocumentPayOrd", availableDocument);*/

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
                    case "SmsAuthCode" -> {
                        if (Check.checkAvailableSignatureToolOTP()) {
                            smsAuthCode.run();
                        } else {
                            return;
                        }
                    }
                    case "AuthAccess" -> {
                        authAccess.run();
                        if (!(AuthAccess.rootTag.getListS().get(0).getZ().equals("2") | AuthAccess.rootTag.getListS().get(0).getZ().equals("0"))) {
                            unBindManageDevice.run();
                        } else {
                            bindManageDevice.run();
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
                    case "AvailableDocumentPayOrd" -> (availableDocument = new AvailableDocument("PaymentOrder", PutDocCHECKCODE.listDocBankID.get(0))).run();
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