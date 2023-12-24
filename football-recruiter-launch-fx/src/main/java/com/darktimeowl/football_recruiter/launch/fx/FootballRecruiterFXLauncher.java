package com.darktimeowl.football_recruiter.launch.fx;

import com.darktimeowl.football_recruiter.app.commands.CommandFactory;
import com.darktimeowl.football_recruiter.app.persistence.Persistence;
import com.darktimeowl.football_recruiter.fx.FootballRecruiterFX;
import com.darktimeowl.football_recruiter.fx.controllers.ControllerFactory;
import com.darktimeowl.football_recruiter.save_file.SaveFilePersistence;

public class FootballRecruiterFXLauncher {
    public static void main(String[] args) {
        FootballRecruiterFX app = new FootballRecruiterFX();
        Persistence persistence = new SaveFilePersistence();
        CommandFactory commandFactory = new CommandFactory(persistence);
        ControllerFactory controllerFactory = new ControllerFactory(commandFactory);
        app.launchApplication(controllerFactory);
    }
}