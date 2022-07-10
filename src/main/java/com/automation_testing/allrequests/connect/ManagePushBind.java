package com.automation_testing.allrequests.connect;

import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.settings.Settings;

import javax.xml.bind.JAXBException;
import java.io.*;

public class ManagePushBind extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "ManagePushBind");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag managePushBind = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        managePushBind.setT("managepush");
        managePushBind.setC("push");
        managePushBind.setN("bind");
        managePushBind.setV(1.0);
        tagP.setApv(Settings.APP_VERSION_NAME);
        tagP.setDid("cbb99cc0763eb5c2");
        tagP.setDnm("IDEA");
        tagP.setMs("0");
        tagP.setDph("1");
        tagP.setOs("IDEA");
        tagP.setOsv("");
        tagP.setPcpushid("cBPV8WtMQAqGVBFpqNrZgZ:APA91bHxg5Eg6ArcYsCwl4V10DOe-OSRQ3iJzEqLiNMfYe0JmXNh09fmlcgKtbrljbcAO6WsGX-AL3Ai-ROnAsPcPiTc8T1R-4x-YGFYmnkjiw-ucg91IsoAf7hL4sUtPvOuB86d0Bk_");
        tagP.setPushid("cBPV8WtMQAqGVBFpqNrZgZ:APA91bFpVr7dMTAnwgYO6Uwvyor5OOBQjS2Eq45PC3wwL1-8GgFe24tI7E_NG75BC0FLAoaCQmH_Csfw8AW9UnX3rYxdTTwy1DLvgMgTCEFngy2ZnLlX7qW-zBxBpkqgNJjSy3CuE2nN");
        managePushBind.setTagP(tagP);
        marshalling(managePushBind);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
