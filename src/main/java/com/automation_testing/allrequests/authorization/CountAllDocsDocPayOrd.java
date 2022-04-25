package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.*;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountAllDocsDocPayOrd extends Post {

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
        UniversalRequestRootTag counallAllDocs = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        List<TagPOfUnivReq> listP = new ArrayList<>();
        List<TagTOfTagP> listT = new ArrayList<>();
        TagFOfTagP tagF = new TagFOfTagP();
        List<TagFOfTagP> listF = new ArrayList<>();
        List<TagSOfTagF> listS = new ArrayList<>();

        counallAllDocs.setC("countall");
        counallAllDocs.setT("document");
        counallAllDocs.setN("alldocs");
        counallAllDocs.setV(1.0);
        counallAllDocs.setS(AuthLogin.sessionID);


        listT.add(new TagTOfTagP("PaymentOrder"));

        tagF.setG(UserFilter.rootTag.getListC().get(0).getI());

        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getV().equals("810")) {
                listS.add(new TagSOfTagF((UserAccount.rootTag.getListA().get(i).getA()), (calculatingBICByIdSubDivision(UserAccount.rootTag.getListA().get(i).getF()))));
            }
        }

        tagF.setListS(listS);
        listF.add(tagF);

        tagP.setListT(listT);
        tagP.setListF(listF);

        listP.add(tagP);


        counallAllDocs.setListP(listP);

        marshallSetting(counallAllDocs);
    }


    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "CountallAlldocsDocumentPayment810");
    }


    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        printReqAndResInLog();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
        } else {
            Check.quantityFAILED++;
        }
    }
}


