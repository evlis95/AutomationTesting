package com.automation_testing.allrequests.work_in_authorized_mode.sbp;

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

public class SBPHeadersByDay extends Post {

    public static UniversalResponseRootTag rootTag;
    private String[] statusCode = new String[]{"10", "3", "1", "6", "42", "7", "11", "12", "17", "59"};

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag sbp = new UniversalRequestRootTag();
        sbp.setC("sbpheadersbyday");
        sbp.setT("document");
        sbp.setN("SystemFastPay");
        sbp.setV(1.0);
        sbp.setS(AuthLogin.sessionID);

        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setP("0");
        tagP.setG(UserFilter.orgId);

        List<TagAOfTagP> listA = new ArrayList<>();

        for (int i = 0; i < statusCode.length; i++) {
            listA.add(new TagAOfTagP(statusCode[i]));
        }
        tagP.setListA(listA);

        List<TagSOfTagF> listS = new ArrayList<>();
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getV().equals("810") & (UserAccount.rootTag.getListA().get(i).getO().equals(UserFilter.orgId))) {
                listS.add(new TagSOfTagF((UserAccount.rootTag.getListA().get(i).getA()), (calculatingBICByIdSubDivision(UserAccount.rootTag.getListA().get(i).getF()))));
            }
        }

        TagFOfTagP tagF = new TagFOfTagP();
        tagF.setPhone("");
        tagF.setTspId("");
        tagF.setFromDate("");
        tagF.setToDate("");
        tagF.setMinAmount("");
        tagF.setMaxAmount("");
        tagF.setListS(listS);
        tagP.setTagF(tagF);
        sbp.setTagP(tagP);
        marshalling(sbp);
    }

    @Override
    protected void checkTest() throws IOException, JAXBException {
        Check.checkCode200(codeStatusResponse, "SBPHeadersByDay");
    }

    private String calculatingBICByIdSubDivision(String subDivisionId) {
        String divisionBIC = "";
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            if (UserFilter.rootTag.getListF().get(i).getI().equals(subDivisionId)) {
                divisionBIC = UserFilter.rootTag.getListF().get(i).getB();
                break;
            }
        }
        return divisionBIC;
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        rootTag = Post.rootTag;
    }
}
