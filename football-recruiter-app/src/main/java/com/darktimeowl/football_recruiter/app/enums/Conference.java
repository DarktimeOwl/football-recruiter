package com.darktimeowl.football_recruiter.app.enums;

import com.darktimeowl.football_recruiter.app.utils.ConferenceLookup;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Stream;

public enum Conference {
    ACC("ACC"),
    AMERICAN("American"),
    BIG_12("Big XII"),
    BIG_TEN("Big Ten"),
    C_USA("C-USA"),
    INDEPENDENT("Independent"),
    MAC("MAC"),
    MWC("Mountain West"),
    PAC_12("Pac-12"),
    SEC("SEC"),
    SUN_BELT("Sun Belt");

    private final String displayName;

    Conference(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    public EnumSet<School> defaultSchools() {
        return ConferenceLookup.defaultSchools(this);
    }

    public static Stream<Conference> streamAll() {
        return Arrays.stream(values());
    }
}