package com.darktimeowl.football_recruiter.fx;

import com.darktimeowl.football_recruiter.fx.controllers.ControllerFactory;
import com.darktimeowl.football_recruiter.fx.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FootballRecruiterFX extends Application {
    public static final String APPLICATION_NAME = "Football Recruiter";

    private static ControllerFactory controllerFactory;

    public void launchApplication(ControllerFactory controllerFactory) {
        FootballRecruiterFX.controllerFactory = controllerFactory;
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        controllerFactory.setPrimaryStage(primaryStage);
        MainController controller = controllerFactory.makeMainController();
        Scene scene = controller.getScene();
        primaryStage.setScene(scene);
        primaryStage.setTitle(APPLICATION_NAME);
        primaryStage.show();
    }
}