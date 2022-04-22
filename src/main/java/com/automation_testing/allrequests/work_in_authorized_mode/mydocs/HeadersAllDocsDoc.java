package com.automation_testing.allrequests.work_in_authorized_mode.mydocs;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.post_request_type.Post;
import com.automation_testing.creatingxml.*;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;


public class HeadersAllDocsDoc extends Post {
    private final String[] payOrdStatCode = new String[]{"1", "3", "6", "7", "8", "9", "10", "11", "12", "15", "17", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
    private final String[] canReqStatCode = new String[]{"3", "6", "7", "8", "9", "10", "11", "12", "15", "17", "39", "40", "41", "42", "43", "44"};
    private final String[] curTraStatCode = new String[]{"1", "3", "6", "8", "9", "10", "11", "12", "15", "17", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};
    private final String[] onlineCurConvStatCode = new String[]{"1", "3", "9", "10", "11", "12", "11", "12", "17", "15", "39", "42", "43", "44"};
    private final String[] corpCardStatCode = new String[]{"1", "3", "6", "8", "9", "10", "11", "12", "17", "15", "39", "42", "43", "44"};
    private final String[] docFromBankStatCode = new String[]{"6", "10", "11", "12", "17", "39", "42", "43", "44", "64", "65", "66", "67"};
    private final String[] minBalanceStatCode = new String[]{"1", "3", "6", "9", "10", "11", "12", "15", "17", "39", "42", "43", "44"};
    private final String[] credStatCode = new String[]{"1", "6", "8", "10", "11", "12", "15", "17", "39", "42", "43", "44", "68", "69", "70"};
    private final String[] depLightStatCode = new String[]{"1", "3", "6", "9", "10", "11", "12", "17", "15", "39", "42", "43", "44", "69", "70"};
    private final String[] serConnStatCode = new String[]{"1", "3", "6", "8", "9", "10", "11", "12", "17", "39", "42", "43", "44"};
    private final String[] sysFastPayQRStatCode = new String[]{"39", "42", "6", "1", "44", "11", "12", "15", "17", "10"};
    private final String[] sysFastPayStatCode = new String[]{"39", "42", "3", "1", "44", "6", "12", "15", "11", "17", "10"};
    private final String[] addAccStatCode = new String[]{"39", "10", "3", "42", "12", "6", "17", "15", "11", "9", "43", "44", "8", "71", "10"};
    /*private final String[] depAdvStatCode = new String[]{"39", "1", "3", "42", "43", "6", "44", "11", "12", "15", "17", "9", "10"};*/
    private Map<String, TagTOfTagP> mapTagT;
    private final Logger LOG = LogManager.getLogger(HeadersAllDocsDoc.class);
    private UniversalResponseRootTag rootTag;

    public UniversalResponseRootTag getRootTag() {
        return rootTag;
    }



    private void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "HeadersAllDocsDocument");
        checkAvailabilityDocPayOrdInRes();
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag headers = new UniversalRequestRootTag();

        headers.setC("headers");
        headers.setT("document");
        headers.setN("alldocs");
        headers.setV(1.0);
        headers.setS(AuthLogin.sessionID);

        List<TagFOfTagP> listF = new ArrayList<>();
        TagFOfTagP tagF = new TagFOfTagP("", "");
        listF.add(tagF);

        mapTagT = new HashMap<>();
        createRequestedDocAndStatus();
        List<TagTOfTagP> setTagT = new ArrayList<>(mapTagT.values());

        TagPOfUnivReq tagP = new TagPOfUnivReq(UserFilter.orgId, "0", setTagT, listF);

        headers.setTagP(tagP);
        marshallSetting(headers);
    }

    private void checkAvailabilityDocPayOrdInRes() {
        if (rootTag.getListDS() != null) {
            if (rootTag.getListDS().get(0).getListM() != null) {
                boolean result = false;
                for (int i = 0; i < rootTag.getListDS().get(0).getListM().get(0).getListD().size(); i++) {
                    if (rootTag.getListDS().get(0).getListM().get(0).getListD().get(i).getType().equals("PaymentOrder")) {
                        result = true;
                        break;
                    }
                }
                if (result) {
                    Check.quantityPASS++;
                   LOG.info("Проверка на наличие документов ПП в ответе на запрос HeadersAllDocsDoc - PASS\n");
                } else {
                    Check.quantityFAILED++;
                   LOG.error("Проверка на наличие документов ПП в ответе на запрос HeadersAllDocsDoc - FAILED\n");
                }
            } else {
                Check.quantityFAILED++;
               LOG.error("Проверка на наличие документов в ответе на запрос HeadersAllDocsDoc - FAILED\n");
            }
        } else {
            Check.quantityFAILED++;
           LOG.error("Проверка на наличие документов в ответе на запрос HeadersAllDocsDoc - FAILED\n");
        }
    }

    private void createRequestedDocAndStatus() {
        for (int i = 0; i < UserFilter.rootTag.getListV().size(); i++) {
            if (UserFilter.rootTag.getListV().get(i).getAdv().equals("1")) {
                addObjectInMap("PaymentOrder", payOrdStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getReq().equals("1")) {
                addObjectInMap("CancellationRequest", canReqStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getCtr().equals("1")) {
                addObjectInMap("CurTransfer", curTraStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getExch().equals("1")) {
                addObjectInMap("OnlineCurConv", onlineCurConvStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getCc().equals("1") || UserFilter.rootTag.getListV().get(i).getDcc().equals("1")) {
                addObjectInMap("CorpCardNew", corpCardStatCode);
                addObjectInMap("CorpCardBlock", corpCardStatCode);
                addObjectInMap("CorpCardReissue", corpCardStatCode);
                addObjectInMap("CorpCardUnblock", corpCardStatCode);
                addObjectInMap("CorpCardAbroadOperReq", corpCardStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getOffer().equals("1")) {
                addObjectInMap("DocFromBank", docFromBankStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getMinBalance().equals("1")) {
                addObjectInMap("MinBalance", minBalanceStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getCr().equals("1")) {
                addObjectInMap("CreditApplication", credStatCode);
                addObjectInMap("CreditTerms", credStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getDep().equals("1")) {
                addObjectInMap("NewDepositPetition", depLightStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getSm().equals("1")) {
                addObjectInMap("ServiceСonnection", serConnStatCode);
                if (UserFilter.rootTag.getListV().get(i).getListContract() != null) {
                    if (UserFilter.rootTag.getListV().get(i).getListContract().get(i).getTar().equals("1")) {
                        addObjectInMap("ServiceСonnection", serConnStatCode);
                    }
                }
            }
            if (UserFilter.rootTag.getListV().get(i).getNewqr().equals("1")) {
                addObjectInMap("SystemFastPayQR", sysFastPayQRStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getBackpay().equals("1")) {
                addObjectInMap("SystemFastPayBack", sysFastPayStatCode);
            }
            if (UserFilter.rootTag.getListV().get(i).getPaybc().equals("1")) {
                addObjectInMap("SystemFastPay", sysFastPayStatCode);
            }
           /* if (UserFilter.rootTag.getListV().get(i).getDepAdv().equals("1")) { // убрать комментарий когда появится услуга D2BM. DepAdv
                addObjectInMap("DepositPartialWithdrawal", depAdvStatCode);
                addObjectInMap("DepositProlongation", depAdvStatCode);
                addObjectInMap("DepositReplenishment", depAdvStatCode);
                addObjectInMap("DepositTermination", depAdvStatCode);
            }*/
            if (UserFilter.rootTag.getListV().get(i).getAddAcc().equals("1")) {
                addObjectInMap("AdditionalAcc", addAccStatCode);
            }


        }
    }

    private void addObjectInMap(String nameKeyAndDocType, String[] statusCode) {
        if (mapTagT.get(nameKeyAndDocType) == null) {
            TagTOfTagP tagT = new TagTOfTagP(nameKeyAndDocType);
            List<TagAOfTagT> listA = new ArrayList<>();
            for (String s : statusCode) {
                listA.add(new TagAOfTagT(s));
            }
            tagT.setListA(listA);
            mapTagT.put(nameKeyAndDocType, tagT);
        }
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
