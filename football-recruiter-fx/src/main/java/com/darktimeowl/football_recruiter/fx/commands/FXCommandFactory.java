package com.darktimeowl.football_recruiter.fx.commands;

import com.darktimeowl.football_recruiter.fx.controllers.StageController;

public class FXCommandFactory {
    private final StageController stageController;

    public FXCommandFactory(StageController stageController) {
        this.stageController = stageController;
    }

    public ViewFileSelectCommand makeViewFileSelectCommand() {
        return new ViewFileSelectCommand(stageController);
    }

    public ViewSeasonSetupCommand makeViewSeasonSetupCommand() {
        return new ViewSeasonSetupCommand(stageController);
    }
}