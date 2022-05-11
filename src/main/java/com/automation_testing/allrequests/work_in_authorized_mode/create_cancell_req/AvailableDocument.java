package com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class AvailableDocument extends Post {
    private final Logger LOG = LogManager.getLogger(AvailableDocument.class);
    private final String DOC_TYPE;
    private final String DOC_ID;
    public static UniversalResponseRootTag rootTag;
    public static String result;

    public AvailableDocument(String docType, String docID) {
        this.DOC_TYPE = docType;
        this.DOC_ID = docID;
    }

    @Override
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

        tagP.setA(DOC_ID);
        tagP.setB(DOC_TYPE);

        available.setTagP(tagP);
        marshalling(available);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = unmarshalling();
            result = rootTag.getListF().get(0).getV();

            if (result.equals("1")) {
                LOG.info("Проверка на доступность отзыва документа - PASS\n");
                Check.quantityPASS++;
            } else {
                LOG.error("Проверка на доступность отзыва документа - FAILED\n");
                Check.quantityFAILED++;
            }
        }
    }
}
