package com.darktimeowl.football_recruiter.fx.model;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SearchableComboBox<T> {
    private static final int DEFAULT_VISIBLE_ROW_COUNT = 10;
    private final ComboBox<T> comboBox;
    private final Supplier<Stream<T>> sourceSupplier;
    private final ObservableList<T> filteredList;

    public static <T> void create(ComboBox<T> comboBox, Supplier<Stream<T>> sourceSupplier) {
        new SearchableComboBox<>(comboBox, sourceSupplier);
    }

    private SearchableComboBox(ComboBox<T> comboBox, Supplier<Stream<T>> sourceSupplier) {
        this.comboBox = comboBox;
        this.sourceSupplier = sourceSupplier;
        this.filteredList = comboBox.getItems();
        resetList();
        comboBox.getEditor().textProperty().addListener(this::changed);
        comboBox.showingProperty().addListener(this::showing);
    }

    private void showing(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean value) {
        comboBox.setVisibleRowCount(DEFAULT_VISIBLE_ROW_COUNT);
    }

    private void changed(ObservableValue<? extends String> observable, String oldValue, String value) {
        if (selectionMatches(value)) {
            return;
        }
        if (value.isEmpty()) {
            resetList();
            return;
        }
        comboBox.hide();
        List<T> searchResults = refreshList(value);
        if (searchResults.isEmpty()) {
            return;
        }
        T first = searchResults.getFirst();
        comboBox.setValue(first);
        comboBox.show();
        String s = comboBox.getEditor().getText();
        Platform.runLater(() -> comboBox.getEditor().selectRange(s.length(), value.length()));
    }

    private List<T> refreshList(String searchText) {
        List<T> searchResults = sourceSupplier.get()
                .filter(t -> startsWith(t, searchText))
                .toList();
        if (searchResults.isEmpty()) {
            resetList();
            return searchResults;
        }
        filteredList.retainAll(searchResults);
        if (filteredList.size() < searchResults.size()) {
            mergeLists(searchResults);
        }
        comboBox.setVisibleRowCount(DEFAULT_VISIBLE_ROW_COUNT);
        return searchResults;
    }

    private boolean startsWith(T t, String value) {
        StringConverter<T> converter = comboBox.getConverter();
        return converter.toString(t).toLowerCase().startsWith(value.toLowerCase());
    }

    private boolean selectionMatches(String value) {
        T t = comboBox.getValue();
        StringConverter<T> converter = comboBox.getConverter();
        return t != null && converter.toString(t).equalsIgnoreCase(value);
    }

    private void resetList() {
        comboBox.hide();
        filteredList.clear();
        sourceSupplier.get().forEach(filteredList::add);
        comboBox.setVisibleRowCount(DEFAULT_VISIBLE_ROW_COUNT);
    }

    private void mergeLists(List<T> searchResults) {
        for (int i = 0; i < searchResults.size(); i++) {
            T searchResult = searchResults.get(i);
            T filteredItem = filteredList.get(i);
            if (!filteredItem.equals(searchResult)) {
                filteredList.add(i, searchResult);
            }
        }
    }
}