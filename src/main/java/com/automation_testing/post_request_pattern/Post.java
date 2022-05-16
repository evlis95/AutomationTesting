package com.automation_testing.post_request_pattern;

import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.generalsettings.Settings;
import com.automation_testing.interfaces.Runnable;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.utils.JAXBUtils;
import com.automation_testing.utils.PrintDataInLogUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public abstract class Post implements Runnable {
    public static final String PATH_REQUEST_BODY = ".\\src\\main\\java\\com\\automation_testing\\xmlfile\\request.xml";
    public static String bodyResponse;
    public static UniversalResponseRootTag rootTag;
    public static HttpHeaders headers;
    public static StringBuilder rtsRequest = new StringBuilder();
    public static StringBuilder cookies = new StringBuilder();
    protected Integer codeStatusResponse;

    public static void addCookies(String cookie) {
        if (cookies.toString().equals("")) {
            cookies.append(cookie);
        } else {
            cookies.append("; ").append(cookie);
        }
    }

    public static void editRTSRequest(String str) {
        rtsRequest.append("SID=").append(str);
    }

    protected void marshalling(UniversalRequestRootTag rootTag) throws JAXBException {
        JAXBUtils.marshalling(rootTag);
    }

    protected UniversalResponseRootTag unmarshalling() throws JAXBException {
        return JAXBUtils.unmarshalling();
    }

    protected void executingRequest() throws IOException, InterruptedException {
        HttpClient HTTP_CLIENT = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .proxy(ProxySelector.of(new InetSocketAddress(Settings.HOST_PROXY, Settings.PORT_PROXY)))
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(PATH_REQUEST_BODY)))
                .uri(URI.create(Settings.URI_POST))
                .setHeader("accept-encoding", "gzip, deflate")
                .setHeader("accept-language", "ru")
                .setHeader("accept", "*/*")
                .setHeader("Content-Type", "text/xml; charset=utf-8")
                .setHeader("AppLanguage", "ru")
                .setHeader("AppVersionName", Settings.APP_VERSION_NAME)
                .setHeader("Rts-request", rtsRequest.toString())
                .setHeader("Cookie", cookies.toString())
                .setHeader("DeviceId", "097e2a18390d4111")
                .setHeader("charset", "utf-8")
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        headers = response.headers();
        bodyResponse = response.body();
        codeStatusResponse = response.statusCode();
    }

    public void run() throws JAXBException, IOException, InterruptedException {
        createXmlBodyRequest();
        executingRequest();
        checkTest();
        if (codeStatusResponse == 200) {
            rootTag = unmarshalling();
        } else {
            PrintDataInLogUtils.printReqAndRes();
        }
    }

    protected abstract void createXmlBodyRequest() throws JAXBException, IOException;

    protected abstract void checkTest() throws IOException, JAXBException;
}