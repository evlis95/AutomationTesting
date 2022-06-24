package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.hibernate.pojo.Divisions;
import com.automation_testing.hibernate.pojo.Organizations;
import com.automation_testing.hibernate.pojo.MobileServices;

import com.automation_testing.hibernate.service.DivisionService;
import com.automation_testing.hibernate.service.OrganizationService;
import com.automation_testing.hibernate.service.MobileServicesService;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.xml.bind.JAXBException;
import java.io.*;


public class UserFilter extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String orgId;
    public static String orgKPP;
    public static String orgINN;
    public static String orgName;

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag userFilter = new UniversalRequestRootTag();
        userFilter.setC("user");
        userFilter.setT("dictionary");
        userFilter.setN("filter");
        userFilter.setV(5.0);
        userFilter.setS(AuthLogin.sessionID);

        marshalling(userFilter);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "UserFilter");
        Check.checkEnabledD2BMAdvancedService();
    }



    private void parsingDataAndSaveInBD() {

        OrganizationService orgSer = new OrganizationService();
        Organizations org = new Organizations();
        org.setId(orgId);
        org.setKpp(orgKPP);
        org.setInn(orgINN);
        org.setName(orgName);

        Divisions division;
        for (int i = 0; i < UserFilter.rootTag.getListF().size(); i++) {
            division = new Divisions();
            division.setBic(rootTag.getListF().get(i).getB());
            division.setCorrAcc(rootTag.getListF().get(i).getA());
            division.setId(rootTag.getListF().get(i).getI());
            division.setName(rootTag.getListF().get(i).getN());
            org.addDivision(division);
        }
        orgSer.saveOrUpdate(org);

        MobileServicesService ssm = new MobileServicesService();
        DivisionService ds = new DivisionService();
        MobileServices sm;
        for (int i = 0; i < rootTag.getListV().size(); i++) {
            division = ds.findDivision(rootTag.getListV().get(i).getF());
            sm = new MobileServices();
            sm.setDivision(division);
            sm.setAdv(rootTag.getListV().get(i).getAdv());
            sm.setReq(rootTag.getListV().get(i).getReq());
            ssm.saveOrUpdate(sm);
            division.setServiceMobile(sm);
            ds.merge(division);
        }
    }

    private void identificationOfOrgData() {
        orgId = rootTag.getListC().get(0).getI();
        orgKPP = rootTag.getListC().get(0).getW();
        orgINN = rootTag.getListC().get(0).getA();
        orgName = rootTag.getListC().get(0).getN();
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        if (codeStatusResponse == 200) {
            rootTag = unmarshalling();
            identificationOfOrgData();
            parsingDataAndSaveInBD();
            checkTest();
        }
    }
}

