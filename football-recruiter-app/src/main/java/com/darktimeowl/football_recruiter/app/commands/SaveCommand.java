package com.darktimeowl.football_recruiter.app.commands;

import com.darktimeowl.football_recruiter.app.persistence.Persistence;

public class SaveCommand implements Command {
    private final Persistence persistence;

    public SaveCommand(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public void execute() {
        persistence.saveSeason();
    }
}