package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.work_in_authorized_mode.getdoc.GetDocument;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PutDocAction extends Post {
    public static String payerDivisionID;
    public static String documentTypeString;
    public static UniversalResponseRootTag rootTag;
    public final DocumentType DOC_TYPE;
    private final Map<String, String> MAP_FIELDS_AND_VALUES;
    private final Logger LOG = LogManager.getLogger(PutDocAction.class);
    private final DocumentAction DOC_ACTION;
    private String documentID;
    private String documentBankID;
    private String messPass;
    private String docNumber;
    private String documentStatusCode;
    private String statusCodeForCheck;


    public PutDocAction(DocumentAction documentAction, Map<String, String> fieldsMap, DocumentType docType) {
        this.DOC_ACTION = documentAction;
        this.MAP_FIELDS_AND_VALUES = fieldsMap;
        this.DOC_TYPE = docType;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "PutDocument");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        switch (DOC_TYPE) {
            case PAYMENT_ORDER -> documentTypeString = "PaymentOrder";
            case CANCELLATION_REQUEST -> documentTypeString = "CancellationRequest";
            case SYSTEM_FAST_PAY -> documentTypeString = "SystemFastPay";
        }
        UniversalRequestRootTag put = new UniversalRequestRootTag();

        List<TagPOfUnivReq> listP = new ArrayList<>();

        put.setTagReqAct(new TagReqActOfUnivReq((DOC_ACTION.toString()),"0"));

        put.setC("put");
        put.setT("document");
        put.setN(documentTypeString);
        put.setV(3.1);
        put.setS(AuthLogin.sessionID);

        MAP_FIELDS_AND_VALUES.forEach((key, value) -> {
            TagPOfUnivReq p = new TagPOfUnivReq();
            p.setN(key);
            p.setV(value);
            listP.add(p);
        });

        put.setListP(listP);
        marshalling(put);
    }


    private void info() throws IOException {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String messagePass = "\n\nДокумент создан \n" +
                "Идентификатор документа в банковской системе: " + documentBankID + "\n" +
                "Cтатус код: " + documentStatusCode + "\n" +
                "Номер документа: " + docNumber + "\n";
        String messageFail = "\n\nДокумент будет перемещен в категорию \"Черновики\" в статус \"Ошибка контроля\",тк сработали жесткие контроли\n" +
                "Идентификатор документа: " + documentID + "\n" +
                "Номер документа: " + docNumber + "\n";
        String messageWithSoftControls = "\n\nДокумент будет создан,но при этом сработали мягкие контроли\n" +
                "Идентификатор документа: " + documentID + "\n" +
                "Номер документа: " + docNumber + "\n";

        BufferedReader bufferedReader;
        if (rootTag.getListC() == null) {
            bufferedReader = new BufferedReader(new StringReader(messagePass));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            LOG.info(stringBuilder.toString());
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
                LOG.error(stringBuilder.toString());
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
                LOG.warn(stringBuilder.toString());
            }
        }
    }

    private void initialPayerDivisionID() {
        payerDivisionID = MAP_FIELDS_AND_VALUES.get("BranchBankRecordID");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        initialPayerDivisionID();
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            if (rootTag.getListC() != null) {
                if (rootTag.getListC().get(0).getCe().equals("1")) {
                    documentID = rootTag.getListF().get(0).getD();
                    docNumber = rootTag.getListF().get(0).getN();
                    Check.quantityFAILED++;
                } else {
                    documentID = rootTag.getListF().get(0).getD();
                    documentStatusCode = rootTag.getListF().get(0).getS();
                    docNumber = rootTag.getListF().get(0).getN();
                    documentBankID = rootTag.getListF().get(0).getI();
                }
                info();
            } else {
                documentID = rootTag.getListF().get(0).getD();
                documentStatusCode = rootTag.getListF().get(0).getS();
                docNumber = rootTag.getListF().get(0).getN();
                documentBankID = rootTag.getListF().get(0).getI();
                info();
            }
        }


        switch (DOC_TYPE) {
            case PAYMENT_ORDER -> {
                if (DOC_ACTION.toString().equals("SIGN")) {
                    messPass = "ПП успешно подписано";
                } else {
                    messPass = "ПП успешно подписано и отправлено";
                }
            }
            case CANCELLATION_REQUEST -> {
                if (DOC_ACTION.toString().equals("SIGN")) {
                    messPass = "Документ запроса на отзыв успешно подписан";
                } else {
                    messPass = "Документ запроса на отзыв успешно подписан и отправлен";
                }
            }

        }
        switch (DOC_ACTION) {
            case SAVE -> {
                new ExecutingSaveDoc().executing();
            }
            case SIGN -> {
                statusCodeForCheck = "6";
                new ExecutingSignAndSignGoDoc().executing();
            }
            case SIGN_GO -> {
                statusCodeForCheck = "43";
                new ExecutingSignAndSignGoDoc().executing();
            }
        }
    }

    private class ExecutingSaveDoc {
        PutDocFORCE force;
        GetDocument getDoc;

        private void executing() throws JAXBException, IOException, InterruptedException {
            if (rootTag.getListC() != null) {
                force = new PutDocFORCE(documentID);
                force.run();
                getDoc = new GetDocument(force.getDocumentBankID(), documentTypeString);
                getDoc.run();
            } else {
                getDoc = new GetDocument(documentBankID, documentTypeString);
                getDoc.run();
            }
        }
    }

    private class ExecutingSignAndSignGoDoc {
        PutDocCHECKCODE check;
        PutDocDATAFORSIGN dataForSign;
        PutDocFORCE force;
        GetDocument getDoc;

        private void executing() throws JAXBException, IOException, InterruptedException {
            if (documentTypeString.equals("SystemFastPay")) {
                if (rootTag.getListC() != null) {
                    if (rootTag.getListC().get(0).getCe().equals("1")) {
                        force = new PutDocFORCE(documentID);
                        force.run();
                    } else {
                        force = new PutDocFORCE(documentID);
                        force.run();
                        dataForSign = new PutDocDATAFORSIGN(force.getRootTag(), documentID);
                        dataForSign.run();
                    }
                } else {
                    dataForSign = new PutDocDATAFORSIGN(rootTag, documentID);
                    dataForSign.run();
                }
            } else {
                if (rootTag.getListC() != null) {
                    if (rootTag.getListC().get(0).getCe().equals("1")) {
                        force = new PutDocFORCE(documentID);
                        force.run();
                        getDoc = new GetDocument(force.getDocumentBankID(), documentTypeString);
                        getDoc.run();
                    } else {

                        force = new PutDocFORCE(documentID);
                        force.run();
                        dataForSign = new PutDocDATAFORSIGN(force.getRootTag(), documentID);
                        dataForSign.run();

                        check = new PutDocCHECKCODE(messPass, documentID, statusCodeForCheck);
                        check.run();
                        getDoc = new GetDocument(check.getDocumentBankID(), documentTypeString);
                        getDoc.run();
                    }
                } else {

                    dataForSign = new PutDocDATAFORSIGN(rootTag, documentID);
                    dataForSign.run();
                    check = new PutDocCHECKCODE(messPass, documentID, statusCodeForCheck);
                    check.run();
                    getDoc = new GetDocument(check.getDocumentBankID(), documentTypeString);
                    getDoc.run();
                }
            }
        }
    }
}
