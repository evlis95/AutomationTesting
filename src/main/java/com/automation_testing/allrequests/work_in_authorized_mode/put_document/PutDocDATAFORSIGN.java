package com.automation_testing.allrequests.work_in_authorized_mode.put_document;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagReqActOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_type.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class PutDocDATAFORSIGN extends Post {
    private final Logger LOG = LogManager.getLogger(PutDocDATAFORSIGN.class);
    private final UniversalResponseRootTag universalResponseRootTag;
    private final String documentID;
    private String documentNameSP;
    private String documentUIDSP;
    public static UniversalResponseRootTag rootTag;

    public PutDocDATAFORSIGN(UniversalResponseRootTag universalResponseRootTag, String documentID) {
        this.universalResponseRootTag = universalResponseRootTag;
        this.documentID = documentID;
    }

    protected void checkTest() throws IOException {
        Check.checkCode200(getCodeStatusResponse(), "DATAFORSIGN");
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
        tagReqAct.setDocID(documentID);

        dataForSign.setTagReqAct(tagReqAct);

        for (int i = 0; i < universalResponseRootTag.getListK().size(); i++) {
            if (universalResponseRootTag.getListK().get(i).getT().equals("1")) {
                documentNameSP = universalResponseRootTag.getListK().get(i).getP();
                documentUIDSP = universalResponseRootTag.getListK().get(i).getU();
                dataForSign.setU(documentUIDSP);
            }
        }
        marshallSetting(dataForSign);
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


    public void run() throws IOException, InterruptedException, JAXBException {
        createXmlBodyRequest();
        request();
        writeBodyResponseInFile();
        printReqAndResInLog();
        checkTest();
        if (getCodeStatusResponse() == 200) {
            rootTag = parseXmlBodyResponse();
            info();
        }
    }


}
