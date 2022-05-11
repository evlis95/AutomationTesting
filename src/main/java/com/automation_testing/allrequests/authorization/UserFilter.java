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

    private final Logger LOG = LogManager.getLogger(UserFilter.class);
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

    public void info() throws IOException {

        StringBuilder sb = new StringBuilder();
        ////
        //организации
        sb.append("\n\nКоличество организаций пользователя - " + rootTag.getListC().size() + "\n");
        sb.append("Организация пользователя - " + rootTag.getListC().get(0).getN() + " идентификатор - " + rootTag.getListC().get(0).getI() + "\n");

        //подразделения
        sb.append("Количество подразделений - " + rootTag.getListF().size() + "\n");
        if (rootTag.getListF().size() == 1) {
            sb.append("Наименование подразделения: " + rootTag.getListF().get(0).getN() + " идентификатор - " + rootTag.getListF().get(0).getI() + "\n");
            sb.append("Подключенные услуги: \n");
            if (rootTag.getListV().get(0).getAdv().equals("1")) {
                sb.append("D2BM. Advanced\n");
            }
            if (rootTag.getListV().get(0).getReq().equals("1")) {
                sb.append("D2BM. Запрос на отзыв\n");
            }
            if (rootTag.getListV().get(0).getInfo().equals("1")) {
                sb.append("D2BM. Info\n");
            }
            if (rootTag.getListV().get(0).getPc().equals("1")) {
                sb.append("D2BM. PayControl\n");
            }
            if (rootTag.getListV().get(0).getPush().equals("1")) {
                sb.append("D2BM. Push\n");

            }
            if (rootTag.getListV().get(0).getPh().equals("1")) {
                sb.append("D2BM. Фотоплатеж\n");
            }
            if (rootTag.getListV().get(0).getSv().equals("1")) {
                sb.append("D2BM. Проверка контрагента\n");
            }
            if (rootTag.getListV().get(0).getCc().equals("1")) {
                sb.append("D2BM. Корпоративные карты\n");
            }
            if (rootTag.getListV().get(0).getBn().equals("1")) {
                sb.append("D2BM. Канал продаж\n");
            }
            if (rootTag.getListV().get(0).getDep().equals("1")) {
                sb.append("D2BM. Депозиты\n");
            }
            if (rootTag.getListV().get(0).getCr().equals("1")) {
                sb.append("D2BM. Кредиты\n");
            }
            if (rootTag.getListV().get(0).getAddAcc().equals("1")) {
                sb.append("D2BM. Заявка на открытие счета\n");
            }
            if (rootTag.getListV().get(0).getOffer().equals("1")) {
                sb.append("D2BM. Документы из банка\n");
            }
            if (rootTag.getListV().get(0).getSm().equals("1")) {
                sb.append("D2BM. Управление услугами\n");
            }
            if (rootTag.getListV().get(0).getDcc().equals("1")) {
                sb.append("D2BM. Цифровые карты\n");
            }
            if (rootTag.getListV().get(0).getAPay().equals("1")) {
                sb.append("D2BM. Apple Pay\n");
            }
            if (rootTag.getListV().get(0).getGPay().equals("1")) {
                sb.append("D2BM. Google Pay\n");
            }
            if (rootTag.getListV().get(0).getSPay().equals("1")) {
                sb.append("D2BM. Samsung Pay\n");
            }
            if (rootTag.getListV().get(0).getWarn().equals("1")) {
                sb.append("D2BM. Ограничения и картотеки\n");
            }
            if (rootTag.getListV().get(0).getDocflow().equals("1")) {
                sb.append("D2BM. Документооборот\n");
            }
            if (rootTag.getListV().get(0).getDtb().equals("1")) {
                sb.append("D2BM. Письма в банк\n");
            }
            if (rootTag.getListV().get(0).getDfb().equals("1")) {
                sb.append("D2BM. Письма в банк\n");
            }
            if (rootTag.getListV().get(0).getCtr().equals("1")) {
                sb.append("D2BM. Валютный перевод\n");
            }
            if (rootTag.getListV().get(0).getCurracc().equals("1")) {
                sb.append("D2BM. Отображение информации по валютным счетам\n");
            }
            if (rootTag.getListV().get(0).getExch().equals("1")) {
                sb.append("D2BM. Обмен валюты\n");
            }
            if (rootTag.getListV().get(0).getNewqr().equals("1")) {
                sb.append("D2BM. Генерация QR\n");
            }
            if (rootTag.getListV().get(0).getPaybc().equals("1")) {
                sb.append("D2BM. Переводы СБП\n");
            }
            if (rootTag.getListV().get(0).getBackpay().equals("1")) {
                sb.append("D2BM. Возвраты СБП\n");
            }
            if (rootTag.getListV().get(0).getMinBalance().equals("1")) {
                sb.append("D2BM. НСО\n");
            }
        } else {
            for (int i = 1; i < rootTag.getListF().size() + 1; i++) {
                String line = String.format("Наименование %s подразделения: " + rootTag.getListF().get(i - 1).getN() + " идентификатор - " + rootTag.getListF().get(i - 1).getI(), i);
                sb.append(line + "\n");
                sb.append("Подключенные услуги :\n");
                for (int j = 0; j < rootTag.getListF().size(); j++) {

                    if (rootTag.getListF().get(i - 1).getI().equals(rootTag.getListV().get(j).getF())) {
                        if (rootTag.getListV().get(j).getAdv().equals("1")) {
                            sb.append("D2BM. Advanced\n");
                        }
                        if (rootTag.getListV().get(j).getReq().equals("1")) {
                            sb.append("D2BM. Запрос на отзыв\n");
                        }
                        if (rootTag.getListV().get(j).getInfo().equals("1")) {
                            sb.append("D2BM. Info\n");
                        }
                        if (rootTag.getListV().get(j).getPc().equals("1")) {
                            sb.append("D2BM. PayControl\n");
                        }
                        if (rootTag.getListV().get(j).getPush().equals("1")) {
                            sb.append("D2BM. Push\n");

                        }
                        if (rootTag.getListV().get(j).getPh().equals("1")) {
                            sb.append("D2BM. Фотоплатеж\n");
                        }
                        if (rootTag.getListV().get(j).getSv().equals("1")) {
                            sb.append("D2BM. Проверка контрагента\n");
                        }
                        if (rootTag.getListV().get(j).getCc().equals("1")) {
                            sb.append("D2BM. Корпоративные карты\n");
                        }
                        if (rootTag.getListV().get(j).getBn().equals("1")) {
                            sb.append("D2BM. Канал продаж\n");
                        }
                        if (rootTag.getListV().get(j).getDep().equals("1")) {
                            sb.append("D2BM. Депозиты\n");
                        }
                        if (rootTag.getListV().get(j).getCr().equals("1")) {
                            sb.append("D2BM. Кредиты\n");
                        }
                        if (rootTag.getListV().get(j).getAddAcc().equals("1")) {
                            sb.append("D2BM. Заявка на открытие счета\n");
                        }
                        if (rootTag.getListV().get(j).getOffer().equals("1")) {
                            sb.append("D2BM. Документы из банка\n");
                        }
                        if (rootTag.getListV().get(j).getSm().equals("1")) {
                            sb.append("D2BM. Управление услугами\n");
                        }
                        if (rootTag.getListV().get(j).getDcc().equals("1")) {
                            sb.append("D2BM. Цифровые карты\n");
                        }
                        if (rootTag.getListV().get(j).getAPay().equals("1")) {
                            sb.append("D2BM. Apple Pay\n");
                        }
                        if (rootTag.getListV().get(j).getGPay().equals("1")) {
                            sb.append("D2BM. Google Pay\n");
                        }
                        if (rootTag.getListV().get(j).getSPay().equals("1")) {
                            sb.append("D2BM. Samsung Pay\n");
                        }
                        if (rootTag.getListV().get(j).getWarn().equals("1")) {
                            sb.append("D2BM. Ограничения и картотеки\n");
                        }
                        if (rootTag.getListV().get(j).getDocflow().equals("1")) {
                            sb.append("D2BM. Документооборот\n");
                        }
                        if (rootTag.getListV().get(j).getDtb().equals("1")) {
                            sb.append("D2BM. Письма в банк\n");
                        }
                        if (rootTag.getListV().get(j).getDfb().equals("1")) {
                            sb.append("D2BM. Письма из банка\n");
                        }
                        if (rootTag.getListV().get(j).getCtr().equals("1")) {
                            sb.append("D2BM. Валютный перевод\n");
                        }
                        if (rootTag.getListV().get(j).getCurracc().equals("1")) {
                            sb.append("D2BM. Отображение информации по валютным счетам\n");
                        }
                        if (rootTag.getListV().get(j).getExch().equals("1")) {
                            sb.append("D2BM. Обмен валюты\n");
                        }
                        if (rootTag.getListV().get(j).getNewqr().equals("1")) {
                            sb.append("D2BM. Генерация QR\n");
                        }
                        if (rootTag.getListV().get(j).getPaybc().equals("1")) {
                            sb.append("D2BM. Переводы СБП\n");
                        }
                        if (rootTag.getListV().get(j).getBackpay().equals("1")) {
                            sb.append("D2BM. Возвраты СБП\n");
                        }
                        if (rootTag.getListV().get(j).getMinBalance().equals("1")) {
                            sb.append("D2BM. НСО\n");
                        }
                    }
                }
            }
        }
        LOG.info(sb.toString());
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
            info();
        }
    }
}

