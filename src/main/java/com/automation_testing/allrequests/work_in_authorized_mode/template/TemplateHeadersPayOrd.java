package com.automation_testing.allrequests.work_in_authorized_mode.template;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.*;
import com.automation_testing.parsingxml.TagAOfTagUnivRes;
import com.automation_testing.parsingxml.TagDOfTagDS;
import com.automation_testing.parsingxml.TagFOfTagD;
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

        for (TagAOfTagUnivRes tagA : UserAccount.rootTag.getListA()) {
            if (tagA.getV().equals("810")) {
                listA.add(new TagAOfTagF(tagA.getA()));
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
        for (TagDOfTagDS tagD : rootTag.getListDS().get(0).getListD()) {
            for (TagFOfTagD tagF : tagD.getListF()) {
                if (tagF.getN().equals("TemplateName") & tagF.getV().equals("template")) {
                    for (TagFOfTagD tagF2 : tagD.getListF()) {
                        if (tagF2.getN().equals("BankRecordID")) {
                            templateID = tagF2.getV();
                        }
                    }
                }
            }
        }

    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            definitionTemplateID();
        }
    }
}
