package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagFOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagTOfTagP;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationMandatoryCount extends Post {


    public static UniversalResponseRootTag rootTag;
    


    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "NotificationMandatoryCount");
    }



    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag mandatoryCount = new UniversalRequestRootTag();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        List<TagFOfTagP> listF = new ArrayList<>();
        TagFOfTagP tagF = new TagFOfTagP();
        List<TagTOfTagP> listT = new ArrayList<>();

        mandatoryCount.setC("notification");
        mandatoryCount.setT("count");
        mandatoryCount.setN("mandatory");
        mandatoryCount.setV(1.0);
        mandatoryCount.setS(AuthLogin.sessionID);

        tagF.setG(UserFilter.rootTag.getListC().get(0).getI());


        listF.add(tagF);
        listT.add(new TagTOfTagP("FreeDocFromBank"));
        listT.add(new TagTOfTagP("News"));
        tagP.setListF(listF);
        tagP.setListT(listT);
        listP.add(tagP);
        mandatoryCount.setListP(listP);

        marshallSetting(mandatoryCount);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            printReqAndResInLog();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                Check.quantityFAILED++;
            }
    }
}
