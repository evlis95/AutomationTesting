package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.hibernate.pojo.MobileServices;
import com.automation_testing.hibernate.pojo.PaymentOrder;
import com.automation_testing.hibernate.service.MobileServicesService;
import com.automation_testing.hibernate.service.PaymentOrderService;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class PutDocCHECKCODE extends Post {
    public static String documentBankID;
    //реквизиты сохраненного ПП
    public static String documentStatusCode;
    public static String documentNumber;
    public static UniversalResponseRootTag rootTag;
    private final Logger LOG = LogManager.getLogger(PutDocCHECKCODE.class);
    private final String NAME_REQ_AND_ACT_FOR_LOG;
    private final String DOC_ID;
    private final String STA_CODE_FOR_CHECK;

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
        marshalling(checkCode);
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

    private void writingPayOrdToDB() {
        PaymentOrderService pos = new PaymentOrderService();
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setDocBankID(documentBankID);
        paymentOrder.setDocNum(documentNumber);
        paymentOrder.setStatus(documentStatusCode);

        MobileServicesService servMob = new MobileServicesService();
        MobileServices mobileServices = servMob.findOrg(PutDocAction.payerDivisionID);
        if (mobileServices.getAdv().equals("1") & mobileServices.getReq().equals("1")) {
            paymentOrder.setAvailForCanReq("1");
        } else {
            paymentOrder.setAvailForCanReq("0");
        }
        pos.saveOrUpdatePaymentOrder(paymentOrder);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            initializationFields();
            if (PutDocAction.documentTypeString.equals("PaymentOrder")) {
                writingPayOrdToDB();
            }
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