package com.darktimeowl.football_recruiter.fx.controllers;

import java.net.URL;

public enum ControllerType {
    MAIN("fxml/Main.fxml"),
    FILE_SELECT("fxml/FileSelect.fxml");

    private final URL url;

    ControllerType(String path) {
        this.url = getClass().getClassLoader().getResource(path);
    }

    public URL getURL() {
        return url;
    }
}