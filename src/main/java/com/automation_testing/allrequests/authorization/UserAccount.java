package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.hibernate.dao.DivisionsDAO;
import com.automation_testing.hibernate.dao.OrganizationsDAO;
import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Accounts;
import com.automation_testing.hibernate.pojo.Divisions;
import com.automation_testing.hibernate.pojo.Organizations;
import com.automation_testing.parsingxml.TagAOfTagUnivRes;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class UserAccount extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag userAccount = new UniversalRequestRootTag();

        userAccount.setC("user");
        userAccount.setT("dictionary");
        userAccount.setN("account");
        userAccount.setV(3.1);
        userAccount.setS(AuthLogin.sessionID);

        marshalling(userAccount);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "UserAccount");
    }

    private void parsingDataAndSaveInBD() {

        CRUDable<Organizations> orgService = new OrganizationsDAO();
        CRUDable<Divisions> divService = new DivisionsDAO();

        Organizations org = orgService.findById(UserFilter.orgId);

        Divisions division;
        Accounts acc;

        for (TagAOfTagUnivRes tagA : rootTag.getListA()) {
            acc = new Accounts();
            acc.setAccNum(tagA.getA());
            acc.setId(tagA.getId());
            acc.setAccNumericalCode(tagA.getV());
            acc.setType(tagA.getT());
            division = divService.findById(tagA.getF());
            acc.setDivision(division);
            org.addAccount(acc);
        }
        orgService.merge(org);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            parsingDataAndSaveInBD();
        }
    }
}
