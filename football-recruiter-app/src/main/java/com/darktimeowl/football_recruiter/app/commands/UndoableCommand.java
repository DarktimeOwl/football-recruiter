package com.darktimeowl.football_recruiter.app.commands;

public interface UndoableCommand extends Command {
    void undo();
}