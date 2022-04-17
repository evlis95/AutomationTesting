package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;

import com.automation_testing.checks.Check;

import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.*;

public class PutDocCHECKCODE extends Post {
    private final static Logger log = LogManager.getLogger(PutDocCHECKCODE.class);
    private final String nameRequestAndActionForLog;
    private final String documentID;
    private final String statusCodeForCheck;
    private String documentBankID;

    //реквизиты сохраненного ПП
    private String documentStatusCode;
    private String documentNumber;
    public static UniversalResponseRootTag rootTag;

    public PutDocCHECKCODE(String nameRequestAndActionForLog, String documentID, String statusCodeForCheck) {
        this.nameRequestAndActionForLog = nameRequestAndActionForLog;
        this.documentID = documentID;
        this.statusCodeForCheck = statusCodeForCheck;
    }

    public String getDocumentBankID() {
        return documentBankID;
    }


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "CHECKCODE");

        if (documentStatusCode.equals(statusCodeForCheck)) {
            log.info("Проверка присвоения статус кода " + statusCodeForCheck + " документу - PASS\n");
            Check.quantityPASS++;
        } else {
            log.error("Проверка присвоения статус кода " + statusCodeForCheck + " документу - FAILED");
            Check.quantityFAILED++;
        }
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag checkCode = new UniversalRequestRootTag();
        TagReqActOfUnivReq tagReqAct = new TagReqActOfUnivReq();
        checkCode.setC("put");
        checkCode.setT("document");
        checkCode.setN(PutDocAction.documentTypeString);
        checkCode.setV(3.1);
        checkCode.setS(AuthLogin.sessionID);
        checkCode.setTagC("1");
        tagReqAct.setV("CHECKCODE");
        tagReqAct.setDocID(documentID);
        checkCode.setTagReqAct(tagReqAct);
        marshallSetting(checkCode);
    }

    private void info() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String messageText = String.format("\n\n%s\n" +
                "Идентификатор документа в банковской системе: " + documentBankID + "\n" +
                "Cтатус код: " + documentStatusCode + "\n" +
                "Номер документа: " + documentNumber + "\n", nameRequestAndActionForLog);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(messageText));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();
        log.info(stringBuilder.toString());
    }

    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            documentBankID = rootTag.getListF().get(0).getI();
            documentNumber = rootTag.getListF().get(0).getN();
            documentStatusCode = rootTag.getListF().get(0).getS();
            checkTest();
            info();

        } else {
            failedResponseMessage();
        }
    }
}