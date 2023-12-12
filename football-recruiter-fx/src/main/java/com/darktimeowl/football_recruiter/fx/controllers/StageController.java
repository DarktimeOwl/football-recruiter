package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.stage.Modality;
import javafx.stage.Stage;

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
        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}