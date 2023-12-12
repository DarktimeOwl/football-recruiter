package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class FileSelectController extends Controller {
    private final Stage stage;

    @FXML private ListView<String> fileListView;
    private ObservableList<String> files;

    public FileSelectController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        files = FXCollections.observableArrayList();
        fileListView.setItems(files);
    }

    @FXML
    private void clickOpen() {
        files.add("Open clicked");
    }

    @FXML
    private void clickCancel() {
        stage.close();
    }

    @FXML
    private void clickDelete() {
        int selected = fileListView.getFocusModel().getFocusedIndex();
        if (selected >= 0) {
            fileListView.getItems().remove(selected);
        }
    }
}