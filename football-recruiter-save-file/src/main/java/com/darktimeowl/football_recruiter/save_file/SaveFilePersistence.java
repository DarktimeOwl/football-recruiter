package com.darktimeowl.football_recruiter.save_file;

import com.darktimeowl.football_recruiter.app.persistence.Persistence;

public class SaveFilePersistence implements Persistence {
    @Override
    public void saveSeason() {
        System.out.println("\"Saved\"");
    }
}