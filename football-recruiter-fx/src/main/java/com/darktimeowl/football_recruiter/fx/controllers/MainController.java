package com.darktimeowl.football_recruiter.fx.controllers;

import com.darktimeowl.football_recruiter.app.commands.CommandFactory;
import com.darktimeowl.football_recruiter.app.commands.SaveCommand;
import com.darktimeowl.football_recruiter.fx.commands.FXCommandFactory;
import com.darktimeowl.football_recruiter.fx.commands.ViewFileSelectCommand;
import com.darktimeowl.football_recruiter.fx.commands.ViewSeasonSetupCommand;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController extends Controller {
    private final FXCommandFactory fxCommandFactory;
    private final CommandFactory commandFactory;

    public MainController(FXCommandFactory fxCommandFactory, CommandFactory commandFactory) {
        this.fxCommandFactory = fxCommandFactory;
        this.commandFactory = commandFactory;
    }

    @FXML
    private void newFile() {
        ViewSeasonSetupCommand command = fxCommandFactory.makeViewSeasonSetupCommand();
        command.execute();
    }

    @FXML
    private void open() {
        ViewFileSelectCommand command = fxCommandFactory.makeViewFileSelectCommand();
        command.execute();
    }

    @FXML
    private void save() {
        SaveCommand command = commandFactory.createSaveCommand();
        command.execute();
    }

    @FXML
    private void saveAs() {
        System.out.println("Save As!");
    }

    @FXML
    private void undo() {
        System.out.println("Undo!");
    }

    @FXML
    private void redo() {
        System.out.println("Redo!");
    }

    @FXML
    private void about() {
        System.out.println("About!");
    }

    @FXML
    private void quit() {
        Platform.exit();
    }
}