package com.darktimeowl.football_recruiter.fx.commands;

import com.darktimeowl.football_recruiter.app.commands.Command;
import com.darktimeowl.football_recruiter.fx.controllers.StageController;

public class ViewSeasonSetupCommand implements Command {
    private final StageController stageController;

    public ViewSeasonSetupCommand(StageController stageController) {
        this.stageController = stageController;
    }

    @Override
    public void execute() {
        stageController.viewSeasonSetup();
    }
}