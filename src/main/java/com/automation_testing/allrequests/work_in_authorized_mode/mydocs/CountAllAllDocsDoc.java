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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountAllAllDocsDoc extends Post {
    public static UniversalResponseRootTag rootTag;
    private final Logger LOG = LogManager.getLogger(CountAllAllDocsDoc.class);
    private int tagTQuantity;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "CountAllAllDocsDocument");

    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag countAll = new UniversalRequestRootTag();
        Set<TagTOfTagP> setTOfTagP = new HashSet<>();
        List<TagFOfTagP> listFOfTagP = new ArrayList<>();
        TagFOfTagP tagF = new TagFOfTagP();

        countAll.setC("countall");
        countAll.setT("document");
        countAll.setN("alldocs");
        countAll.setV(1.0);
        countAll.setS(AuthLogin.sessionID);

        tagF.setG(UserFilter.rootTag.getListC().get(0).getI());
        listFOfTagP.add(tagF);
        marshalling(countAll);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            if (rootTag.getListD() != null) {
                if (tagTQuantity == rootTag.getListD().size()) {
                    LOG.info("Проверка количества пришедших типов документов в ответе на запрос CountAllAllDocsDoc, в зависимости от тех, которые ушли в запросе - PASS");
                    Check.quantityPASS++;
                } else {
                    LOG.error("Проверка количества пришедших типов документов в ответе на запрос CountAllAllDocsDoc, в зависимости от тех, которые ушли в запросе - FAILED");
                    Check.quantityFAILED++;
                }
            }
        }
    }
}
