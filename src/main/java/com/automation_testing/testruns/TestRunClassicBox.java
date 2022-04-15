package com.autotest.testruns;

import com.autotest.allrequests.authorization.*;
import com.autotest.allrequests.connect.*;
import com.autotest.allrequests.managedevice.*;
import com.autotest.allrequests.work_in_authorized_mode.create_cancell_req.HeadersByDayPayOrd;
import com.autotest.allrequests.work_in_authorized_mode.create_pay_ord.*;
import com.autotest.allrequests.work_in_authorized_mode.dictionary.GetDictRemoteCorrespDictionary;
import com.autotest.allrequests.work_in_authorized_mode.dictionary.*;
import com.autotest.allrequests.work_in_authorized_mode.docnumber.DocNumPaymOrder;
import com.autotest.allrequests.work_in_authorized_mode.mydocs.CountAllAllDocsDoc;
import com.autotest.allrequests.work_in_authorized_mode.mydocs.HeadersAllDocsDoc;
import com.autotest.checks.Check;
import com.autotest.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TestRunClassicBox {

    final static Logger log = LogManager.getLogger(TestRunClassicBox.class);

    final Bank bank = new Bank();
    final Localization localization = new Localization();
    final ManagePushBind managePushBind = new ManagePushBind();
    final Style40 style40 = new Style40();
    final VersionInfo versionInfo = new VersionInfo();
    final AuthLogin authLogin = new AuthLogin();
    final AuthMacIp authMacIp = new AuthMacIp();
    final AuthCryptoprofCode authCryptoprofilesCode = new AuthCryptoprofCode();
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
    public static PutPayOrdDoc payOrdDoc;
    public static DocNumPaymOrder docNumPayOrd;

    public TestRunClassicBox() {
    }

    public void run() {
        //порядов запросов
        Map<String, Post> requestMap = new LinkedHashMap<>();
        //блок connect
        requestMap.put("Bank", bank);
        requestMap.put("Localization", localization);
        requestMap.put("ManagePushBind", managePushBind);
        requestMap.put("Style40", style40);
        requestMap.put("VersionInfo", versionInfo);
        //блок authorization
        requestMap.put("AuthLogin", authLogin);
        requestMap.put("AuthMacIp", authMacIp);
        requestMap.put("AuthCryptoprofCode", authCryptoprofilesCode);
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
        requestMap.put("DocNumPaymOrderKonSave", docNumPayOrd);
        requestMap.put("PutPaymentOrderDocKonSave", payOrdDoc);
        //блок подписи документа контрагенту
        requestMap.put("DocNumPaymOrderKonSign", docNumPayOrd);
        requestMap.put("PutPaymentOrderDocKonSign", payOrdDoc);
        //блок подписи и отправки документа контрагенту
        requestMap.put("DocNumPaymOrderKonSignGo", docNumPayOrd);
        requestMap.put("PutPaymentOrderDocKonSignGo", payOrdDoc);
        //блок сохранение документа в бюджет
        requestMap.put("DocNumPaymOrderBudSave", docNumPayOrd);
        requestMap.put("PutPaymentOrderDocBudSave", payOrdDoc);
        //блок подписи документа в бюджет
        requestMap.put("DocNumPaymOrderBudSign", docNumPayOrd);
        requestMap.put("PutPaymentOrderDocBudSign", payOrdDoc);
        //блок подписи и отправки документа в бюджет
        requestMap.put("DocNumPaymOrderBudSignGo", docNumPayOrd);
        requestMap.put("PutPaymentOrderDocBudSignGo", payOrdDoc);
        //блок сохранение документа себе
        requestMap.put("DocNumPaymOrderYSSAve", docNumPayOrd);
        requestMap.put("PutPaymentOrderDoсYSSave", payOrdDoc);
        //блок подписи документа себе
        requestMap.put("DocNumPaymOrderYSSign", docNumPayOrd);
        requestMap.put("PutPaymentOrderDoсYSSign", payOrdDoc);
        //блок подписи и отправки документа себе
        requestMap.put("DocNumPaymOrderYSSignGo", docNumPayOrd);
        requestMap.put("PutPaymentOrderDoсYSSignGo", payOrdDoc);
        // мои документы
        requestMap.put("CountAllAllDocsDoc", countAllMyDocs);
        requestMap.put("HeadersAllDocsDocOfMyDocs", headersAllDocsOfMyDocs);
        // создание запроса на отзыв
        requestMap.put("DocNumCanReq", docNumPayOrd);
        requestMap.put("HeadersByDayPayOrd", headersByDayPayOrd);

        log.info("Teстирование выполняется\n");
        try {
            for (Entry map : requestMap.entrySet())
                switch (map.getKey().toString()) {
                    case "DocNumPaymOrderKonSave":
                    case "DocNumPaymOrderKonSign":
                    case "DocNumPaymOrderKonSignGo":
                    case "DocNumPaymOrderBudSave":
                    case "DocNumPaymOrderBudSign":
                    case "DocNumPaymOrderBudSignGo":
                    case "DocNumCanReq":
                        docNumPayOrd = new DocNumPaymOrder();
                        docNumPayOrd.run();
                        break;

                    case "DocNumPaymOrderYSSAve":
                    case "DocNumPaymOrderYSSign":
                    case "DocNumPaymOrderYSSignGo":
                        if (!Check.checkCountAvailableAccounts810()) {
                            log.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Запрос нового документа не будет произведен.
                                    """);
                        } else {
                            docNumPayOrd = new DocNumPaymOrder();
                            docNumPayOrd.run();
                        }
                        break;

                    case "UserFilter":
                        userFilter.run();
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
                            log.error("Проверка на подключение услуги D2BM. Advanced, хотя бы в одном подразделении - FAILED. Тестирование будет заверщено.\n");
                            Check.quantityFAILED++;
                            return;
                        }
                        break;
                    case "SmsAuthCode":
                        if (Check.checkAvailableSignatureToolOTPAuthoriz()) {
                            smsAuthCode.run();
                        } else {
                            return;
                        }
                        break;
                    case "AuthAccess":
                        authAccess.run();
                        if (!(AuthAccess.rootTag.getListS().get(0).getZ().equals("2") | AuthAccess.rootTag.getListS().get(0).getZ().equals("0"))) {
                            unBindManageDevice.run();
                        } else {
                            bindManageDevice.run();
                        }
                        if (!BindManageDevice.resultBinding) {
                            return;
                        }
                        break;
                    case "PutPaymentOrderDocKonSave":
                        payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SAVE, PaymentOrderTarget.PAYMENT_TO_COUNTERPARTY, "ПП Контрагенту успешно создано", "3");
                        payOrdDoc.run();
                        break;
                    case "PutPaymentOrderDocKonSign":
                        payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SIGN, PaymentOrderTarget.PAYMENT_TO_COUNTERPARTY, "ПП Контрагенту успешно подписано", "6");
                        payOrdDoc.run();
                        break;
                    case "PutPaymentOrderDocKonSignGo":
                        payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SIGN_GO, PaymentOrderTarget.PAYMENT_TO_COUNTERPARTY, "ПП Контрагенту успешно подписано и отправлено", "43");
                        payOrdDoc.run();
                        break;
                    case "PutPaymentOrderDocBudSave":
                        payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SAVE, PaymentOrderTarget.PAYMENT_TO_BUDGET, "ПП В бюджет успешно создано", "3");
                        payOrdDoc.run();
                        break;
                    case "PutPaymentOrderDocBudSign":
                        payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SIGN, PaymentOrderTarget.PAYMENT_TO_BUDGET, "ПП В бюджет успешно подписано", "6");
                        payOrdDoc.run();
                        break;
                    case "PutPaymentOrderDocBudSignGo":
                        payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SIGN_GO, PaymentOrderTarget.PAYMENT_TO_BUDGET, "ПП В бюджет успешно подписано и отправлено", "43");
                        payOrdDoc.run();
                        break;
                    case "PutPaymentOrderDoсYSSave":
                        if (!Check.checkCountAvailableAccounts810()) {
                            log.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Платеж себе не будет создан.
                                    """);
                        } else {
                            payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SAVE, PaymentOrderTarget.PAYMENT_TO_YOURSELF, "ПП Себе успешно создано", "3");
                            payOrdDoc.run();
                        }
                        break;
                    case "PutPaymentOrderDoсYSSign":
                        if (!Check.checkCountAvailableAccounts810()) {
                            log.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Платеж себе не будет создан и подписан.
                                    """);
                        } else {
                            payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SIGN, PaymentOrderTarget.PAYMENT_TO_YOURSELF, "ПП Себе успешно подписано", "6");
                            payOrdDoc.run();
                        }
                        break;
                    case "PutPaymentOrderDoсYSSignGo":
                        if (!Check.checkCountAvailableAccounts810()) {
                            log.warn("""
                                    У пользователя нет 2 доступного счета в рублях, чтобы осуществить платеж Себе.
                                    Платеж себе не будет создан и подписан и отправлен.
                                    """);
                        } else {
                            payOrdDoc = new PutPayOrdDoc(PaymentOrderAction.SIGN_GO, PaymentOrderTarget.PAYMENT_TO_YOURSELF, "ПП Себе успешно подписано и отправлено", "43");
                            payOrdDoc.run();
                        }
                        break;
                    ////////////////////////////////////////////////////////////////////////////////////
                    default:
                        Post post = (Post) map.getValue();
                        post.run();
                        break;
                }
            log.info("Тестирование завершено");
            log.info("Количество успешных тестов - " + Check.quantityPASS + ". Количество проваленных - " + Check.quantityFAILED + ".");
        } catch (IOException | JAXBException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}