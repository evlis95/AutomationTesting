package com.automation_testing.allrequests.work_in_authorized_mode.docnumber;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import org.jetbrains.annotations.NotNull;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class DocumentNumber extends Post {

    public static String docNum;
    public static UniversalResponseRootTag rootTag;

    private @NotNull String createTime() {
        long currentTime = System.currentTimeMillis();
        String editTime = Long.toString(currentTime);
        editTime = editTime.substring(0, 8) + "00000";
        return editTime;
    }

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "DocumentNumber");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag docNum = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        docNum.setC("documentnumber");
        docNum.setT("document");
        docNum.setN("PaymentOrder");
        docNum.setV(1.0);
        docNum.setS(AuthLogin.sessionID);
        tagP.setA(createTime());
        tagP.setB(UserFilter.rootTag.getListC().get(0).getI());
        docNum.setTagP(tagP);
        marshallSetting(docNum);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            docNum = rootTag.getListF().get(0).getV();
        }

    }
}