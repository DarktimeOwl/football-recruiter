package com.darktimeowl.football_recruiter.fx.controllers;

import com.darktimeowl.football_recruiter.fx.commands.FXCommandFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

import static com.darktimeowl.football_recruiter.fx.controllers.ControllerType.*;

public class ControllerFactory {
    private final Stage primaryStage;

    public ControllerFactory(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public StageController makeStageController() {
        return new StageController(primaryStage, this);
    }

    public MainController makeMainController() {
        FXCommandFactory fxCommandFactory = new FXCommandFactory(makeStageController());
        return loadFXML(MAIN, param -> new MainController(fxCommandFactory));
    }

    public FileSelectController makeFileSelectController(Stage stage) {
        return loadFXML(FILE_SELECT, param -> new FileSelectController(stage));
    }

    public SeasonSetupController makeSeasonSetupController(Stage stage) {
        ScheduleEntryController scheduleEntry = makeScheduleEntryController();
        return loadFXML(SEASON_SETUP, param -> new SeasonSetupController(stage, scheduleEntry));
    }

    public ScheduleEntryController makeScheduleEntryController() {
        return loadFXML(SCHEDULE_ENTRY, param -> new ScheduleEntryController());
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