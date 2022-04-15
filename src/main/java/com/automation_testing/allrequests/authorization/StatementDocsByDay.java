package com.autotest.allrequests.authorization;

import com.autotest.checks.Check;
import com.autotest.creatingxml.TagAOfTagP;
import com.autotest.creatingxml.TagCOfTagP;
import com.autotest.creatingxml.TagPOfUnivReq;
import com.autotest.creatingxml.UniversalRequestRootTag;
import com.autotest.parsingxml.UniversalResponseRootTag;
import com.autotest.post_request_type.Post;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StatementDocsByDay extends Post {


    public static UniversalResponseRootTag rootTag;


    private String calculatingBICByIdSubDivision(String subDivisionId) {
        String divisionBIC = null;
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(subDivisionId)) {
                divisionBIC = UserFilter.rootTag.getListF().get(i).getB();
                break;
            }
        }
        return divisionBIC;
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag statementDocs = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        List<TagPOfUnivReq> listP = new ArrayList<>();

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
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getV().equals("810")) {
                listA.add(new TagAOfTagP((UserAccount.rootTag.getListA().get(i).getA()), (calculatingBICByIdSubDivision(UserAccount.rootTag.getListA().get(i).getF()))));
            }
        }

        tagP.setListA(listA);

        List<TagCOfTagP> listC = new ArrayList<>();
        TagCOfTagP tagC = new TagCOfTagP();
        tagC.setN("");
        listC.add(tagC);
        tagP.setListC(listC);

        listP.add(tagP);
        statementDocs.setListP(listP);

        marshallSetting(statementDocs);
    }


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "StatementDocsByDay");
    }



    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
            createXmlBodyRequest();
            request();
            writeBodyResponseInFile();
            if (getCodeStatusResponse() == 200) {
                rootTag = parseXmlBodyResponse();
                checkTest();
            } else {
                failedResponseMessage();
            }
    }


}

