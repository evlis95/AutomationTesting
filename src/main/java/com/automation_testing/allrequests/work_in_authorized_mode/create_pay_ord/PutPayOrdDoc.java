package com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.typ_fields_map_in_req.BudMap;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.typ_fields_map_in_req.KonMap;
import com.automation_testing.allrequests.work_in_authorized_mode.create_pay_ord.typ_fields_map_in_req.YSMap;
import com.automation_testing.allrequests.work_in_authorized_mode.getdoc.ReqToReceiveADoc;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import com.automation_testing.testruns.TestRunClassicBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PutPayOrdDoc extends Post {

    private Map<String, String> fieldsAndValues;
    public static UniversalResponseRootTag rootTag;
    private final static Logger log = LogManager.getLogger(PutPayOrdDoc.class);
    private final PaymentOrderTarget paymentOrderTarget;
    private final PaymentOrderAction paymentOrderAction;
    private String documentID;
    private String documentBankID;
    private final String nameSuccessfullyActForCheckRequest;
    private String docNumber;
    private String documentStatusCode;
    private final String statusCodeForCheckRequest;


    public PutPayOrdDoc(PaymentOrderAction paymentOrderAction, PaymentOrderTarget paymentOrderTarget, String nameSuccessfullyActForCheckRequest, String statusCodeForCheckRequest) {
        this.paymentOrderAction = paymentOrderAction;
        this.paymentOrderTarget = paymentOrderTarget;
        this.nameSuccessfullyActForCheckRequest = nameSuccessfullyActForCheckRequest;
        this.statusCodeForCheckRequest = statusCodeForCheckRequest;
    }

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "PutPaymentOrderDoc");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        switch (paymentOrderTarget) {
            case PAYMENT_TO_COUNTERPARTY -> fieldsAndValues = new KonMap().getMapKon();
            case PAYMENT_TO_BUDGET -> fieldsAndValues = new BudMap().getMapBud();
            case PAYMENT_TO_YOURSELF -> fieldsAndValues = new YSMap().getMapYourSelf();
        }

        UniversalRequestRootTag put = new UniversalRequestRootTag();
        TagReqActOfUnivReq tagReqAct = new TagReqActOfUnivReq();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        tagReqAct.setV(paymentOrderAction.toString());
        put.setTagReqAct(tagReqAct);
        put.setC("put");
        put.setT("document");
        put.setN("PaymentOrder");
        put.setV(3.2);
        put.setS(AuthLogin.sessionID);
        fieldsAndValues.replace("DocumentNumber", TestRunClassicBox.docNumPayOrd.getDocNum());
        for (Map.Entry map : fieldsAndValues.entrySet()) {
            TagPOfUnivReq p = new TagPOfUnivReq();
            p.setN(map.getKey().toString());
            p.setV(map.getValue().toString());
            listP.add(p);
        }
        put.setListP(listP);
        marshallSetting(put);
    }


    private void info() throws IOException {
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        String messagePass = "\n\nПП создано \n" +
                "Идентификатор документа в банковской системе: " + documentBankID + "\n" +
                "Cтатус код: " + documentStatusCode + "\n" +
                "Номер документа: " + docNumber + "\n";
        String messageFail = "\n\nПП будет перемещено в категорию \"Черновики\" в статус \"Ошибка контроля\",тк сработали жесткие контроли\n" +
                "Идентификатор документа: " + documentID + "\n" +
                "Номер документа: " + docNumber + "\n";
        String messageWithSoftControls = "\n\nПП будет создано,но при этом сработали мягкие контроли\n" +
                "Идентификатор документа: " + documentID + "\n" +
                "Номер документа: " + docNumber + "\n";

        BufferedReader bufferedReader;
        if (rootTag.getListC() == null) {
            bufferedReader = new BufferedReader(new StringReader(messagePass));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            log.info(stringBuilder.toString());
        } else {
            if (rootTag.getListC().get(0).getCe().equals("1")) {
                bufferedReader = new BufferedReader(new StringReader(messageFail));
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();

                stringBuilder.append("Сработали контроли:\n");
                for (int i = 0; i < rootTag.getListError().size(); i++) {
                    stringBuilder.append("Поле - " + rootTag.getListError().get(i).getField() + "\n" +
                            "Сообщение: " + rootTag.getListError().get(i).getMessage() + "\n" +
                            "Тип важности контроля: " + rootTag.getListError().get(i).getType() + "\n");
                }
                log.error(stringBuilder.toString());
            } else {
                bufferedReader = new BufferedReader(new StringReader(messageWithSoftControls));
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                stringBuilder.append("Контроли:\n");
                for (int i = 0; i < rootTag.getListError().size(); i++) {
                    stringBuilder.append("Поле - " + rootTag.getListError().get(i).getField() + "\n" +
                            "Сообщение: " + rootTag.getListError().get(i).getMessage() + "\n" +
                            "Тип важности контроля: " + rootTag.getListError().get(i).getType() + "\n");
                }
                log.warn(stringBuilder.toString());
            }
        }
    }


    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            if (rootTag.getListC() != null) {
                if (rootTag.getListC().get(0).getCe().equals("1")) {
                    documentID = rootTag.getListF().get(0).getD();
                    docNumber = rootTag.getListF().get(0).getN();
                    checkTest();
                    info();
                } else {
                    checkTest();
                    documentID = rootTag.getListF().get(0).getD();
                    documentStatusCode = rootTag.getListF().get(0).getS();
                    docNumber = rootTag.getListF().get(0).getN();
                    documentBankID = rootTag.getListF().get(0).getI();
                    info();

                }
            } else {
                checkTest();
                documentID = rootTag.getListF().get(0).getD();
                documentStatusCode = rootTag.getListF().get(0).getS();
                docNumber = rootTag.getListF().get(0).getN();
                documentBankID = rootTag.getListF().get(0).getI();
                info();
            }
        } else {
            failedResponseMessage();
        }
        switch (paymentOrderAction) {
            case SAVE -> new ExecutingSaveDocPayOrd().executing();
            case SIGN, SIGN_GO -> new ExecutingSignAndSignGoDocPayOrd().executing();
        }
    }


    private class ExecutingSaveDocPayOrd {
        PutPaymentOrderDocFORCE force;
        ReqToReceiveADoc getDoc;

        private void executing() throws JAXBException, IOException, InterruptedException {
            if (rootTag.getListC() != null) {
                force = new PutPaymentOrderDocFORCE(documentID);
                force.run();
                getDoc = new ReqToReceiveADoc(force.getDocumentBankID());
                getDoc.run();
            } else {
                getDoc = new ReqToReceiveADoc(documentBankID);
                getDoc.run();
            }
        }
    }

    private class ExecutingSignAndSignGoDocPayOrd {
        PutPaymentOrderDocCHECKCODE check;
        PutPaymentOrderDocDATAFORSIGN dataForSign;
        PutPaymentOrderDocFORCE force;
        ReqToReceiveADoc getDoc;

        private void executing() throws JAXBException, IOException, InterruptedException {
            if (rootTag.getListC() != null) {
                if (rootTag.getListC().get(0).getCe().equals("1")) {
                    force = new PutPaymentOrderDocFORCE(documentID);
                    force.run();
                    getDoc = new ReqToReceiveADoc(force.getDocumentBankID());
                    getDoc.run();
                } else {
                    Check.checkCountAvailableSPSign(rootTag);
                    force = new PutPaymentOrderDocFORCE(documentID);
                    force.run();
                    Check.checkCountAvailableSPForce(force.getRootTag());
                    dataForSign = new PutPaymentOrderDocDATAFORSIGN(force.getRootTag(), documentID);
                    dataForSign.run();
                    check = new PutPaymentOrderDocCHECKCODE(nameSuccessfullyActForCheckRequest, documentID, statusCodeForCheckRequest);
                    check.run();
                    getDoc = new ReqToReceiveADoc(check.getDocumentBankID());
                    getDoc.run();
                }
            } else {
                Check.checkCountAvailableSPSign(rootTag);
                dataForSign = new PutPaymentOrderDocDATAFORSIGN(rootTag, documentID);
                dataForSign.run();
                check = new PutPaymentOrderDocCHECKCODE(nameSuccessfullyActForCheckRequest, documentID, statusCodeForCheckRequest);
                check.run();
                getDoc = new ReqToReceiveADoc(check.getDocumentBankID());
                getDoc.run();
            }
        }
    }
}
