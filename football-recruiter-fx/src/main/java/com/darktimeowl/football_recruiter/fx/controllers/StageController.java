package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.stage.Stage;

import static javafx.stage.Modality.WINDOW_MODAL;

public class StageController {
    private final Stage primaryStage;
    private final ControllerFactory controllerFactory;

    public StageController(Stage primaryStage, ControllerFactory controllerFactory) {
        this.primaryStage = primaryStage;
        this.controllerFactory = controllerFactory;
    }

    public void viewFileSelect() {
        Stage stage = new Stage();
        FileSelectController fileSelect = controllerFactory.makeFileSelectController(stage);
        stage.setScene(fileSelect.getScene());
        stage.setTitle("Select File");
        showAsModal(stage);
    }

    public void viewSeasonSetup() {
        Stage stage = new Stage();
        SeasonSetupController seasonSetup = controllerFactory.makeSeasonSetupController(stage);
        stage.setScene(seasonSetup.getScene());
        stage.setTitle("Season Setup");
        showAsModal(stage);
    }

    private void showAsModal(Stage stage) {
        stage.initOwner(primaryStage);
        stage.initModality(WINDOW_MODAL);
        stage.show();
    }
}