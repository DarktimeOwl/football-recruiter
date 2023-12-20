package com.darktimeowl.football_recruiter.app.utils;

import com.darktimeowl.football_recruiter.app.enums.Conference;
import com.darktimeowl.football_recruiter.app.enums.School;

import java.util.*;

import static com.darktimeowl.football_recruiter.app.enums.Conference.*;
import static com.darktimeowl.football_recruiter.app.enums.School.*;

public class ConferenceLookup {
    private static final Map<School, Conference> schoolConference;
    private static final Map<Conference, Set<School>> conferenceSchools;

    static {
        schoolConference = new EnumMap<>(School.class);
        conferenceSchools = new EnumMap<>(Conference.class);
        Arrays.stream(Conference.values())
                .forEach(conference -> conferenceSchools.put(conference, EnumSet.noneOf(School.class)));
        initializeConferences();
    }

    public static Conference defaultConference(School school) {
        return schoolConference.get(school);
    }

    public static EnumSet<School> defaultSchools(Conference conference) {
        return EnumSet.copyOf(conferenceSchools.get(conference));
    }

    private static void add(Conference conference, School school) {
        conferenceSchools.get(conference).add(school);
        schoolConference.put(school, conference);
    }

    private static void initializeConferences() {
        add(ACC, BOSTON_COLLEGE);
        add(ACC, CLEMSON);
        add(ACC, DUKE);
        add(ACC, FLORIDA_STATE);
        add(ACC, GEORGIA_TECH);
        add(ACC, MARYLAND);
        add(ACC, MIAMI_FL);
        add(ACC, NC_STATE);
        add(ACC, NORTH_CAROLINA);
        add(ACC, PITT);
        add(ACC, SYRACUSE);
        add(ACC, VIRGINIA);
        add(ACC, VIRGINIA_TECH);
        add(ACC, WAKE_FOREST);

        add(AMERICAN, CINCINNATI);
        add(AMERICAN, CONNECTICUT);
        add(AMERICAN, HOUSTON);
        add(AMERICAN, LOUISVILLE);
        add(AMERICAN, MEMPHIS);
        add(AMERICAN, RUTGERS);
        add(AMERICAN, SMU);
        add(AMERICAN, TEMPLE);
        add(AMERICAN, UCF);
        add(AMERICAN, USF);

        add(BIG_12, BAYLOR);
        add(BIG_12, IOWA_STATE);
        add(BIG_12, KANSAS);
        add(BIG_12, KANSAS_STATE);
        add(BIG_12, OKLAHOMA);
        add(BIG_12, OKLAHOMA_STATE);
        add(BIG_12, TCU);
        add(BIG_12, TEXAS);
        add(BIG_12, TEXAS_TECH);
        add(BIG_12, WEST_VIRGINIA);

        add(BIG_TEN, ILLINOIS);
        add(BIG_TEN, INDIANA);
        add(BIG_TEN, IOWA);
        add(BIG_TEN, MICHIGAN);
        add(BIG_TEN, MICHIGAN_STATE);
        add(BIG_TEN, MINNESOTA);
        add(BIG_TEN, NEBRASKA);
        add(BIG_TEN, NORTHWESTERN);
        add(BIG_TEN, OHIO_STATE);
        add(BIG_TEN, PENN_STATE);
        add(BIG_TEN, PURDUE);
        add(BIG_TEN, WISCONSIN);

        add(C_USA, ECU);
        add(C_USA, FIU);
        add(C_USA, FLORIDA_ATLANTIC);
        add(C_USA, LA_TECH);
        add(C_USA, MARSHALL);
        add(C_USA, MID_TENN_STATE);
        add(C_USA, NORTH_TEXAS);
        add(C_USA, RICE);
        add(C_USA, SOUTHERN_MISS);
        add(C_USA, TULANE);
        add(C_USA, TULSA);
        add(C_USA, UAB);
        add(C_USA, UTEP);
        add(C_USA, UTSA);

        schoolConference.put(ARMY, INDEPENDENT);
        schoolConference.put(BYU, INDEPENDENT);
        schoolConference.put(IDAHO, INDEPENDENT);
        schoolConference.put(NAVY, INDEPENDENT);
        schoolConference.put(NEW_MEXICO_STATE, INDEPENDENT);
        schoolConference.put(NOTRE_DAME, INDEPENDENT);
        schoolConference.put(OLD_DOMINION, INDEPENDENT);

        add(MAC, AKRON);
        add(MAC, BALL_STATE);
        add(MAC, BOWLING_GREEN);
        add(MAC, BUFFALO);
        add(MAC, CENTRAL_MICHIGAN);
        add(MAC, EASTERN_MICHIGAN);
        add(MAC, KENT_STATE);
        add(MAC, MIAMI_OH);
        add(MAC, NORTHERN_ILLINOIS);
        add(MAC, OHIO);
        add(MAC, TOLEDO);
        add(MAC, UMASS);
        add(MAC, WESTERN_MICHIGAN);

        add(MWC, AIR_FORCE);
        add(MWC, BOISE_STATE);
        add(MWC, COLORADO_STATE);
        add(MWC, FRESNO_STATE);
        add(MWC, HAWAII);
        add(MWC, NEVADA);
        add(MWC, NEW_MEXICO);
        add(MWC, SAN_DIEGO_STATE);
        add(MWC, SAN_JOSE_STATE);
        add(MWC, UNLV);
        add(MWC, UTAH_STATE);
        add(MWC, WYOMING);

        add(PAC_12, ARIZONA);
        add(PAC_12, ARIZONA_STATE);
        add(PAC_12, CAL);
        add(PAC_12, COLORADO);
        add(PAC_12, OREGON);
        add(PAC_12, OREGON_STATE);
        add(PAC_12, STANFORD);
        add(PAC_12, UCLA);
        add(PAC_12, USC);
        add(PAC_12, UTAH);
        add(PAC_12, WASHINGTON);
        add(PAC_12, WASHINGTON_STATE);

        add(SEC, ALABAMA);
        add(SEC, ARKANSAS);
        add(SEC, AUBURN);
        add(SEC, FLORIDA);
        add(SEC, GEORGIA);
        add(SEC, KENTUCKY);
        add(SEC, LSU);
        add(SEC, MISSISSIPPI_STATE);
        add(SEC, MISSOURI);
        add(SEC, OLE_MISS);
        add(SEC, SOUTH_CAROLINA);
        add(SEC, TENNESSEE);
        add(SEC, TEXAS_AM);
        add(SEC, VANDERBILT);

        add(SUN_BELT, ARKANSAS_STATE);
        add(SUN_BELT, GEORGIA_STATE);
        add(SUN_BELT, SOUTH_ALABAMA);
        add(SUN_BELT, TEXAS_STATE);
        add(SUN_BELT, TROY);
        add(SUN_BELT, UL_LAFAYETTE);
        add(SUN_BELT, UL_MONROE);
        add(SUN_BELT, WESTERN_KENTUCKY);
    }
}