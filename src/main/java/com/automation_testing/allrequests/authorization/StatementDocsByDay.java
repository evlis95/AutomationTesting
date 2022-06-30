package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagAOfTagP;
import com.automation_testing.creatingxml.TagCOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.TagAOfTagUnivRes;
import com.automation_testing.parsingxml.TagFOfTagUnivRes;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatementDocsByDay extends Post {

    public static UniversalResponseRootTag rootTag;

    private String calculatingBICByIdSubDivision(String subDivisionId) {
        String divisionBIC = null;

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
        UniversalRequestRootTag statementDocs = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();


        statementDocs.setC("all");
        statementDocs.setT("dictionary");
        statementDocs.setN("statementdocsbyday");
        statementDocs.setV(1.0);
        statementDocs.setS(AuthLogin.sessionID);

        tagP.setS("");
        tagP.setE("");
        tagP.setT("2");
        tagP.setA("");
        tagP.setB("");
        tagP.setG("");
        tagP.setC("");
        tagP.setCard("");
        tagP.setP("0");
        tagP.setN("");
        tagP.setR("");

        List<TagAOfTagP> listA = new ArrayList<>();

        for (TagAOfTagUnivRes tagA : UserAccount.rootTag.getListA()) {
            if (tagA.getV().equals("810")) {
                listA.add(new TagAOfTagP((tagA.getA()), (calculatingBICByIdSubDivision(tagA.getF()))));
            }
        }

        tagP.setListA(listA);
        tagP.setTagC(new TagCOfTagP(""));

        statementDocs.setTagP(tagP);
        marshalling(statementDocs);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "StatementDocsByDay");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}

