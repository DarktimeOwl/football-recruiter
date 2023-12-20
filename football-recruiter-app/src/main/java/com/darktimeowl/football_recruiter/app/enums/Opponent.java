package com.darktimeowl.football_recruiter.app.enums;

import java.util.stream.Stream;

public sealed interface Opponent permits School, FCS {
    String schoolName();
    String nickName();
    String fullName();
    boolean isRival(School school);

    static Stream<Opponent> streamAll() {
        return Stream.concat(School.streamAll(), FCS.streamAll());
    }
}