package com.automation_testing.post_request_type;


import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.jaxbsettings.CustomCharacterEscapeHandler;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.generalsettings.Settings;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;


public abstract class Post {
    private final Logger LOG = LogManager.getLogger(Post.class);
    protected String bodyResponse;
    protected Integer codeStatusResponse;
    private final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .proxy(ProxySelector.of(new InetSocketAddress(Settings.hostProxy, Settings.portProxy)))
            .connectTimeout(Duration.ofSeconds(10))
            .build();


    protected void marshallSetting(UniversalRequestRootTag rootTag) throws JAXBException {
        JAXBContext jcCreate = JAXBContext.newInstance(UniversalRequestRootTag.class);
        Marshaller marshaller = jcCreate.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CustomCharacterEscapeHandler());
        marshaller.marshal(rootTag, new File(".\\src\\main\\java\\com\\automation_testing\\xmlfile\\request.xml"));
    }

    protected UniversalResponseRootTag unmarshallSetting(UniversalResponseRootTag a) throws JAXBException {
        JAXBContext jcParse = JAXBContext.newInstance(UniversalResponseRootTag.class);
        Unmarshaller unmarshall = jcParse.createUnmarshaller();
        a = (UniversalResponseRootTag) unmarshall.unmarshal(new File(".\\src\\main\\java\\com\\automation_testing\\xmlfile\\response.xml"));
        return a;
    }

    protected void writeBodyResponseInFile() {
        try (FileWriter writer = new FileWriter(".\\src\\main\\java\\com\\automation_testing\\xmlfile\\response.xml", false)) {
            writer.write(bodyResponse);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void request() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(".\\src\\main\\java\\com\\automation_testing\\xmlfile\\request.xml")))
                .uri(URI.create(Settings.uriPost))
                .setHeader("Accept-Encoding", "gzip")
                .setHeader("Content-Type", "text/xml")
                .setHeader("AppLanguage", "ru")
                .setHeader("AppVersionName", Settings.appVersionName)
                .build();

        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        //HttpHeaders headers = response.headers();
        bodyResponse = response.body();
        codeStatusResponse = response.statusCode();
    }

    public abstract void run() throws IOException, InterruptedException, JAXBException;

    protected abstract void createXmlBodyRequest() throws JAXBException, IOException;

    protected UniversalResponseRootTag parseXmlBodyResponse() throws JAXBException {
        UniversalResponseRootTag rootTag = new UniversalResponseRootTag();
        rootTag = unmarshallSetting(rootTag);
        return rootTag;
    }

    protected abstract void checkTest() throws IOException;

    protected void printReqAndResInLog() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(".\\src\\main\\java\\com\\automation_testing\\xmlfile\\request.xml"));
        StringBuilder stringBuffer = new StringBuilder("");
        String line = "";
        LOG.warn("Запрос:");
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.warn(stringBuffer.toString());

        LOG.warn("Ответ:");
        StringBuilder stringBuffer1 = new StringBuilder("");
        bufferedReader = new BufferedReader(new StringReader(bodyResponse));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer1.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.warn(stringBuffer1.toString());
    }


}

