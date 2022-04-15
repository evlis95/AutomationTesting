package com.autotest.allrequests.authorization;

import com.autotest.checks.Check;
import com.autotest.creatingxml.TagFOfTagP;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.TagTOfTagP;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationMandatoryCount extends Post {


    public static UniversalResponseRootTag rootTag;
    


    private void checkTest() throws IOException {
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
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                failedResponseMessage();
            }
    }
}
