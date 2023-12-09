package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class FileSelectController extends Controller {
    @FXML private ListView<String> fileListView;
    private ObservableList<String> files;

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
        files.add("Cancel clicked");
    }

    @FXML
    private void clickDelete() {
        int selected = fileListView.getFocusModel().getFocusedIndex();
        if (selected >= 0) {
            fileListView.getItems().remove(selected);
        }
    }
}