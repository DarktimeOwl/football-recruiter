package com.darktimeowl.football_recruiter.fx;

import com.darktimeowl.football_recruiter.fx.controllers.FileSelectController;
import com.darktimeowl.football_recruiter.fx.fxml.FXMLFileLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.darktimeowl.football_recruiter.fx.controllers.ControllerType.FILE_SELECT;

public class FootballRecruiterFX extends Application {

    public void launchApplication() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileSelectController controller = FXMLFileLoader.loadFXML(FILE_SELECT);
        Scene scene = controller.getScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}