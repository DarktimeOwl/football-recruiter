package com.darktimeowl.football_recruiter.fx;

import com.darktimeowl.football_recruiter.fx.controllers.StartController;
import com.darktimeowl.football_recruiter.fx.fxml.FXMLFileLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.darktimeowl.football_recruiter.fx.controllers.ControllerType.START_VIEW;

public class FootballRecruiterFX extends Application {

    public void launchApplication() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StartController controller = FXMLFileLoader.loadFXML(START_VIEW);
        Scene scene = controller.getScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}