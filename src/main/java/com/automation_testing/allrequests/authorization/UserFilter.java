package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.hibernate.dao.DivisionsDAO;
import com.automation_testing.hibernate.dao.MobileServicesDAO;
import com.automation_testing.hibernate.dao.OrganizationsDAO;
import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Divisions;
import com.automation_testing.hibernate.pojo.MobileServices;
import com.automation_testing.hibernate.pojo.Organizations;
import com.automation_testing.parsingxml.TagCOfTagUnivRes;
import com.automation_testing.parsingxml.TagFOfTagUnivRes;
import com.automation_testing.parsingxml.TagVOfTagUnivRes;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.utils.ActivServicesAllDivision;

import javax.xml.bind.JAXBException;
import java.io.IOException;


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
    }


    private void parsingDataAndSaveInBD() {

        CRUDable<Organizations> orgService = new OrganizationsDAO();
        Organizations org = new Organizations();
        org.setId(orgId);
        org.setKpp(orgKPP);
        org.setInn(orgINN);
        org.setName(orgName);

        Divisions division;

        for (TagFOfTagUnivRes tagF : rootTag.getListF()) {
            division = new Divisions();
            division.setBic(tagF.getB());
            division.setCorrAcc(tagF.getA());
            division.setId(tagF.getI());
            division.setName(tagF.getN());
            org.addDivision(division);
        }
        orgService.saveOrUpdate(org);


        CRUDable<MobileServices> service = new MobileServicesDAO();
        CRUDable<Divisions> divServices = new DivisionsDAO();

        MobileServices mobileService;

        for (TagVOfTagUnivRes tagV : rootTag.getListV()) {
            division = divServices.findById(tagV.getF());
            mobileService = new MobileServices();
            mobileService.setDivision(division);
            mobileService.setAdv(tagV.getAdv());
            mobileService.setReq(tagV.getReq());
            service.saveOrUpdate(mobileService);
            division.setServiceMobile(mobileService);
            divServices.merge(division);
        }
    }

    private void identificationOfOrgData() {
        TagCOfTagUnivRes orgData = rootTag.getListC().get(0);
        orgId = orgData.getI();
        orgKPP = orgData.getW();
        orgINN = orgData.getA();
        orgName = orgData.getN();
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
            ActivServicesAllDivision.definition();
        }
    }
}

