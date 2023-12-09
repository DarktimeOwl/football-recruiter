package com.darktimeowl.football_recruiter.fx.controllers;

import javafx.util.Callback;

import java.net.URL;

public enum ControllerType {
    FILE_SELECT("fxml/FileSelect.fxml", param -> new FileSelectController());

    private final URL url;
    private final Callback<Class<?>, Object> controllerFactory;

    ControllerType(String path, Callback<Class<?>, Object> controllerFactory) {
        this.url = getClass().getClassLoader().getResource(path);
        this.controllerFactory = controllerFactory;
    }

    public URL getURL() {
        return url;
    }

    public Callback<Class<?>, Object> getControllerFactory() {
        return controllerFactory;
    }
}