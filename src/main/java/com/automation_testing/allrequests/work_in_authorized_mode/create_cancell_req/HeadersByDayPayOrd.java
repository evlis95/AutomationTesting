package com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HeadersByDayPayOrd extends Post {
    public static UniversalResponseRootTag rootTag;
    public static String docID;
    private final Map<String, String> MAP_ACC_AND_BIC = new HashMap<>();
    private final String[] PAY_ORD_STAT_CODE = {"7"};

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "HeadersByDayPayOrd");
    }


    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag headersByDay = new UniversalRequestRootTag();
        List<TagAOfTagP> listA = new ArrayList<>();
        List<TagSOfTagF> listS = new ArrayList<>();
        headersByDay.setC("headersbyday");
        headersByDay.setT("document");
        headersByDay.setN("PaymentOrder");
        headersByDay.setV(1.0);
        headersByDay.setS(AuthLogin.sessionID);

        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getV().equals("810") & UserAccount.rootTag.getListA().get(i).getO().equals(UserFilter.rootTag.getListC().get(0).getI())) {
                listS.add(new TagSOfTagF((UserAccount.rootTag.getListA().get(i).getA()), (calculatingBICByIdSubDivision(UserAccount.rootTag.getListA().get(i).getF()))));
            }
        }


        for (String s : PAY_ORD_STAT_CODE) {
            listA.add(new TagAOfTagP(s));
        }
        MAP_ACC_AND_BIC.forEach((key, value) -> {
            TagSOfTagF tagS = new TagSOfTagF(key, value);
            listS.add(tagS);
        });

        TagFOfTagP tagF = new TagFOfTagP("0", "0", listS);
        headersByDay.setTagP(new TagPOfUnivReq("0", UserFilter.orgId, listA, tagF));

        marshalling(headersByDay);
    }

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

    private void initiationDocID() {
        for (int i = 0; i < rootTag.getListDS().get(0).getListM().get(0).getListD().get(0).getListF().size(); i++) {
            if (rootTag.getListDS().get(0).getListM().get(0).getListD().get(0).getListF().get(i).getN().equals("BankRecordID")) {
                docID = rootTag.getListDS().get(0).getListM().get(0).getListD().get(0).getListF().get(i).getV();
                break;
            }
        }
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            initiationDocID();
        }
    }
}