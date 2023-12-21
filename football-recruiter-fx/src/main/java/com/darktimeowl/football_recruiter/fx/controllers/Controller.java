package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;

public abstract class Controller extends Pane {
    protected void errorAlert(String message) {
        new Alert(ERROR, message).show();
    }
    protected void informationAlert(String message) {
        new Alert(INFORMATION, message).show();
    }
}