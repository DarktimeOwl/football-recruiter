package com.darktimeowl.football_recruiter.fx.controllers;

import com.darktimeowl.football_recruiter.fx.commands.FXCommandFactory;
import com.darktimeowl.football_recruiter.fx.commands.ViewFileSelectCommand;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController extends Controller {
    private final FXCommandFactory commandFactory;

    public MainController(FXCommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @FXML
    private void newFile() {
        System.out.println("New!");
    }

    @FXML
    private void open() {
        ViewFileSelectCommand command = commandFactory.makeViewFileSelectCommand();
        command.execute();
    }

    @FXML
    private void save() {
        System.out.println("Save!");
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