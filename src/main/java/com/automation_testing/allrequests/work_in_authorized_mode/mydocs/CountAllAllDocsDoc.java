package com.automation_testing.allrequests.work_in_authorized_mode.mydocs;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.post_request_type.Post;
import com.automation_testing.creatingxml.TagFOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.TagTOfTagP;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountAllAllDocsDoc extends Post {
    private final static Logger log = LogManager.getLogger(CountAllAllDocsDoc.class);
    private int tagTQuantity;
    public static UniversalResponseRootTag rootTag;


    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "CountAllAllDocsDocument");
        if (rootTag.getListD() != null) {
            if (tagTQuantity == rootTag.getListD().size()) {
                log.info("Проверка количества пришедших типов документов в ответе на запрос CountAllAllDocsDoc, в зависимости от тех, которые ушли в запросе - PASS\n");
                Check.quantityPASS++;
            } else {
                log.error("Проверка количества пришедших типов документов в ответе на запрос CountAllAllDocsDoc, в зависимости от тех, которые ушли в запросе - FAILED\n");
                Check.quantityFAILED++;
            }
        }
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag countAll = new UniversalRequestRootTag();
        Set<TagTOfTagP> setTOfTagP = new HashSet<>();
        List<TagFOfTagP> listFOfTagP = new ArrayList<>();
        TagFOfTagP tagF = new TagFOfTagP();

        countAll.setC("countall");
        countAll.setT("document");
        countAll.setN("alldocs");
        countAll.setV(1.0);
        countAll.setS(AuthLogin.sessionID);

        tagF.setG(UserFilter.rootTag.getListC().get(0).getI());
        listFOfTagP.add(tagF);

        for (int i = 0; i < UserFilter.rootTag.getListV().size(); i++) {
            if (UserFilter.rootTag.getListV().get(i).getAdv().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("PaymentOrder"));
            }
            if (UserFilter.rootTag.getListV().get(i).getReq().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("CancellationRequest"));
            }
            if (UserFilter.rootTag.getListV().get(i).getDcc().equals("1") || UserFilter.rootTag.getListV().get(i).getCc().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("CorpCardNew"));
                setTOfTagP.add(new TagTOfTagP("CorpCardBlock"));
                setTOfTagP.add(new TagTOfTagP("CorpCardUnblock"));
                setTOfTagP.add(new TagTOfTagP("CorpCardReissue"));
                setTOfTagP.add(new TagTOfTagP("CorpCardAbroadOperReq"));

            }
            if (UserFilter.rootTag.getListV().get(i).getExch().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("OnlineCurConv"));
            }
            if (UserFilter.rootTag.getListV().get(i).getCtr().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("CurTransfer"));
            }
            if (UserFilter.rootTag.getListV().get(i).getMinBalance().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("MinBalance"));
            }
            if (UserFilter.rootTag.getListV().get(i).getAddAcc().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("AdditionalAcc"));
            }
            if (UserFilter.rootTag.getListV().get(i).getOffer().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("DocFromBank"));
            }
            if (UserFilter.rootTag.getListV().get(i).getBackpay().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("SystemFastPayBack"));
            }
            if (UserFilter.rootTag.getListV().get(i).getPaybc().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("SystemFastPay"));
            }
            if (UserFilter.rootTag.getListV().get(i).getNewqr().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("SystemFastPayQR"));
            }
            if (UserFilter.rootTag.getListV().get(i).getDep().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("NewDepositPetition"));
            }
            if (UserFilter.rootTag.getListV().get(i).getCr().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("CreditApplication "));
                setTOfTagP.add(new TagTOfTagP("CreditTerms"));
            }
            /*if (UserFilter.rootTag.getListV().get(i).getDepAdv().equals("1")) { // убрать комментарий когда запилят услугу D2BM. depAdv
                setTOfTagP.add(new TagTOfTagP("DepositPartialWithdrawal"));
                setTOfTagP.add(new TagTOfTagP("DepositProlongation"));
                setTOfTagP.add(new TagTOfTagP("DepositReplenishment"));
                setTOfTagP.add(new TagTOfTagP("DepositTermination"));
            }*/
            if (UserFilter.rootTag.getListV().get(i).getSm().equals("1")) {
                setTOfTagP.add(new TagTOfTagP("ServiceСonnection"));
                if (UserFilter.rootTag.getListV().get(i).getListContract() != null) {
                    if (UserFilter.rootTag.getListV().get(i).getListContract().get(i).getTariff().equals("1")) {
                        setTOfTagP.add(new TagTOfTagP("ServiceСonnection"));
                    }
                }
            }
            tagTQuantity = setTOfTagP.size();
        }
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setListF(listFOfTagP);
        List<TagTOfTagP> listTOfTagP = new ArrayList<>(setTOfTagP);
        tagP.setListT(listTOfTagP);
        countAll.setTagP(tagP);
        marshallSetting(countAll);
    }

    @Override
    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            checkTest();
        } else {
            failedResponseMessage();
        }
    }
}
