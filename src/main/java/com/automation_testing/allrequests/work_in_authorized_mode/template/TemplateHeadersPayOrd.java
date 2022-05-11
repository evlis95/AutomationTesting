package com.automation_testing.allrequests.work_in_authorized_mode.template;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.*;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemplateHeadersPayOrd extends Post {
    public static String templateID;
    public static UniversalResponseRootTag rootTag = new UniversalResponseRootTag();

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag rootReqTag = new UniversalRequestRootTag();
        rootReqTag.setC("templateheaders");
        rootReqTag.setT("document");
        rootReqTag.setN("all");
        rootReqTag.setV(1.0);
        rootReqTag.setS(AuthLogin.sessionID);

        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setP("0");

        TagFOfTagP tagF = new TagFOfTagP();
        tagF.setS("1");
        tagF.setT("0");

        List<TagAOfTagF> listA = new ArrayList<>();
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getV().equals("810")) {
                listA.add(new TagAOfTagF(UserAccount.rootTag.getListA().get(i).getA()));
            }
        }
        tagF.setListA(listA);
        tagF.setTagG(new TagGOfTagF(UserFilter.orgId));
        tagF.setTagT(new TagTOfTagF("PaymentOrder"));

        tagP.setTagF(tagF);
        rootReqTag.setTagP(tagP);

        marshalling(rootReqTag);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "TemplateHeadersPayOrd");
    }

    private void definitionTemplateID() {
        for (int i = 0; i < rootTag.getListDS().get(0).getListD().size(); i++) {
            for (int j = 0; j < rootTag.getListDS().get(0).getListD().get(i).getListF().size(); j++) {
                if (rootTag.getListDS().get(0).getListD().get(i).getListF().get(j).getN().equals("TemplateName")
                        & rootTag.getListDS().get(0).getListD().get(i).getListF().get(j).getV().equals("template")) {
                    for (int k = 0; k < rootTag.getListDS().get(0).getListD().get(i).getListF().size(); k++) {
                        if (rootTag.getListDS().get(0).getListD().get(i).getListF().get(k).getN().equals("BankRecordID")) {
                            templateID = rootTag.getListDS().get(0).getListD().get(i).getListF().get(k).getV();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if(codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            definitionTemplateID();
        }
    }
}
