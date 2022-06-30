package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.*;
import com.automation_testing.parsingxml.TagAOfTagUnivRes;
import com.automation_testing.parsingxml.TagFOfTagUnivRes;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountAllDocsDocPayOrd extends Post {

    public static UniversalResponseRootTag rootTag;

    private String calculatingBICByIdSubDivision(String subDivisionId) {
        String divisionBIC = "";

        for (TagFOfTagUnivRes tagF : UserFilter.rootTag.getListF()) {
            if (tagF.getI().equals(subDivisionId)) {
                divisionBIC = tagF.getB();
                break;
            }
        }
        return divisionBIC;
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag countAllDocs = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        TagFOfTagP tagF = new TagFOfTagP();
        List<TagSOfTagF> listS = new ArrayList<>();

        countAllDocs.setC("countall");
        countAllDocs.setT("document");
        countAllDocs.setN("alldocs");
        countAllDocs.setV(1.0);
        countAllDocs.setS(AuthLogin.sessionID);


        for (TagAOfTagUnivRes tagA : UserAccount.rootTag.getListA()) {
            if (tagA.getV().equals("810")) {
                listS.add(new TagSOfTagF((tagA.getA()), (calculatingBICByIdSubDivision(tagA.getF()))));
            }
        }

        tagF.setG(UserFilter.orgId);
        tagF.setListS(listS);

        tagP.setTagT(new TagTOfTagP("PaymentOrder"));
        tagP.setTagF(tagF);

        countAllDocs.setTagP(tagP);
        marshalling(countAllDocs);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "CountallAlldocsDocumentPayment810");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}


