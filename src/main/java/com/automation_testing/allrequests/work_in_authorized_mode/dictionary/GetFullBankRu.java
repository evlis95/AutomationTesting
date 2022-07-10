package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creating_xml.TagPOfUnivReq;
import com.automation_testing.creating_xml.UniversalRequestRootTag;
import com.automation_testing.parsing_xml.TagROfTagUnivRes;
import com.automation_testing.parsing_xml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetFullBankRu extends Post {


    public static UniversalResponseRootTag rootTag;
    public static String receiverBankName;
    public static String receiverCorrAcc;
    public static String receiverBIC;
    public static String receiverPlace;
    public static String receiverPlaceType;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "GetFullBankRuDict");
    }


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag getFull = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();

        getFull.setC("getfull");
        getFull.setT("dictionary");
        getFull.setN("bankru");
        getFull.setV(1.0);
        getFull.setS(AuthLogin.sessionID);

        tagP.setD("044525700");

        getFull.setTagP(tagP);
        marshalling(getFull);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            TagROfTagUnivRes tagR = rootTag.getListR().get(0);
            receiverBankName = tagR.getX();
            receiverBIC = tagR.getD();
            receiverCorrAcc = tagR.getH();
            receiverPlace = tagR.getV();
            receiverPlaceType = tagR.getB();
        }
    }
}