package com.darktimeowl.football_recruiter.launch.fx;

import com.darktimeowl.football_recruiter.fx.FootballRecruiterFX;
import com.darktimeowl.football_recruiter.fx.controllers.ControllerFactory;

public class FootballRecruiterFXLauncher {
    public static void main(String[] args) {
        FootballRecruiterFX footballRecruiterFX = new FootballRecruiterFX().launchApplication();
        footballRecruiterFX.init();
        footballRecruiterFX.show();
    }
}