package com.darktimeowl.football_recruiter.app.utils;

import com.darktimeowl.football_recruiter.app.enums.School;

import java.util.*;

import static com.darktimeowl.football_recruiter.app.enums.School.*;

public class RivalryLookup {
    private final static Map<School, Set<School>> rivalries;

    static {
        rivalries = new EnumMap<>(School.class);
        Arrays.stream(School.values())
                .forEach(school -> rivalries.put(school, EnumSet.noneOf(School.class)));
        initializeRivalries();
    }

    public static boolean areRivals(School a, School b) {
        return rivalries.get(a).contains(b);
    }

    private static void addRivalry(School a, School b) {
        rivalries.get(a).add(b);
        rivalries.get(b).add(a);
    }

    private static void initializeRivalries() {
        addRivalry(AIR_FORCE, ARMY);
        addRivalry(AIR_FORCE, COLORADO_STATE);
        addRivalry(AIR_FORCE, HAWAII);
        addRivalry(AIR_FORCE, NAVY);
        addRivalry(AKRON, KENT_STATE);
        addRivalry(ALABAMA, AUBURN);
        addRivalry(ALABAMA, FLORIDA);
        addRivalry(ALABAMA, LSU);
        addRivalry(ALABAMA, MISSISSIPPI_STATE);
        addRivalry(ALABAMA, OLE_MISS);
        addRivalry(ALABAMA, TENNESSEE);
        addRivalry(ARIZONA, ARIZONA_STATE);
        addRivalry(ARIZONA, NEW_MEXICO);
        addRivalry(ARKANSAS, LSU);
        addRivalry(ARKANSAS, OLE_MISS);
        addRivalry(ARKANSAS, TEXAS);
        addRivalry(ARKANSAS, TEXAS_AM);
        addRivalry(ARKANSAS_STATE, NORTH_TEXAS);
        addRivalry(ARKANSAS_STATE, UL_MONROE);
        addRivalry(ARMY, NAVY);
        addRivalry(ARMY, RUTGERS);
        addRivalry(AUBURN, GEORGIA);
        addRivalry(AUBURN, LSU);
        addRivalry(BALL_STATE, NORTHERN_ILLINOIS);
        addRivalry(BAYLOR, TCU);
        addRivalry(BAYLOR, TEXAS);
        addRivalry(BAYLOR, TEXAS_AM);
        addRivalry(BAYLOR, TEXAS_TECH);
        addRivalry(BOISE_STATE, BYU);
        addRivalry(BOISE_STATE, FRESNO_STATE);
        addRivalry(BOISE_STATE, HAWAII);
        addRivalry(BOISE_STATE, IDAHO);
        addRivalry(BOISE_STATE, NEVADA);
        addRivalry(BOISE_STATE, TCU);
        addRivalry(BOSTON_COLLEGE, CLEMSON);
        addRivalry(BOSTON_COLLEGE, MIAMI_FL);
        addRivalry(BOSTON_COLLEGE, NOTRE_DAME);
        addRivalry(BOSTON_COLLEGE, SYRACUSE);
        addRivalry(BOSTON_COLLEGE, UMASS);
        addRivalry(BOSTON_COLLEGE, VIRGINIA_TECH);
        addRivalry(BOWLING_GREEN, KENT_STATE);
        addRivalry(BOWLING_GREEN, TOLEDO);
        addRivalry(BUFFALO, SYRACUSE);
        addRivalry(BUFFALO, TEMPLE);
        addRivalry(BYU, HAWAII);
        addRivalry(BYU, SAN_DIEGO_STATE);
        addRivalry(BYU, UTAH);
        addRivalry(BYU, UTAH_STATE);
        addRivalry(CAL, STANFORD);
        addRivalry(CAL, UCLA);
        addRivalry(CAL, USC);
        addRivalry(CENTRAL_MICHIGAN, EASTERN_MICHIGAN);
        addRivalry(CENTRAL_MICHIGAN, WESTERN_MICHIGAN);
        addRivalry(CINCINNATI, LOUISVILLE);
        addRivalry(CINCINNATI, MIAMI_OH);
        addRivalry(CINCINNATI, PITT);
        addRivalry(CLEMSON, FLORIDA_STATE);
        addRivalry(CLEMSON, GEORGIA);
        addRivalry(CLEMSON, GEORGIA_TECH);
        addRivalry(CLEMSON, NC_STATE);
        addRivalry(CLEMSON, SOUTH_CAROLINA);
        addRivalry(COLORADO, COLORADO_STATE);
        addRivalry(COLORADO, NEBRASKA);
        addRivalry(COLORADO, UTAH);
        addRivalry(COLORADO_STATE, WYOMING);
        addRivalry(CONNECTICUT, RUTGERS);
        addRivalry(CONNECTICUT, SYRACUSE);
        addRivalry(CONNECTICUT, UMASS);
        addRivalry(DUKE, MARYLAND);
        addRivalry(DUKE, NC_STATE);
        addRivalry(DUKE, NORTH_CAROLINA);
        addRivalry(DUKE, WAKE_FOREST);
        addRivalry(ECU, MARSHALL);
        addRivalry(ECU, NC_STATE);
        addRivalry(ECU, SOUTHERN_MISS);
        addRivalry(ECU, UCF);
        addRivalry(EASTERN_MICHIGAN, WESTERN_MICHIGAN);
        addRivalry(FLORIDA, FLORIDA_STATE);
        addRivalry(FLORIDA, GEORGIA);
        addRivalry(FLORIDA, LSU);
        addRivalry(FLORIDA, MIAMI_FL);
        addRivalry(FLORIDA, SOUTH_CAROLINA);
        addRivalry(FLORIDA, TENNESSEE);
        addRivalry(FLORIDA_ATLANTIC, FIU);
        addRivalry(FLORIDA_ATLANTIC, TROY);
        addRivalry(FLORIDA_STATE, MIAMI_FL);
        addRivalry(FLORIDA_STATE, VIRGINIA);
        addRivalry(FRESNO_STATE, HAWAII);
        addRivalry(FRESNO_STATE, LA_TECH);
        addRivalry(FRESNO_STATE, SAN_DIEGO_STATE);
        addRivalry(FRESNO_STATE, SAN_JOSE_STATE);
        addRivalry(GEORGIA, GEORGIA_TECH);
        addRivalry(GEORGIA, SOUTH_CAROLINA);
        addRivalry(GEORGIA_STATE, GEORGIA_TECH);
        addRivalry(GEORGIA_TECH, VIRGINIA_TECH);
        addRivalry(HAWAII, WYOMING);
        addRivalry(HOUSTON, RICE);
        addRivalry(HOUSTON, SMU);
        addRivalry(HOUSTON, TULSA);
        addRivalry(IDAHO, WASHINGTON_STATE);
        addRivalry(ILLINOIS, INDIANA);
        addRivalry(ILLINOIS, MISSOURI);
        addRivalry(ILLINOIS, NORTHWESTERN);
        addRivalry(ILLINOIS, OHIO_STATE);
        addRivalry(ILLINOIS, PURDUE);
        addRivalry(INDIANA, MICHIGAN_STATE);
        addRivalry(INDIANA, PURDUE);
        addRivalry(IOWA, IOWA_STATE);
        addRivalry(IOWA, MINNESOTA);
        addRivalry(IOWA, NEBRASKA);
        addRivalry(IOWA, PURDUE);
        addRivalry(IOWA, WISCONSIN);
        addRivalry(IOWA_STATE, KANSAS_STATE);
        addRivalry(IOWA_STATE, MISSOURI);
        addRivalry(KANSAS, KANSAS_STATE);
        addRivalry(KANSAS, MISSOURI);
        addRivalry(KENTUCKY, LOUISVILLE);
        addRivalry(KENTUCKY, MISSISSIPPI_STATE);
        addRivalry(KENTUCKY, TENNESSEE);
        addRivalry(LA_TECH, SOUTHERN_MISS);
        addRivalry(LA_TECH, UL_LAFAYETTE);
        addRivalry(LA_TECH, UL_MONROE);
        addRivalry(LSU, OLE_MISS);
        addRivalry(LSU, TULANE);
        addRivalry(LOUISVILLE, MEMPHIS);
        addRivalry(LOUISVILLE, WEST_VIRGINIA);
        addRivalry(MARSHALL, OHIO);
        addRivalry(MARSHALL, WEST_VIRGINIA);
        addRivalry(MARYLAND, NAVY);
        addRivalry(MARYLAND, NC_STATE);
        addRivalry(MARYLAND, VIRGINIA);
        addRivalry(MARYLAND, WEST_VIRGINIA);
        addRivalry(MEMPHIS, OLE_MISS);
        addRivalry(MEMPHIS, SOUTHERN_MISS);
        addRivalry(MEMPHIS, UAB);
        addRivalry(MIAMI_FL, VIRGINIA_TECH);
        addRivalry(MIAMI_OH, OHIO);
        addRivalry(MICHIGAN, MICHIGAN_STATE);
        addRivalry(MICHIGAN, MINNESOTA);
        addRivalry(MICHIGAN, NOTRE_DAME);
        addRivalry(MICHIGAN, OHIO_STATE);
        addRivalry(MICHIGAN_STATE, NOTRE_DAME);
        addRivalry(MICHIGAN_STATE, PENN_STATE);
        addRivalry(MID_TENN_STATE, NORTH_TEXAS);
        addRivalry(MID_TENN_STATE, TROY);
        addRivalry(MID_TENN_STATE, WESTERN_KENTUCKY);
        addRivalry(MINNESOTA, PENN_STATE);
        addRivalry(MINNESOTA, WISCONSIN);
        addRivalry(MISSISSIPPI_STATE, OLE_MISS);
        addRivalry(MISSOURI, NEBRASKA);
        addRivalry(MISSOURI, OKLAHOMA);
        addRivalry(MISSOURI, TEXAS_AM);
        addRivalry(NAVY, NOTRE_DAME);
        addRivalry(NAVY, RUTGERS);
        addRivalry(NAVY, SMU);
        addRivalry(NC_STATE, NORTH_CAROLINA);
        addRivalry(NC_STATE, WAKE_FOREST);
        addRivalry(NEBRASKA, OKLAHOMA);
        addRivalry(NEBRASKA, PENN_STATE);
        addRivalry(NEVADA, UNLV);
        addRivalry(NEW_MEXICO, NEW_MEXICO_STATE);
        addRivalry(NEW_MEXICO, UTEP);
        addRivalry(NEW_MEXICO_STATE, UTEP);
        addRivalry(NORTH_CAROLINA, VIRGINIA);
        addRivalry(NORTH_CAROLINA, WAKE_FOREST);
        addRivalry(NORTH_TEXAS, SMU);
        addRivalry(NORTHERN_ILLINOIS, TOLEDO);
        addRivalry(NOTRE_DAME, PITT);
        addRivalry(NOTRE_DAME, PURDUE);
        addRivalry(NOTRE_DAME, STANFORD);
        addRivalry(NOTRE_DAME, USC);
        addRivalry(OHIO_STATE, PENN_STATE);
        addRivalry(OKLAHOMA, OKLAHOMA_STATE);
        addRivalry(OKLAHOMA, TEXAS);
        addRivalry(OKLAHOMA_STATE, TULSA);
        addRivalry(OLD_DOMINION, VIRGINIA);
        addRivalry(OLD_DOMINION, VIRGINIA_TECH);
        addRivalry(OLE_MISS, VANDERBILT);
        addRivalry(OREGON, OREGON_STATE);
        addRivalry(OREGON, WASHINGTON);
        addRivalry(OREGON_STATE, WASHINGTON);
        addRivalry(OREGON_STATE, WASHINGTON_STATE);
        addRivalry(PENN_STATE, PITT);
        addRivalry(PENN_STATE, TEMPLE);
        addRivalry(PITT, SYRACUSE);
        addRivalry(PITT, TEMPLE);
        addRivalry(PITT, WEST_VIRGINIA);
        addRivalry(RICE, SMU);
        addRivalry(RICE, TULSA);
        addRivalry(SAN_DIEGO_STATE, SAN_JOSE_STATE);
        addRivalry(SAN_JOSE_STATE, STANFORD);
        addRivalry(SMU, TCU);
        addRivalry(SOUTH_ALABAMA, TROY);
        addRivalry(SOUTHERN_MISS, TULANE);
        addRivalry(SOUTHERN_MISS, UAB);
        addRivalry(SYRACUSE, WEST_VIRGINIA);
        addRivalry(TENNESSEE, VANDERBILT);
        addRivalry(TEXAS, TEXAS_AM);
        addRivalry(TEXAS, TEXAS_TECH);
        addRivalry(TEXAS_AM, TEXAS_TECH);
        addRivalry(TEXAS_STATE, UTSA);
        addRivalry(TULSA, UCF);
        addRivalry(TULSA, UTEP);
        addRivalry(UCF, USF);
        addRivalry(UCLA, USC);
        addRivalry(UL_LAFAYETTE, UL_MONROE);
        addRivalry(UTAH, UTAH_STATE);
        addRivalry(UTAH_STATE, WYOMING);
        addRivalry(VIRGINIA, VIRGINIA_TECH);
        addRivalry(VIRGINIA_TECH, WEST_VIRGINIA);
        addRivalry(WASHINGTON, WASHINGTON_STATE);
    }
}