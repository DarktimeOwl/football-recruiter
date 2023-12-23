package com.darktimeowl.football_recruiter.fx.controllers;

import com.darktimeowl.football_recruiter.app.enums.Conference;
import com.darktimeowl.football_recruiter.app.enums.School;
import com.darktimeowl.football_recruiter.fx.model.SearchableComboBox;
import com.darktimeowl.football_recruiter.fx.model.StringConverterCellFactory;
import com.darktimeowl.football_recruiter.fx.model.StringConverters;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.darktimeowl.football_recruiter.app.enums.Conference.INDEPENDENT;
import static javafx.beans.binding.Bindings.createObjectBinding;

public class SeasonSetupController extends Controller {
    private static final int MAXIMUM_CONFERENCE_SIZE = 16;
    private static final int MINIMUM_CONFERENCE_SIZE = 4;

    private final Stage stage;
    private final ScheduleEntryController scheduleEntryController;

    @FXML private ComboBox<School> schoolComboBox;
    @FXML private ChoiceBox<String> weekChoiceBox;

    @FXML private ChoiceBox<Conference> conferenceChoiceBox;
    @FXML private ComboBox<School> nonConferenceSchoolComboBox;
    @FXML private Button addConferenceSchoolButton;
    @FXML private Button removeConferenceSchoolButton;
    @FXML private ListView<School> conferenceSchoolsListView;

    @FXML private VBox schedulePane;

    public SeasonSetupController(Stage stage, ScheduleEntryController scheduleEntryController) {
        this.stage = stage;
        this.scheduleEntryController = scheduleEntryController;
    }

    @FXML
    private void selectYourSchool() {
        School school = schoolComboBox.getValue();
        if (school != null) {
            conferenceChoiceBox.setValue(school.defaultConference());
        }
    }

    private void changeConferenceSelection(ObservableValue<? extends Conference> observable, Conference oldConference, Conference conference) {
        if (oldConference == conference) {
            return;
        }
        loadDefaultConferenceSchools(conference);
        if (conference == INDEPENDENT) {
            enableConferenceTeamManagement(false);
            return;
        }
        enableConferenceTeamManagement(true);
        ObservableList<School> schools = conferenceSchoolsListView.getItems();
        School school = schoolComboBox.getValue();
        if (school != null && !schools.contains(school)) {
            addConferenceSchool(school);
        }
    }

    private void loadDefaultConferenceSchools(Conference conference) {
        ObservableList<School> schools = conferenceSchoolsListView.getItems();
        schools.clear();
        schools.addAll(conference.defaultSchools());
    }

    private void enableConferenceTeamManagement(boolean enabled) {
        addConferenceSchoolButton.setDisable(!enabled);
        removeConferenceSchoolButton.setDisable(!enabled);
        if (!enabled) {
            nonConferenceSchoolComboBox.getSelectionModel().clearSelection();
        }
        nonConferenceSchoolComboBox.setDisable(!enabled);
    }

    private void addConferenceSchool(School school) {
        nonConferenceSchoolComboBox.getSelectionModel().clearSelection();
        ObservableList<School> schools = conferenceSchoolsListView.getItems();
        if (schools.contains(school)) {
            informationAlert("Already added");
            return;
        }
        schools.add(school);
        schools.sort(Comparator.naturalOrder());
        if (schools.size() >= MAXIMUM_CONFERENCE_SIZE) {
            addConferenceSchoolButton.setDisable(true);
        }
        if (schools.size() > MINIMUM_CONFERENCE_SIZE) {
            removeConferenceSchoolButton.setDisable(false);
        }
    }

    @FXML
    private void addConferenceSchool() {
        School school = nonConferenceSchoolComboBox.getValue();
        if (school == null) {
            informationAlert("Nothing selected");
            return;
        }
        addConferenceSchool(school);
    }

    @FXML
    private void removeConferenceSchool() {
        School school = conferenceSchoolsListView.getSelectionModel().getSelectedItem();
        if (school == null) {
            informationAlert("Nothing selected");
            return;
        }
        if (school == schoolComboBox.getValue()) {
            informationAlert("Cannot remove your school. Choose a new conference instead.");
            return;
        }
        ObservableList<School> schools = conferenceSchoolsListView.getItems();
        schools.remove(school);
        if (schools.size() <= MINIMUM_CONFERENCE_SIZE) {
            removeConferenceSchoolButton.setDisable(true);
        }
        if (schools.size() < MAXIMUM_CONFERENCE_SIZE) {
            addConferenceSchoolButton.setDisable(false);
        }
    }

    @FXML
    private void clickCancel() {
        stage.close();
    }

    @FXML
    private void clickStart() {
        int startingWeek = weekChoiceBox.getSelectionModel().getSelectedIndex();
        List<String> errors = new ArrayList<>();
        if (startingWeek == 0) {
            errors.addAll(scheduleEntryController.validate());
        }
        if (!errors.isEmpty()) {
            errorAlert(String.join("\n", errors));
            return;
        }
        System.out.println("Valid setup!");
    }

    @FXML
    private void initialize() {
        initializeSchoolComboBox();
        initializeWeekChoiceBox();
        initializeConferenceChoiceBox();
        initializeConferenceSchoolComboBox();
        initializeConferenceSchoolsListView();
        schedulePane.getChildren().addAll(scheduleEntryController.getChildren());
    }

    private void initializeSchoolComboBox() {
        schoolComboBox.setConverter(StringConverters.schoolFullName());
        SearchableComboBox.builder(schoolComboBox, School::streamAll).build();
        ObjectBinding<School> schoolBinding = createObjectBinding(schoolComboBox::getValue, schoolComboBox.valueProperty());
        scheduleEntryController.setSchoolBinding(schoolBinding);
    }

    private void initializeWeekChoiceBox() {
        ObservableList<String> weeks = weekChoiceBox.getItems();
        weeks.add("Pre-Season");
        for (int i = 1; i <= 15; i++) {
            weeks.add("Week " + i);
        }
        weekChoiceBox.getSelectionModel().selectFirst();
    }

    private void initializeConferenceChoiceBox() {
        conferenceChoiceBox.setConverter(StringConverters.conferenceName());
        conferenceChoiceBox.getItems().addAll(Conference.values());
        conferenceChoiceBox.valueProperty().addListener(this::changeConferenceSelection);
    }

    private void initializeConferenceSchoolComboBox() {
        nonConferenceSchoolComboBox.setConverter(StringConverters.schoolFullName());
        SearchableComboBox.builder(nonConferenceSchoolComboBox, School::streamAll)
                .addDependency(schoolComboBox.valueProperty())
                .addDependency(conferenceSchoolsListView.getItems())
                .addFilter(school -> school != schoolComboBox.getValue())
                .addFilter(school -> !conferenceSchoolsListView.getItems().contains(school))
                .build();
    }

    private void initializeConferenceSchoolsListView() {
        StringConverter<School> schoolStringConverter = StringConverters.schoolFullName();
        StringConverterCellFactory<School> cellFactory = new StringConverterCellFactory<>(schoolStringConverter);
        conferenceSchoolsListView.setCellFactory(cellFactory);
    }
}