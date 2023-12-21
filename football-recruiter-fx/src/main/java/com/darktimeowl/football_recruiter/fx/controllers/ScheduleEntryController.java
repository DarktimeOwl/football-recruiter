package com.darktimeowl.football_recruiter.fx.controllers;

import com.darktimeowl.football_recruiter.app.enums.Opponent;
import com.darktimeowl.football_recruiter.app.enums.School;
import com.darktimeowl.football_recruiter.app.enums.WeekType;
import com.darktimeowl.football_recruiter.fx.model.SearchableComboBox;
import com.darktimeowl.football_recruiter.fx.model.StringConverters;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

import static com.darktimeowl.football_recruiter.app.enums.WeekType.BYE;

public class ScheduleEntryController extends Controller {
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox1;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox2;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox3;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox4;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox5;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox6;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox7;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox8;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox9;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox10;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox11;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox12;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox13;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox14;
    @FXML private ChoiceBox<WeekType> weekTypeChoiceBox15;
    
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
    private ObjectBinding<School> schoolBinding;

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
        weekEntries.add(new WeekEntry(weekTypeChoiceBox1, opponentComboBox1));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox2, opponentComboBox2));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox3, opponentComboBox3));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox4, opponentComboBox4));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox5, opponentComboBox5));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox6, opponentComboBox6));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox7, opponentComboBox7));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox8, opponentComboBox8));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox9, opponentComboBox9));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox10, opponentComboBox10));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox11, opponentComboBox11));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox12, opponentComboBox12));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox13, opponentComboBox13));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox14, opponentComboBox14));
        weekEntries.add(new WeekEntry(weekTypeChoiceBox15, opponentComboBox15));
    }

    private record WeekEntry(ChoiceBox<WeekType> weekTypeChoiceBox, ComboBox<Opponent> opponentComboBox) {
        private WeekEntry(ChoiceBox<WeekType> weekTypeChoiceBox, ComboBox<Opponent> opponentComboBox) {
            this.weekTypeChoiceBox = weekTypeChoiceBox;
            this.opponentComboBox = opponentComboBox;
            initializeOpponentComboBox();
            initializeWeekTypeChoiceBox();
        }

        public Opponent opponent() {
            return opponentComboBox.getValue();
        }

        public WeekType weekType() {
            return weekTypeChoiceBox.getValue();
        }

        public boolean isByeWeek() {
            return weekType() == BYE;
        }

        public boolean isValid() {
            return isByeWeek() || opponent() != null;
        }

        private void initializeOpponentComboBox() {
            opponentComboBox.setConverter(StringConverters.opponentFullName());
            SearchableComboBox.builder(opponentComboBox, Opponent::streamAll).build();
        }

        private void initializeWeekTypeChoiceBox() {
            weekTypeChoiceBox.setConverter(StringConverters.weekTypeName());
            weekTypeChoiceBox.getItems().addAll(WeekType.values());
            weekTypeChoiceBox.valueProperty().addListener(this::weekTypeChanged);
            weekTypeChoiceBox.setValue(BYE);
        }

        private void weekTypeChanged(ObservableValue<? extends WeekType> observable, WeekType oldValue, WeekType value) {
            if (value == BYE) {
                opponentComboBox.getSelectionModel().clearSelection();
                opponentComboBox.setDisable(true);
                return;
            }
            opponentComboBox.setDisable(false);
        }
    }
}