package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.test.Division;
import com.automation_testing.test.Organization;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;


public class UserFilter extends Post {

    public static UniversalResponseRootTag rootTag;
    public static String orgId;
    public static String orgKPP;
    public static String orgINN;
    public static String orgName;
    public static ArrayList<Organization> orgList = new ArrayList<>();

    private void initiatingAcc() {

    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag userFilter = new UniversalRequestRootTag();
        userFilter.setC("user");
        userFilter.setT("dictionary");
        userFilter.setN("filter");
        userFilter.setV(4.0);
        userFilter.setS(AuthLogin.sessionID);

        marshalling(userFilter);
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "UserFilter");
    }

    private void identificationOfOrgData() {
        orgId = rootTag.getListC().get(0).getI();
        orgKPP = rootTag.getListC().get(0).getW();
        orgINN = rootTag.getListC().get(0).getA();
        orgName = rootTag.getListC().get(0).getN();
    }

    private void test() {
        ArrayList<Division> divList = new ArrayList<>();
        Organization org;
        Division div;
        for (int i = 0; i < rootTag.getListC().size(); i++) {
            org = new Organization();
            org.setId(rootTag.getListC().get(i).getI());
            org.setN(rootTag.getListC().get(i).getN());
            org.setA(rootTag.getListC().get(i).getA());
            org.setM(rootTag.getListC().get(i).getM());
            org.setQ(rootTag.getListC().get(i).getQ());
            org.setW(rootTag.getListC().get(i).getW());
            org.setE(rootTag.getListC().get(i).getE());
            org.setR(rootTag.getListC().get(i).getR());
            org.setT(rootTag.getListC().get(i).getT());
            org.setY(rootTag.getListC().get(i).getY());
            org.setU(rootTag.getListC().get(i).getU());
            org.setZku(rootTag.getListC().get(i).getZku());
            org.setCr(rootTag.getListC().get(i).getCr());
            org.setLi(rootTag.getListC().get(i).getLi());
            org.setLp(rootTag.getListC().get(i).getLp());
            org.setSv(rootTag.getListC().get(i).getSv());
            org.setPh(rootTag.getListC().get(i).getPh());
            org.setCc(rootTag.getListC().get(i).getCc());
            org.setAs(rootTag.getListC().get(i).getAs());
            org.setAa(rootTag.getListC().get(i).getAa());
            org.setOu(rootTag.getListC().get(i).getOu());
            org.setIdsbp(rootTag.getListC().get(i).getIdsbp());
            org.setPas(rootTag.getListC().get(i).getPas());
            org.setTb(rootTag.getListC().get(i).getTb());
            org.setFb(rootTag.getListC().get(i).getFb());
            org.setCt(rootTag.getListC().get(i).getCt());
            org.setSbp(rootTag.getListC().get(i).getSbp());
            orgList.add(org);
        }

        for (int i = 0; i < rootTag.getListF().size(); i++) {
            div = new Division();
            div.setId(rootTag.getListF().get(i).getI());
            div.setN(rootTag.getListF().get(i).getN());
            div.setM(rootTag.getListF().get(i).getM());
            div.setB(rootTag.getListF().get(i).getB());
            div.setP(rootTag.getListF().get(i).getP());
            div.setGbn(rootTag.getListF().get(i).getGbn());
            div.setC(rootTag.getListF().get(i).getC());
            div.setA(rootTag.getListF().get(i).getA());
            div.setD(rootTag.getListF().get(i).getD());
            div.setG(rootTag.getListF().get(i).getG());
            div.setQ(rootTag.getListF().get(i).getQ());
            div.setS(rootTag.getListF().get(i).getS());
            div.setZ(rootTag.getListF().get(i).getZ());
            div.setX(rootTag.getListF().get(i).getX());
            div.setW(rootTag.getListF().get(i).getW());
            div.setU(rootTag.getListF().get(i).getU());
            div.setE(rootTag.getListF().get(i).getE());
            div.setR(rootTag.getListF().get(i).getR());
            div.setDt(rootTag.getListF().get(i).getDt());
            divList.add(div);
        }

        for (int i = 0; i < rootTag.getListV().size(); i++) {
            for (int j = 0; j < orgList.size(); j++) {
                if (rootTag.getListV().get(i).getC().equals(orgList.get(j).getId())) {
                    for (int k = 0; k < divList.size(); k++) {
                        if (rootTag.getListV().get(i).getF().equals(divList.get(k).getId())) {
                            orgList.get(j).addDivision(divList.get(k));
                        }
                    }
                }
            }
        }

    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        executingRequest();
        if (codeStatusResponse == 200) {
            rootTag = unmarshalling();
            identificationOfOrgData();
            checkTest();
            test();
        }
    }
}

