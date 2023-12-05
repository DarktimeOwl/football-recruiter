package com.darktimeowl.football_recruiter.fx.fxml;

import com.darktimeowl.football_recruiter.fx.controllers.Controller;
import com.darktimeowl.football_recruiter.fx.controllers.ControllerType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class FXMLFileLoader {

    public static <T extends Controller> T loadFXML(ControllerType controllerType) throws IOException {
        FXMLLoader loader = new FXMLLoader(controllerType.getURL());
        loader.setControllerFactory(controllerType.getControllerFactory());
        loader.load();
        T t = loader.getController();
        t.getChildren().add(loader.getRoot());
        new Scene(t);
        return t;
    }
}