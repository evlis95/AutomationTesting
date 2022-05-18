package com.automation_testing.utils;

import org.jetbrains.annotations.NotNull;

public class DateUtils {

    public static @NotNull String definitionCurrentTime() {
        long currentTime = System.currentTimeMillis();
        String editTime = Long.toString(currentTime);
        editTime = editTime.substring(0, 8) + "00000";
        return editTime;
    }
}
