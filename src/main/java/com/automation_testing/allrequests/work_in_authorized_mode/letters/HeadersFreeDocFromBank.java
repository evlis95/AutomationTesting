package com.automation_testing.allrequests.work_in_authorized_mode.letters;

import com.automation_testing.allrequests.authorization.AuthLogin;
import com.automation_testing.allrequests.authorization.UserFilter;
import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagAOfTagP;
import com.automation_testing.creatingxml.TagFOfTagP;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.TagCOfTagF;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeadersFreeDocFromBank extends Post {
    public static UniversalResponseRootTag rootTag;
    private String[] statusCode = new String[]{"18", "20"};

    @Override
    protected void createXmlBodyRequest() throws JAXBException, IOException {
        UniversalRequestRootTag free = new UniversalRequestRootTag();

        free.setC("headers");
        free.setT("document");
        free.setN("FreeDocFromBank");
        free.setV(1.0);
        free.setS(AuthLogin.sessionID);

        TagPOfUnivReq tagP = new TagPOfUnivReq();
        tagP.setP("0");

        TagAOfTagP tagA;
        List<TagAOfTagP> listA = new ArrayList<>();
        for(String code : statusCode) {
            tagA = new TagAOfTagP();
            tagA.setS(code);
            listA.add(tagA);
        }

        TagFOfTagP tagF = new TagFOfTagP();
        tagF.setB("");
        tagF.setE("");
        tagF.setO("0");
        tagF.setW("");
        tagF.setTagC(new TagCOfTagF(UserFilter.orgId));

        tagP.setListA(listA);
        tagP.setTagF(tagF);

        free.setTagP(tagP);

        marshalling(free);
    }

    @Override
    protected void checkTest() throws IOException, JAXBException {
        Check.checkCode200(codeStatusResponse, "HeadersFreeDocfromBank");
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        rootTag = Post.rootTag;
    }
}
