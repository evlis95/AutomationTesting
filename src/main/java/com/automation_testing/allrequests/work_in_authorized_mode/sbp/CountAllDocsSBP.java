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

public class CountAllDocsSBP extends Post {

    public static UniversalResponseRootTag rootTag;

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
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag sbp = new UniversalRequestRootTag();
        sbp.setC("countall");
        sbp.setT("document");
        sbp.setN("alldocs");
        sbp.setV(1.0);
        sbp.setS(AuthLogin.sessionID);

        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setTagT(new TagTOfTagP("SystemFastPay"));
        TagFOfTagP tagF = new TagFOfTagP();
        tagF.setG(UserFilter.orgId);
        List<TagSOfTagF> listS = new ArrayList<>();
        for (int i = 0; i < UserAccount.rootTag.getListA().size(); i++) {
            if (UserAccount.rootTag.getListA().get(i).getV().equals("810") & UserAccount.rootTag.getListA().get(i).getO().equals(UserFilter.orgId)) {
                listS.add(new TagSOfTagF((UserAccount.rootTag.getListA().get(i).getA()), (calculatingBICByIdSubDivision(UserAccount.rootTag.getListA().get(i).getF()))));
            }
        }
        tagF.setListS(listS);
        tagP.setTagF(tagF);
        sbp.setTagP(tagP);
        marshalling(sbp);
    }

    @Override
    protected void checkTest() throws IOException, JAXBException {
        Check.checkCode200(codeStatusResponse, "countAllDocsSBP");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        rootTag = Post.rootTag;
    }
}
