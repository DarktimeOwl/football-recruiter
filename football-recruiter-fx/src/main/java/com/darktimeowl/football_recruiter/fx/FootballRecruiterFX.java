package com.darktimeowl.football_recruiter.fx;

import com.darktimeowl.football_recruiter.fx.controllers.ControllerFactory;
import com.darktimeowl.football_recruiter.fx.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FootballRecruiterFX extends Application {
    public static final String APPLICATION_NAME = "Football Recruiter";

    private ControllerFactory controllerFactory;
    private MainController controller;
    private Stage primaryStage;

    public FootballRecruiterFX launchApplication() {
        launch();
        return this;
    }

    @Override
    public void init() {
        controllerFactory = new ControllerFactory();
        controller = controllerFactory.makeMainController();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        show();
    }

    public ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

    public void show() {
        Scene scene = controller.getScene();
        primaryStage.setScene(scene);
        primaryStage.setTitle(APPLICATION_NAME);
        primaryStage.show();
    }
}