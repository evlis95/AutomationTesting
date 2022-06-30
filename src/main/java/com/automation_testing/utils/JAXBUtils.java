package com.automation_testing.utils;

import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.jaxbsettings.CustomCharacterEscapeHandler;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class JAXBUtils {

    public static void marshalling(UniversalRequestRootTag rootTag) throws JAXBException {
        JAXBContext jcCreate = JAXBContext.newInstance(UniversalRequestRootTag.class);
        Marshaller marshaller = jcCreate.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CustomCharacterEscapeHandler());
        marshaller.marshal(rootTag, new File(Post.PATH_REQUEST_BODY));
    }

    public static UniversalResponseRootTag unmarshalling() throws JAXBException {
        JAXBContext jcParse = JAXBContext.newInstance(UniversalResponseRootTag.class);
        Unmarshaller unmarshall = jcParse.createUnmarshaller();
        return (UniversalResponseRootTag) unmarshall.unmarshal(new StringReader(Post.bodyResponse));
    }
}
