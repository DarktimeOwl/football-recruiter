package com.darktimeowl.football_recruiter.app.enums;

import java.util.Arrays;
import java.util.stream.Stream;

public enum FCS implements Opponent {
    EAST("FCS East", "Howlers"),
    WEST("FCS West", "Fusion"),
    NORTHWEST("FCS Northwest", "Predators"),
    MIDWEST("FCS Midwest", "Tuskers"),
    SOUTHEAST("FCS Southeast", "Pirates");

    private final String schoolName;
    private final String nickname;
    private final String fullName;

    FCS(String schoolName, String nickname) {
        this.schoolName = schoolName;
        this.nickname = nickname;
        this.fullName = String.format("%s %s", schoolName, nickname);
    }

    @Override
    public String schoolName() {
        return schoolName;
    }

    @Override
    public String nickName() {
        return nickname;
    }

    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public boolean isRival(School school) {
        return false;
    }

    public static Stream<FCS> streamAll() {
        return Arrays.stream(values());
    }
}