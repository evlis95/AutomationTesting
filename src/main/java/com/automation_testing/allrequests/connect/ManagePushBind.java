package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import com.automation_testing.generalsettings.Settings;

import javax.xml.bind.JAXBException;
import java.io.*;

public class ManagePushBind extends Post {


    public static UniversalResponseRootTag rootTag;


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "ManagePushBind");
    }


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag managePushBind = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        managePushBind.setT("managepush");
        managePushBind.setC("push");
        managePushBind.setN("bind");
        managePushBind.setV(1.0);
        tagP.setApv(Settings.appVersionName);
        tagP.setDid("cbb99cc0763eb5c2");
        tagP.setDnm("IDEA");
        tagP.setMs("0");
        tagP.setDph("1");
        tagP.setOs("IDEA");
        tagP.setOsv("");
        tagP.setPcpushid("cBPV8WtMQAqGVBFpqNrZgZ:APA91bHxg5Eg6ArcYsCwl4V10DOe-OSRQ3iJzEqLiNMfYe0JmXNh09fmlcgKtbrljbcAO6WsGX-AL3Ai-ROnAsPcPiTc8T1R-4x-YGFYmnkjiw-ucg91IsoAf7hL4sUtPvOuB86d0Bk_");
        tagP.setPushid("cBPV8WtMQAqGVBFpqNrZgZ:APA91bFpVr7dMTAnwgYO6Uwvyor5OOBQjS2Eq45PC3wwL1-8GgFe24tI7E_NG75BC0FLAoaCQmH_Csfw8AW9UnX3rYxdTTwy1DLvgMgTCEFngy2ZnLlX7qW-zBxBpkqgNJjSy3CuE2nN");
        managePushBind.setTagP(tagP);
        marshallSetting(managePushBind);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
            printReqAndResInLog();
        } else {
            printReqAndResInLog();
            Check.quantityFAILED++;
        }
    }
}
