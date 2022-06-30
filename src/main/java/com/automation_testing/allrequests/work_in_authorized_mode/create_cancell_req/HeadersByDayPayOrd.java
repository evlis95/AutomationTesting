package com.automation_testing.allrequests.work_in_authorized_mode.create_cancell_req;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserAccount;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.*;
import com.automation_testing.parsingxml.TagAOfTagUnivRes;
import com.automation_testing.parsingxml.TagFOfTagUnivRes;
import com.automation_testing.parsingxml.TagVOfTagUnivRes;
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
    private final Map<String, String> MAP_ACC_AND_BIC = new HashMap<>();
    private final List<String> DIVISION_WITH_ENABLED_SERVICE_ADV_AND_REQ = new ArrayList<>();
    private final String[] PAY_ORD_STAT_CODE = {"8", "40", "43", "44", "45", "46", "48"};

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "HeadersByDayPayOrd");
    }

    private void definingAccWithConnServ() {
        for (TagVOfTagUnivRes tagV : UserFilter.rootTag.getListV()) {
            if (tagV.getAdv().equals("1") & tagV.getReq().equals("1")) {
                DIVISION_WITH_ENABLED_SERVICE_ADV_AND_REQ.add(tagV.getF());
            }
        }
        for (String s : DIVISION_WITH_ENABLED_SERVICE_ADV_AND_REQ) {
            for (TagFOfTagUnivRes tagF : UserFilter.rootTag.getListF()) {
                for (TagAOfTagUnivRes tagA : UserAccount.rootTag.getListA()) {
                    if (s.equals(tagF.getI()) & s.equals(tagA.getF()) & tagA.getV().equals("810")) {
                        MAP_ACC_AND_BIC.put(tagA.getA(), tagF.getB());
                    }
                }
            }
        }
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        definingAccWithConnServ();
        UniversalRequestRootTag headersByDay = new UniversalRequestRootTag();
        List<TagAOfTagP> listA = new ArrayList<>();
        List<TagSOfTagF> listS = new ArrayList<>();

        headersByDay.setC("headersbyday");
        headersByDay.setT("document");
        headersByDay.setN("PaymentOrder");
        headersByDay.setV(1.0);
        headersByDay.setS(AuthLogin.sessionID);

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

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}