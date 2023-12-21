package com.darktimeowl.football_recruiter.fx.model;

import com.darktimeowl.football_recruiter.app.enums.Conference;
import com.darktimeowl.football_recruiter.app.enums.Opponent;
import com.darktimeowl.football_recruiter.app.enums.School;
import com.darktimeowl.football_recruiter.app.enums.WeekType;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StringConverters {
    private static final ConferenceName conferenceName = new ConferenceName();
    private static final OpponentFullName opponentFullName = new OpponentFullName();
    private static final SchoolFullName schoolFullName = new SchoolFullName();
    private static final WeekTypeName weekTypeName = new WeekTypeName();

    public static StringConverter<Conference> conferenceName() {
        return conferenceName;
    }

    public static StringConverter<Opponent> opponentFullName() {
        return opponentFullName;
    }

    public static StringConverter<School> schoolFullName() {
        return schoolFullName;
    }

    public static StringConverter<WeekType> weekTypeName() {
        return weekTypeName;
    }

    private static abstract class CustomStringConverter<T> extends StringConverter<T> {
        private final Map<String, T> names = new HashMap<>();

        protected abstract Stream<T> streamValues();

        @Override
        public T fromString(String string) {
            String key = string.toLowerCase();
            if (names.containsKey(key)) {
                return names.get(key);
            }
            streamValues()
                    .filter(t -> toString(t).equalsIgnoreCase(key))
                    .findFirst()
                    .ifPresent(t -> names.put(key, t));
            return names.get(key);
        }
    }

    private static abstract class ConferenceStringConverter extends CustomStringConverter<Conference> {
        @Override
        protected Stream<Conference> streamValues() {
            return Conference.streamAll();
        }
    }

    private static abstract class OpponentStringConverter extends CustomStringConverter<Opponent> {
        @Override
        protected Stream<Opponent> streamValues() {
            return Opponent.streamAll();
        }
    }

    private static abstract class SchoolStringConverter extends CustomStringConverter<School> {
        @Override
        protected Stream<School> streamValues() {
            return School.streamAll();
        }
    }

    private static abstract class WeekTypeStringConverter extends CustomStringConverter<WeekType> {
        @Override
        protected Stream<WeekType> streamValues() {
            return WeekType.streamAll();
        }
    }

    private static class ConferenceName extends ConferenceStringConverter {
        @Override
        public String toString(Conference conference) {
            return conference != null ? conference.displayName() : "";
        }
    }

    private static class OpponentFullName extends OpponentStringConverter {
        @Override
        public String toString(Opponent opponent) {
            return opponent != null ? opponent.fullName() : "";
        }
    }

    private static class SchoolFullName extends SchoolStringConverter {
        @Override
        public String toString(School school) {
            return school != null ? school.fullName() : "";
        }
    }

    private static class WeekTypeName extends WeekTypeStringConverter {
        @Override
        public String toString(WeekType weekType) {
            return weekType != null ? weekType.displayName() : "";
        }
    }
}