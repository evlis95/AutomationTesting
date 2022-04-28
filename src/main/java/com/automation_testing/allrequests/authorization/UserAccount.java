package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.hibernate.pojo.Accounts;
import com.automation_testing.hibernate.pojo.Divisions;
import com.automation_testing.hibernate.pojo.Organizations;
import com.automation_testing.hibernate.service.DivisionService;
import com.automation_testing.hibernate.service.OrganizationService;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.*;

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

        marshallSetting(userAccount);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "UserAccount");
    }

   private void parsingDataAndSaveInBD() {
        OrganizationService organizationService = new OrganizationService();
        Organizations org = organizationService.findOrg(UserFilter.orgId);

        DivisionService divisionService = new DivisionService();
        Divisions division;
        Accounts acc;
        for (int i = 0; i < rootTag.getListA().size(); i++) {
            acc = new Accounts();
            acc.setAccNum(rootTag.getListA().get(i).getA());
            acc.setId(rootTag.getListA().get(i).getId());
            acc.setAccNumericalCode(rootTag.getListA().get(i).getV());
            acc.setType(rootTag.getListA().get(i).getT());
            division = divisionService.findDivision(rootTag.getListA().get(i).getF());
            acc.setDivision(division);
            org.addAccount(acc);
        }
        organizationService.merge(org);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = parsingResponseBody();
            parsingDataAndSaveInBD();
        }
    }
}
