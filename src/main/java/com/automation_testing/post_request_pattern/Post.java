package com.automation_testing.post_request_pattern;

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
            .proxy(ProxySelector.of(new InetSocketAddress(Settings.HOST_PROXY, Settings.PORT_PROXY)))
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    private final String PATH_RESPONSE_BODY = ".\\src\\main\\java\\com\\automation_testing\\xmlfile\\response.xml";
    private final String PATH_REQUEST_BODY = ".\\src\\main\\java\\com\\automation_testing\\xmlfile\\request.xml";

    protected void marshallSetting(UniversalRequestRootTag rootTag) throws JAXBException {
        JAXBContext jcCreate = JAXBContext.newInstance(UniversalRequestRootTag.class);
        Marshaller marshaller = jcCreate.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CustomCharacterEscapeHandler());
        marshaller.marshal(rootTag, new File(PATH_REQUEST_BODY));
    }

    protected UniversalResponseRootTag parsingResponseBody() throws JAXBException {
        JAXBContext jcParse = JAXBContext.newInstance(UniversalResponseRootTag.class);
        Unmarshaller unmarshall = jcParse.createUnmarshaller();
        return (UniversalResponseRootTag) unmarshall.unmarshal(new File(PATH_RESPONSE_BODY));
    }

    protected void writeBodyResponseInFile() {
        try (FileWriter writer = new FileWriter(PATH_RESPONSE_BODY, false)) {
            writer.write(bodyResponse);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void executingRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(PATH_REQUEST_BODY)))
                .uri(URI.create(Settings.URI_POST))
                .setHeader("Accept-Encoding", "gzip")
                .setHeader("Content-Type", "text/xml")
                .setHeader("AppLanguage", "ru")
                .setHeader("AppVersionName", Settings.APP_VERSION_NAME)
                .build();

        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        //HttpHeaders headers = response.headers();
        bodyResponse = response.body();
        codeStatusResponse = response.statusCode();
    }

    public abstract void run() throws IOException, InterruptedException, JAXBException;

    protected abstract void createXmlBodyRequest() throws JAXBException, IOException;

    protected abstract void checkTest() throws IOException;

    protected void printReqAndResInLog() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_REQUEST_BODY));
        StringBuilder stringBuffer = new StringBuilder();
        String line;
        LOG.warn("Запрос:");
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.warn(stringBuffer.toString());
        LOG.warn("Ответ:");
        StringBuilder stringBuffer1 = new StringBuilder();
        bufferedReader = new BufferedReader(new StringReader(bodyResponse));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer1.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.warn(stringBuffer1.toString());
    }
}