package com.darktimeowl.football_recruiter.fx.model;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class StringConverterCellFactory<T> implements Callback<ListView<T>, ListCell<T>> {
    private final StringConverter<T> converter;

    public StringConverterCellFactory(StringConverter<T> converter) {
        this.converter = converter;
    }

    @Override
    public ListCell<T> call(ListView<T> param) {
        return new ListCell<>() {
            @Override
            public void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setText(converter.toString(item));
                }
            }
        };
    }
}