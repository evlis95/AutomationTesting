package com.automation_testing.utils;

import com.automation_testing.post_request_pattern.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class PrintDataInLogUtils {

    private static final Logger LOG = LogManager.getLogger(PrintDataInLogUtils.class);

    public static void printReqAndRes() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Post.PATH_REQUEST_BODY));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        LOG.warn("Запрос:");
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.warn(stringBuilder.toString());
        LOG.warn("Ответ:");
        StringBuilder stringBuilder1 = new StringBuilder();
        bufferedReader = new BufferedReader(new StringReader(Post.bodyResponse));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder1.append(line).append("\n");
        }
        bufferedReader.close();
        LOG.warn(stringBuilder1.toString());
    }
}
