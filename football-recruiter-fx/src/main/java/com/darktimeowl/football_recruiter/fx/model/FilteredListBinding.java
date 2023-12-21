package com.darktimeowl.football_recruiter.fx.model;

import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FilteredListBinding<E> extends ObjectBinding<List<E>> {
    private final Supplier<Stream<E>> sourceSupplier;
    private final List<Observable> dependencies;
    private final Predicate<E> filters;

    public static <E> Builder<E> builder(Supplier<Stream<E>> sourceSupplier) {
        return new Builder<>(sourceSupplier);
    }

    private FilteredListBinding(Supplier<Stream<E>> sourceSupplier, List<Observable> dependencies, List<Predicate<E>> filters) {
        this.sourceSupplier = sourceSupplier;
        this.dependencies = new ArrayList<>(dependencies);
        this.filters = filters.stream()
                .reduce(e -> true, Predicate::and);
        dependencies.forEach(this::bind);
    }

    @Override
    protected List<E> computeValue() {
        return sourceSupplier.get()
                .filter(filters)
                .toList();
    }

    @Override
    public ObservableList<?> getDependencies() {
        return FXCollections.observableList(dependencies);
    }

    public static class Builder<E> {
        private final Supplier<Stream<E>> sourceSupplier;
        private final List<Observable> dependencies = new ArrayList<>();
        private final List<Predicate<E>> filters = new ArrayList<>();

        private Builder(Supplier<Stream<E>> sourceSupplier) {
            this.sourceSupplier = sourceSupplier;
        }

        public FilteredListBinding<E> build() {
            return new FilteredListBinding<>(sourceSupplier, dependencies, filters);
        }

        public Builder<E> addDependency(Observable dependency) {
            dependencies.add(dependency);
            return this;
        }

        public Builder<E> addFilter(Predicate<E> filter) {
            filters.add(filter);
            return this;
        }
    }
}