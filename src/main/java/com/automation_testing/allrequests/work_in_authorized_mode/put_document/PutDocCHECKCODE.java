package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;

import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;

import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;

public class PutDocCHECKCODE extends Post {
    private final Logger LOG = LogManager.getLogger(PutDocCHECKCODE.class);
    private final String NAME_REQ_AND_ACT_FOR_LOG;
    private final String DOC_ID;
    private final String STA_CODE_FOR_CHECK;
    public static String documentBankID;
    //реквизиты сохраненного ПП
    public static String documentStatusCode;
    public static String documentNumber;
    public static UniversalResponseRootTag rootTag;

    public PutDocCHECKCODE(String nameRequestAndActionForLog, String documentID, String statusCodeForCheck) {
        this.NAME_REQ_AND_ACT_FOR_LOG = nameRequestAndActionForLog;
        this.DOC_ID = documentID;
        this.STA_CODE_FOR_CHECK = statusCodeForCheck;

    }

    public String getDocumentBankID() {
        return documentBankID;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "CHECKCODE");
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
        tagReqAct.setDocID(DOC_ID);
        checkCode.setTagReqAct(tagReqAct);
        marshallSetting(checkCode);
    }

    private void info() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String messageText = String.format("\n\n%s\n" +
                "Идентификатор документа в банковской системе: " + documentBankID + "\n" +
                "Cтатус код: " + documentStatusCode + "\n" +
                "Номер документа: " + documentNumber + "\n", NAME_REQ_AND_ACT_FOR_LOG);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(messageText));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.info(stringBuilder.toString());
    }

    private void initializationFields() {
        documentBankID = rootTag.getListF().get(0).getI();
        documentNumber = rootTag.getListF().get(0).getN();
        documentStatusCode = rootTag.getListF().get(0).getS();
    }

    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = parsingResponseBody();
            initializationFields();
            info();
            if (documentStatusCode.equals(STA_CODE_FOR_CHECK)) {
                LOG.info("Проверка присвоения статус кода " + STA_CODE_FOR_CHECK + " документу - PASS\n");
                Check.quantityPASS++;
            } else {
                LOG.error("Проверка присвоения статус кода " + STA_CODE_FOR_CHECK + " документу - FAILED");
                Check.quantityFAILED++;
            }
        }
    }
}