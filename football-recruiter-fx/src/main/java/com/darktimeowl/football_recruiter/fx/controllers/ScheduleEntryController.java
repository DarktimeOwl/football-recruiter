package com.darktimeowl.football_recruiter.fx.controllers;

import com.darktimeowl.football_recruiter.app.enums.Opponent;
import com.darktimeowl.football_recruiter.app.enums.School;
import com.darktimeowl.football_recruiter.app.enums.WeekType;
import com.darktimeowl.football_recruiter.fx.model.SearchableComboBox;
import com.darktimeowl.football_recruiter.fx.model.StringConverters;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.darktimeowl.football_recruiter.app.enums.WeekType.*;
import static javafx.beans.binding.Bindings.createObjectBinding;

public class ScheduleEntryController extends Controller {
    @FXML private ToggleGroup weekTypeToggleGroup1;
    @FXML private ToggleGroup weekTypeToggleGroup2;
    @FXML private ToggleGroup weekTypeToggleGroup3;
    @FXML private ToggleGroup weekTypeToggleGroup4;
    @FXML private ToggleGroup weekTypeToggleGroup5;
    @FXML private ToggleGroup weekTypeToggleGroup6;
    @FXML private ToggleGroup weekTypeToggleGroup7;
    @FXML private ToggleGroup weekTypeToggleGroup8;
    @FXML private ToggleGroup weekTypeToggleGroup9;
    @FXML private ToggleGroup weekTypeToggleGroup10;
    @FXML private ToggleGroup weekTypeToggleGroup11;
    @FXML private ToggleGroup weekTypeToggleGroup12;
    @FXML private ToggleGroup weekTypeToggleGroup13;
    @FXML private ToggleGroup weekTypeToggleGroup14;
    @FXML private ToggleGroup weekTypeToggleGroup15;

    @FXML private ComboBox<Opponent> opponentComboBox1;
    @FXML private ComboBox<Opponent> opponentComboBox2;
    @FXML private ComboBox<Opponent> opponentComboBox3;
    @FXML private ComboBox<Opponent> opponentComboBox4;
    @FXML private ComboBox<Opponent> opponentComboBox5;
    @FXML private ComboBox<Opponent> opponentComboBox6;
    @FXML private ComboBox<Opponent> opponentComboBox7;
    @FXML private ComboBox<Opponent> opponentComboBox8;
    @FXML private ComboBox<Opponent> opponentComboBox9;
    @FXML private ComboBox<Opponent> opponentComboBox10;
    @FXML private ComboBox<Opponent> opponentComboBox11;
    @FXML private ComboBox<Opponent> opponentComboBox12;
    @FXML private ComboBox<Opponent> opponentComboBox13;
    @FXML private ComboBox<Opponent> opponentComboBox14;
    @FXML private ComboBox<Opponent> opponentComboBox15;
    
    private final List<WeekEntry> weekEntries = new ArrayList<>();
    private ObjectBinding<School> schoolBinding = createObjectBinding(() -> null);

    /**
     * Each validation error found will be added to the returned {@code List<String>}.
     * An empty {@code List} indicates a valid schedule entry.
     * @return List of validation error messages
     */
    public List<String> validate() {
        ArrayList<String> errors = new ArrayList<>();
        School school = schoolBinding.get();
        if (school == null) {
            errors.add("Your school is not selected");
            return errors;
        }
        int opponentCount = 0;
        int week = 0;
        for (WeekEntry weekEntry : weekEntries) {
            week++;
            Opponent opponent = weekEntry.opponent();
            if (school == opponent) {
                errors.add(String.format("You have scheduled yourself for week %d", week));
            }
            if (!weekEntry.isValid()) {
                errors.add(String.format("No opponent scheduled for week %d and it is not a bye week", week));
            }
            if (!weekEntry.isByeWeek()) {
                opponentCount++;
            }
        }
        if (opponentCount < 11) {
            errors.add("Must schedule at least 11 games");
        }
        if (opponentCount > 12) {
            errors.add("Cannot schedule more than 12 games");
        }
        return errors;
    }

    public void setSchoolBinding(ObjectBinding<School> schoolBinding) {
        this.schoolBinding = schoolBinding;
    }

    @FXML
    private void initialize() {
        weekEntries.add(new WeekEntry(weekTypeToggleGroup1, opponentComboBox1));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup2, opponentComboBox2));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup3, opponentComboBox3));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup4, opponentComboBox4));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup5, opponentComboBox5));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup6, opponentComboBox6));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup7, opponentComboBox7));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup8, opponentComboBox8));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup9, opponentComboBox9));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup10, opponentComboBox10));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup11, opponentComboBox11));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup12, opponentComboBox12));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup13, opponentComboBox13));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup14, opponentComboBox14));
        weekEntries.add(new WeekEntry(weekTypeToggleGroup15, opponentComboBox15));
    }

    private class WeekEntry {
        private final ToggleGroup weekTypeToggleGroup;
        private final ComboBox<Opponent> opponentComboBox;
        private WeekType weekType = BYE;

        private WeekEntry(ToggleGroup weekTypeToggleGroup, ComboBox<Opponent> opponentComboBox) {
            this.weekTypeToggleGroup = weekTypeToggleGroup;
            this.opponentComboBox = opponentComboBox;
            initializeOpponentComboBox();
            initializeWeekTypeToggleGroup();
        }

        public Opponent opponent() {
            return opponentComboBox.getValue();
        }

        public WeekType weekType() {
            return weekType;
        }

        public boolean isByeWeek() {
            return weekType() == BYE;
        }

        public boolean isValid() {
            return isByeWeek() || opponent() != null;
        }

        private void weekTypeChanged(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle value) {
            RadioButton selected = (RadioButton) value;
            StringConverter<WeekType> converter = StringConverters.weekTypeName();
            weekType = converter.fromString(selected.getText());
            weekType = switch (selected.getText()) {
                case "Home" -> HOME;
                case "Away" -> AWAY;
                default -> BYE;
            };
            if (weekType == BYE) {
                opponentComboBox.setValue(null);
                opponentComboBox.setDisable(true);
                return;
            }
            opponentComboBox.setDisable(false);
        }

        private boolean opponentIsNotSelectedSchool(Opponent opponent) {
            return opponent != schoolBinding.get();
        }

        private Stream<Opponent> validOpponents() {
            return Opponent.streamAll().filter(this::opponentIsNotSelectedSchool);
        }

        private void initializeOpponentComboBox() {
            opponentComboBox.setConverter(StringConverters.opponentFullName());
            SearchableComboBox.create(opponentComboBox, this::validOpponents);
        }

        private void initializeWeekTypeToggleGroup() {
            ObservableList<Toggle> toggles = weekTypeToggleGroup.getToggles();
            RadioButton home = (RadioButton) toggles.getFirst();
            RadioButton away = (RadioButton) toggles.get(1);
            RadioButton bye = (RadioButton) toggles.getLast();
            home.setText(HOME.displayName());
            away.setText(AWAY.displayName());
            bye.setText(BYE.displayName());
            weekTypeToggleGroup.selectedToggleProperty().addListener(this::weekTypeChanged);
        }
    }
}