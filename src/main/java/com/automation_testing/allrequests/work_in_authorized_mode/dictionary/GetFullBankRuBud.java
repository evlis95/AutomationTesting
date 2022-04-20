package com.automation_testing.allrequests.work_in_authorized_mode.dictionary;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class GetFullBankRuBud extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String receiverBankName;
    public static String receiverGeneralBIC;
    public static String receiverPlace;
    public static String receiverPlaceType;
    public static String receiverCorrAcc;

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
        tagP.setD("044525225");

        getFull.setTagP(tagP);

        marshallSetting(getFull);
    }

    private void initializationData() {
        receiverCorrAcc = rootTag.getListR().get(0).getH();
        receiverBankName = rootTag.getListR().get(0).getX();
        receiverGeneralBIC = rootTag.getListR().get(0).getD();
        receiverPlace = rootTag.getListR().get(0).getV();
        receiverPlaceType = rootTag.getListR().get(0).getB();
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            initializationData();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}