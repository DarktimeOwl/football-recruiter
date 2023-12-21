package com.darktimeowl.football_recruiter.app.enums;

import java.util.Arrays;
import java.util.stream.Stream;

public enum WeekType {
    HOME("Home"),
    AWAY("Away"),
    BYE("BYE");

    private final String displayName;

    WeekType(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    public static Stream<WeekType> streamAll() {
        return Arrays.stream(values());
    }
}