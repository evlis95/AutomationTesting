package com.autotest.allrequests.work_in_authorized_mode.dictionary;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class GetFullBankRuKon extends Post {


    public static UniversalResponseRootTag rootTag;
    public static String receiverBankName;
    public static String receiverCorrAcc;
    public static String receiverBIC;
    public static String receiverPlace;
    public static String receiverPlaceType;

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "GetFullBankRuDict");
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
        marshallSetting(getFull);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            receiverBankName = rootTag.getListR().get(0).getX();
            receiverBIC = rootTag.getListR().get(0).getD();
            receiverCorrAcc = rootTag.getListR().get(0).getTagCorrAcc().get(0).getA();
            receiverPlace = rootTag.getListR().get(0).getV();
            receiverPlaceType = rootTag.getListR().get(0).getB();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}