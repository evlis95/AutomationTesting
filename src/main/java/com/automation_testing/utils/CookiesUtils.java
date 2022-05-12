package com.automation_testing.utils;

import com.automation_testing.post_request_pattern.Post;

import java.util.List;

public class CookiesUtils {

    public static String initiationRTSID() {
        String rtsID = "";
        List<String> headers = Post.headers.allValues("Set-Cookie");
        String[] arr = headers.get(0).split("; ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("RTS")) {
                rtsID = arr[i];
            }
        }
        return rtsID;
    }

    public static String initiationSID() {
        String sid = "";
        List<String> headers = Post.headers.allValues("Set-Cookie");
        for (int i = 0; i < headers.size(); i++) {
            String[] arr = headers.get(i).split("; ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].indexOf("SID") == 0) {
                    sid = arr[j];
                }
            }
        }
        return sid;
    }

}
