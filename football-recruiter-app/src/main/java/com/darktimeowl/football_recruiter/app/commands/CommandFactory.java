package com.darktimeowl.football_recruiter.app.commands;

import com.darktimeowl.football_recruiter.app.persistence.Persistence;

public class CommandFactory {
    private final Persistence persistence;

    public CommandFactory(Persistence persistence) {
        this.persistence = persistence;
    }

    public SaveCommand createSaveCommand() {
        return new SaveCommand(persistence);
    }
}