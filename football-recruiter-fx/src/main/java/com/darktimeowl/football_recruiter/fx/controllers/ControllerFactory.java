package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.util.Callback;

import java.io.IOException;

import static com.darktimeowl.football_recruiter.fx.controllers.ControllerType.FILE_SELECT;
import static com.darktimeowl.football_recruiter.fx.controllers.ControllerType.MAIN;

public class ControllerFactory {

    public MainController makeMainController() {
        return loadFXML(MAIN, param -> new MainController());
    }

    public FileSelectController makeFileSelectController() {
        return loadFXML(FILE_SELECT, param -> new FileSelectController());
    }

    private <T extends Controller> T loadFXML(ControllerType type, Callback<Class<?>, Object> factory) {
        try {
            FXMLLoader loader = new FXMLLoader(type.getURL());
            loader.setControllerFactory(factory);
            loader.load();
            T t = loader.getController();
            t.getChildren().add(loader.getRoot());
            new Scene(t);
            return t;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}