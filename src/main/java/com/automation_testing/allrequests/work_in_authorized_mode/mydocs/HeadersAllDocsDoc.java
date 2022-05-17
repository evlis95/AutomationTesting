package com.automation_testing.allrequests.work_in_authorized_mode.mydocs;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagFOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagTOfTagP;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public class HeadersAllDocsDoc extends Post {
    private final Logger LOG = LogManager.getLogger(HeadersAllDocsDoc.class);
    private UniversalResponseRootTag rootTag;

    public UniversalResponseRootTag getRootTag() {
        return rootTag;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "HeadersAllDocsDocument");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag headers = new UniversalRequestRootTag();

        headers.setC("headers");
        headers.setT("document");
        headers.setN("alldocs");
        headers.setV(1.0);
        headers.setS(AuthLogin.sessionID);


        TagPOfUnivReq tagP = new TagPOfUnivReq("0", UserFilter.orgId, new TagFOfTagP("", ""), new TagTOfTagP("CancellationRequest"));

        headers.setTagP(tagP);
        marshalling(headers);
    }

    private void checkAvailabilityDocPayOrdInRes() {
        if (rootTag.getListDS() != null) {
            if (rootTag.getListDS().get(0).getListM() != null) {
                boolean result = false;
                for (int i = 0; i < rootTag.getListDS().get(0).getListM().get(0).getListD().size(); i++) {
                    if (rootTag.getListDS().get(0).getListM().get(0).getListD().get(i).getType().equals("CancellationRequest")) {
                        result = true;
                        break;
                    }
                }
                if (result) {
                    Check.quantityPASS++;
                    LOG.info("Проверка на наличие документов CancellationRequest в ответе на запрос HeadersAllDocsDoc - PASS");
                } else {
                    Check.quantityFAILED++;
                    LOG.error("Проверка на наличие документов CancellationRequest в ответе на запрос HeadersAllDocsDoc - FAILED");
                }
            } else {
                Check.quantityFAILED++;
                LOG.error("Проверка на наличие документов в ответе на запрос HeadersAllDocsDoc - FAILED");
            }
        } else {
            Check.quantityFAILED++;
            LOG.error("Проверка на наличие документов в ответе на запрос HeadersAllDocsDoc - FAILED");
        }
    }


    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            checkAvailabilityDocPayOrdInRes();
        }
    }
}
