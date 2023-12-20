package com.darktimeowl.football_recruiter.app.enums;

import com.darktimeowl.football_recruiter.app.utils.ConferenceLookup;
import com.darktimeowl.football_recruiter.app.utils.RivalryLookup;

import java.util.Arrays;
import java.util.stream.Stream;

public enum School implements Opponent {
    AIR_FORCE("Air Force", "Falcons"),
    AKRON("Akron", "Zips"),
    ALABAMA("Alabama", "Crimson Tide"),
    ARIZONA("Arizona", "Wildcats"),
    ARIZONA_STATE("Arizona State", "Sun Devils"),
    ARKANSAS("Arkansas", "Razorbacks"),
    ARKANSAS_STATE("Arkansas State", "Red Wolves"),
    ARMY("Army", "Black Knights"),
    AUBURN("Auburn", "Tigers"),
    BALL_STATE("Ball State", "Cardinals"),
    BAYLOR("Baylor", "Bears"),
    BOISE_STATE("Boise State", "Broncos"),
    BOSTON_COLLEGE("Boston College", "Eagles"),
    BOWLING_GREEN("Bowling Green", "Falcons"),
    BUFFALO("Buffalo", "Bulls"),
    BYU("BYU", "Cougars"),
    CAL("Cal", "Golden Bears"),
    CENTRAL_MICHIGAN("Central Michigan", "Chippewas"),
    CINCINNATI("Cincinnati", "Bearcats"),
    CLEMSON("Clemson", "Tigers"),
    COLORADO("Colorado", "Buffaloes"),
    COLORADO_STATE("Colorado State", "Rams"),
    CONNECTICUT("Connecticut", "Huskies"),
    DUKE("Duke", "Blue Devils"),
    EASTERN_MICHIGAN("Eastern Michigan", "Eagles"),
    ECU("ECU", "Pirates"),
    FIU("FIU", "Panthers"),
    FLORIDA("Florida", "Gators"),
    FLORIDA_ATLANTIC("Florida Atlantic", "Owls"),
    FLORIDA_STATE("Florida State", "Seminoles"),
    FRESNO_STATE("Fresno State", "Bulldogs"),
    GEORGIA("Georgia", "Bulldogs"),
    GEORGIA_STATE("Georgia State", "Panthers"),
    GEORGIA_TECH("Georgia Tech", "Yellow Jackets"),
    HAWAII("Hawaii", "Rainbow Warriors"),
    HOUSTON("Houston", "Cougars"),
    IDAHO("Idaho", "Vandals"),
    ILLINOIS("Illinois", "Fighting Illini"),
    INDIANA("Indiana", "Hoosiers"),
    IOWA("Iowa", "Hawkeyes"),
    IOWA_STATE("Iowa State", "Cyclones"),
    KANSAS("Kansas", "Jayhawks"),
    KANSAS_STATE("Kansas State", "Wildcats"),
    KENT_STATE("Kent State", "Golden Flashes"),
    KENTUCKY("Kentucky", "Wildcats"),
    LA_TECH("La Tech", "Bulldogs"),
    LOUISVILLE("Louisville", "Cardinals"),
    LSU("LSU", "Tigers"),
    MARSHALL("Marshall", "Thundering Herd"),
    MARYLAND("Maryland", "Terrapins"),
    MEMPHIS("Memphis", "Tigers"),
    MIAMI_FL("Miami (FL)", "Hurricanes"),
    MIAMI_OH("Miami (OH)", "RedHawks"),
    MICHIGAN("Michigan", "Wolverines"),
    MICHIGAN_STATE("Michigan State", "Spartans"),
    MINNESOTA("Minnesota", "Golden Gophers"),
    MISSISSIPPI_STATE("Mississippi State", "Bulldogs"),
    MISSOURI("Missouri", "Tigers"),
    MID_TENN_STATE("Mid Tenn State", "Blue Raiders"),
    NAVY("Navy", "Midshipmen"),
    NC_STATE("NC State", "Wolfpack"),
    NEBRASKA("Nebraska", "Cornhuskers"),
    NEVADA("Nevada", "Wolf Pack"),
    NEW_MEXICO("New Mexico", "Lobos"),
    NEW_MEXICO_STATE("New Mexico State", "Aggies"),
    NORTH_CAROLINA("North Carolina", "Tar Heels"),
    NORTH_TEXAS("North Texas", "Mean Green"),
    NORTHERN_ILLINOIS("Northern Illinois", "Huskies"),
    NORTHWESTERN("Northwestern", "Wildcats"),
    NOTRE_DAME("Notre Dame", "Fighting Irish"),
    OHIO("Ohio", "Bobcats"),
    OHIO_STATE("Ohio State", "Buckeyes"),
    OKLAHOMA("Oklahoma", "Sooners"),
    OKLAHOMA_STATE("Oklahoma State", "Cowboys"),
    OLD_DOMINION("Old Dominion", "Monarchs"),
    OLE_MISS("Ole Miss", "Rebels"),
    OREGON("Oregon", "Ducks"),
    OREGON_STATE("Oregon State", "Beavers"),
    PENN_STATE("Penn State", "Nittany Lions"),
    PITT("Pitt", "Panthers"),
    PURDUE("Purdue", "Boilermakers"),
    RICE("Rice", "Owls"),
    RUTGERS("Rutgers", "Scarlet Knights"),
    SAN_DIEGO_STATE("San Diego State", "Aztecs"),
    SAN_JOSE_STATE("San Jose State", "Spartans"),
    SMU("SMU", "Mustangs"),
    SOUTH_ALABAMA("South Alabama", "Jaguars"),
    SOUTH_CAROLINA("South Carolina", "Gamecocks"),
    SOUTHERN_MISS("Southern Miss", "Golden Eagles"),
    STANFORD("Stanford", "Cardinal"),
    SYRACUSE("Syracuse", "Orange"),
    TCU("TCU", "Horned Frogs"),
    TEMPLE("Temple", "Owls"),
    TENNESSEE("Tennessee", "Volunteers"),
    TEXAS("Texas", "Longhorns"),
    TEXAS_AM("Texas A&M", "Aggies"),
    TEXAS_STATE("Texas State", "Bobcats"),
    TEXAS_TECH("Texas Tech", "Red Raiders"),
    TOLEDO("Toledo", "Rockets"),
    TROY("Troy", "Trojans"),
    TULANE("Tulane", "Green Wave"),
    TULSA("Tulsa", "Golden Hurricane"),
    UAB("UAB", "Blazers"),
    UCF("UCF", "Knights"),
    UCLA("UCLA", "Bruins"),
    UL_LAFAYETTE("UL Lafayette", "Ragin' Cajuns"),
    UL_MONROE("UL Monroe", "Warhawks"),
    UMASS("UMass", "Minutemen"),
    UNLV("UNLV", "Rebels"),
    USC("USC", "Trojans"),
    USF("USF", "Bulls"),
    UTAH("Utah", "Utes"),
    UTAH_STATE("Utah State", "Aggies"),
    UTEP("UTEP", "Miners"),
    UTSA("UTSA", "Roadrunners"),
    VANDERBILT("Vanderbilt", "Commodores"),
    VIRGINIA("Virginia", "Cavaliers"),
    VIRGINIA_TECH("Virginia Tech", "Hokies"),
    WAKE_FOREST("Wake Forest", "Demon Deacons"),
    WASHINGTON("Washington", "Huskies"),
    WASHINGTON_STATE("Washington State", "Cougars"),
    WEST_VIRGINIA("West Virginia", "Mountaineers"),
    WESTERN_KENTUCKY("Western Kentucky", "Hilltoppers"),
    WESTERN_MICHIGAN("Western Michigan", "Broncos"),
    WISCONSIN("Wisconsin", "Badgers"),
    WYOMING("Wyoming", "Cowboys");

    private final String schoolName;
    private final String nickname;
    private final String fullName;

    School(String schoolName, String nickname) {
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

    public boolean isRival(Opponent opponent) {
        return opponent.isRival(this);
    }

    @Override
    public boolean isRival(School school) {
        return RivalryLookup.areRivals(this, school);
    }

    public Conference defaultConference() {
        return ConferenceLookup.defaultConference(this);
    }

    public static Stream<School> streamAll() {
        return Arrays.stream(values());
    }
}