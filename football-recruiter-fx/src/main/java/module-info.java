module football.recruiter.fx {
    requires transitive football.recruiter.app;
    requires javafx.controls;
    requires javafx.fxml;

    exports com.darktimeowl.football_recruiter.fx;
    exports com.darktimeowl.football_recruiter.fx.commands;
    exports com.darktimeowl.football_recruiter.fx.controllers;
}