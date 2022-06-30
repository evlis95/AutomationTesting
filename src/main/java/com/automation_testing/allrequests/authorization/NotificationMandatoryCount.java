package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagFOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagTOfTagP;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationMandatoryCount extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "NotificationMandatoryCount");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag mandatoryCount = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        TagFOfTagP tagF = new TagFOfTagP();
        List<TagTOfTagP> listT = new ArrayList<>();

        mandatoryCount.setC("notification");
        mandatoryCount.setT("count");
        mandatoryCount.setN("mandatory");
        mandatoryCount.setV(1.0);
        mandatoryCount.setS(AuthLogin.sessionID);

        tagF.setG(UserFilter.rootTag.getListC().get(0).getI());

        listT.add(new TagTOfTagP("FreeDocFromBank"));
        listT.add(new TagTOfTagP("News"));

        tagP.setTagF(tagF);
        tagP.setListT(listT);

        mandatoryCount.setTagP(tagP);
        marshalling(mandatoryCount);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
