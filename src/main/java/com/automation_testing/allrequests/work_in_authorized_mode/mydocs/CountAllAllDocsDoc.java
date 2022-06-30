package com.automation_testing.allrequests.work_in_authorized_mode.mydocs;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagFOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagTOfTagP;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.utils.ActivServicesAllDivision;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountAllAllDocsDoc extends Post {
    public static UniversalResponseRootTag rootTag;
    private final Logger LOG = LogManager.getLogger(CountAllAllDocsDoc.class);
    private int tagTQuantity;


    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "CountAllAllDocsDocument");

    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag countAll = new UniversalRequestRootTag();

        Set<TagTOfTagP> listT = new HashSet<>();
        List<TagFOfTagP> listFOfTagP = new ArrayList<>();
        TagFOfTagP tagF = new TagFOfTagP();

        countAll.setC("countall");
        countAll.setT("document");
        countAll.setN("alldocs");
        countAll.setV(1.0);
        countAll.setS(AuthLogin.sessionID);

        tagF.setG(UserFilter.rootTag.getListC().get(0).getI());
        listFOfTagP.add(tagF);


        if (ActivServicesAllDivision.adv) {
            listT.add(new TagTOfTagP("PaymentOrder"));
        }
        if (ActivServicesAllDivision.req) {
            listT.add(new TagTOfTagP("CancellationRequest"));
        }
        if (ActivServicesAllDivision.cc_dcc) {
            listT.add(new TagTOfTagP("CorpCardNew"));
            listT.add(new TagTOfTagP("CorpCardBlock"));
            listT.add(new TagTOfTagP("CorpCardUnblock"));
            listT.add(new TagTOfTagP("CorpCardReissue"));
            listT.add(new TagTOfTagP("CorpCardAbroadOperReq"));
        }
        if (ActivServicesAllDivision.exch) {
            listT.add(new TagTOfTagP("OnlineCurConv"));
        }
        if (ActivServicesAllDivision.ctr) {
            listT.add(new TagTOfTagP("CurTransfer"));
        }
        if (ActivServicesAllDivision.minBalance) {
            listT.add(new TagTOfTagP("MinBalance"));
        }
        if (ActivServicesAllDivision.addAcc) {
            listT.add(new TagTOfTagP("AdditionalAcc"));
        }
        if (ActivServicesAllDivision.offer) {
            listT.add(new TagTOfTagP("DocFromBank"));
        }
        if (ActivServicesAllDivision.backPay) {
            listT.add(new TagTOfTagP("SystemFastPayBack"));
        }
        if (ActivServicesAllDivision.payBC) {
            listT.add(new TagTOfTagP("SystemFastPay"));
        }
        if (ActivServicesAllDivision.newQR) {
            listT.add(new TagTOfTagP("SystemFastPayQR"));
        }
        if (ActivServicesAllDivision.dep) {
            listT.add(new TagTOfTagP("NewDepositPetition"));
        }
        ///Необходимо уточнить при каких дополнительных условиях с сервера должны приходить данные количество доков по данным типам
        /*if (ActivServicesAllDivision.cR) {
            listT.add(new TagTOfTagP("CreditApplication "));
            listT.add(new TagTOfTagP("CreditTerms"));
        }*/
        /*if (ActivServicesAllDivision.sM) {
            listT.add(new TagTOfTagP("ServiceСonnection"));
        }*/
        tagTQuantity = listT.size();


        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setListF(listFOfTagP);
        List<TagTOfTagP> listTOfTagP = new ArrayList<>(listT);
        tagP.setListT(listTOfTagP);
        countAll.setTagP(tagP);

        marshalling(countAll);
    }


    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            if (rootTag.getListD() != null) {
                if (tagTQuantity == rootTag.getListD().size()) {
                    LOG.info("Проверка количества пришедших типов документов в ответе на запрос CountAllAllDocsDoc, в зависимости от тех, которые ушли в запросе - PASS");
                    Check.quantityPASS++;
                } else {
                    LOG.error("Проверка количества пришедших типов документов в ответе на запрос CountAllAllDocsDoc, в зависимости от тех, которые ушли в запросе - FAILED");
                    Check.quantityFAILED++;
                }
            }
        }
    }
}
