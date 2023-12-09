package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController extends Controller {

    @FXML
    private void newFile() {
        System.out.println("New!");
    }

    @FXML
    private void open() {
        System.out.println("Open!");
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