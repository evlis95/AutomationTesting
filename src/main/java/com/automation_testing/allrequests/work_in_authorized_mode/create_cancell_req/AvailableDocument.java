package com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.work_in_authorized_mode.put_document.PutDocAction;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class AvailableDocument extends Post {
    private final Logger LOG = LogManager.getLogger(AvailableDocument.class);
    private final String docType;
    private final String docID;
    public static UniversalResponseRootTag rootTag;
    public static String result;

    public AvailableDocument(String docType, String docID) {
        this.docType = docType;
        this.docID = docID;
    }

    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "AvailableDocumentForCancellReq");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag available = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        available.setC("Available");
        available.setT("document");
        available.setN("CancellationRequest");
        available.setV(1.0);
        available.setS(AuthLogin.sessionID);

        tagP.setA(docID);
        tagP.setB(docType);

        available.setTagP(tagP);
        marshallSetting(available);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = parsingResponseBody();
            result = rootTag.getListF().get(0).getV();

            if(result.equals("1")) {
                LOG.info("Проверка на доступность отзыва документа - PASS\n");
                Check.quantityPASS++;
            } else {
                LOG.error("Проверка на доступность отзыва документа - FAILED\n");
                Check.quantityFAILED++;
            }
        }
    }
}
