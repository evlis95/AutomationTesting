package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.test.Account;
import com.automation_testing.test.Organization;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private void addAccInOrganization() {
        Account account;
        ArrayList<Organization> organizationList = UserFilter.orgList;
        for (int i = 0; i < organizationList.size(); i++) {
            for (int j = 0; j < rootTag.getListA().size(); j++) {
                if (organizationList.get(i).getId().equals(rootTag.getListA().get(j).getO())) {
                    for (int k = 0; k < organizationList.get(i).getDivisionList().size(); k++) {
                        if (organizationList.get(i).getDivisionList().get(k).getId().equals(rootTag.getListA().get(j).getF())) {
                            account = new Account();
                            account.setA(rootTag.getListA().get(j).getA());
                            account.setB(rootTag.getListA().get(j).getB());
                            account.setF(rootTag.getListA().get(j).getF());
                            account.setO(rootTag.getListA().get(j).getO());
                            account.setT(rootTag.getListA().get(j).getT());
                            account.setY(rootTag.getListA().get(j).getY());
                            account.setU(rootTag.getListA().get(j).getU());
                            account.setD(rootTag.getListA().get(j).getD());
                            account.setC(rootTag.getListA().get(j).getC());
                            account.setH(rootTag.getListA().get(j).getH());
                            account.setV(rootTag.getListA().get(j).getV());
                            account.setI(rootTag.getListA().get(j).getI());
                            account.setE(rootTag.getListA().get(j).getE());
                            account.setCard(rootTag.getListA().get(j).getCard());
                            account.setId(rootTag.getListA().get(j).getId());
                            account.setClientName(rootTag.getListA().get(j).getClientName());
                            account.setSdoc(rootTag.getListA().get(j).getSdoc());
                            account.setWithAccept(rootTag.getListA().get(j).getWithAccept());
                            account.setSbpPay(rootTag.getListA().get(j).getSbppay());
                            organizationList.get(i).getDivisionList().get(k).addAccount(account);
                        }
                    }
                }
            }
        }
        UserFilter.orgList = organizationList;
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            addAccInOrganization();
        }
    }
}
