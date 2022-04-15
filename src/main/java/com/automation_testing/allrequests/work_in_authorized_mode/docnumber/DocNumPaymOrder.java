package com.autotest.allrequests.work_in_authorized_mode.docnumber;

import com.autotest.allrequests.authorization.AuthLogin;
import com.autotest.allrequests.authorization.UserFilter;
import com.autotest.checks.Check;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import org.jetbrains.annotations.NotNull;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

public class DocNumPaymOrder extends Post {

    private String docNum;
    public static UniversalResponseRootTag rootTag;

    public String getDocNum() {
        return docNum;
    }

    private @NotNull String createTime() {
        long currentTime = System.currentTimeMillis();
        String editTime = Long.toString(currentTime);
        editTime = editTime.substring(0, 8) + "00000";
        return editTime;
    }

    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "DocumentNumberPaymentOrder");
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
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            docNum = rootTag.getListF().get(0).getV();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}