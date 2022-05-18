package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class PutDocDATAFORSIGN extends Post {
    public static UniversalResponseRootTag rootTag;
    private final Logger LOG = LogManager.getLogger(PutDocDATAFORSIGN.class);
    private final UniversalResponseRootTag UNIV_RES_ROOT_TAG;
    private final String DOC_ID;
    private String documentNameSP;
    private String documentUIDSP;

    public PutDocDATAFORSIGN(UniversalResponseRootTag universalResponseRootTag, String documentID) {
        this.UNIV_RES_ROOT_TAG = universalResponseRootTag;
        this.DOC_ID = documentID;
    }

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "DATAFORSIGN");
    }


    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag dataForSign = new UniversalRequestRootTag();
        TagReqActOfUnivReq tagReqAct = new TagReqActOfUnivReq();

        dataForSign.setC("put");
        dataForSign.setT("document");
        dataForSign.setN(PutDocAction.documentTypeString);
        dataForSign.setV(3.1);
        dataForSign.setS(AuthLogin.sessionID);
        dataForSign.setTagU(documentUIDSP);

        tagReqAct.setV("DATAFORSIGN");
        tagReqAct.setDocID(DOC_ID);

        dataForSign.setTagReqAct(tagReqAct);

        if (PutDocAction.documentTypeString.equals("SystemFastPay")) {
            for (int i = 0; i < UNIV_RES_ROOT_TAG.getListK().size(); i++) {
                if (UNIV_RES_ROOT_TAG.getListK().get(i).getT().equals("5") ) {
                    documentNameSP = UNIV_RES_ROOT_TAG.getListK().get(i).getP();
                    documentUIDSP = UNIV_RES_ROOT_TAG.getListK().get(i).getU();
                    dataForSign.setU(documentUIDSP);
                }
            }
        } else {
            for (int i = 0; i < UNIV_RES_ROOT_TAG.getListK().size(); i++) {
                if (UNIV_RES_ROOT_TAG.getListK().get(i).getT().equals("1") ) {
                    documentNameSP = UNIV_RES_ROOT_TAG.getListK().get(i).getP();
                    documentUIDSP = UNIV_RES_ROOT_TAG.getListK().get(i).getU();
                    dataForSign.setU(documentUIDSP);
                }
            }
        }
        marshalling(dataForSign);
    }

    private void info() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String message = "\n\nВыбрано СП: " + documentNameSP + "\n" +
                "Идентификатор: " + documentUIDSP + "\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(message));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.info(stringBuilder.toString());
    }


    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
            info();
        }
    }
}
