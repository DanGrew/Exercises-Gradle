package uk.dangrew.exercises.turbine_status.ui;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.MapChangeListener.Change;
import uk.dangrew.exercises.turbine_status.model.AlarmLevel;
import uk.dangrew.exercises.turbine_status.model.Turbine;

/**
 * Defines the table view of data related to a {@link Turbine}, specifically the number of alarms for a particular {@link AlarmLevel}.
 */
public class AlarmTableEntry {

    private final Turbine turbine;
    private final ObjectProperty<String> identifier;
    private final ObjectProperty<AlarmLevel> level;
    private final ObjectProperty<Integer> count;

    public AlarmTableEntry(Turbine turbine, AlarmLevel alarmLevel) {
        this.turbine = turbine;
        this.identifier = new SimpleObjectProperty<>(turbine.getIdentifier());
        this.level = new SimpleObjectProperty<>(alarmLevel);
        this.count = new SimpleObjectProperty<>(turbine.getAlarms().getAlarmCountFor(alarmLevel));

        turbine.getAlarms().addAlarmListener(this::handleChange);
    }

    private void handleChange(Change<? extends AlarmLevel, ? extends Integer> change) {
        count.set(turbine.getAlarms().getAlarmCountFor(level.get()));
    }

    public ObjectProperty<String> identifierProperty() {
        return identifier;
    }

    public ObjectProperty<AlarmLevel> levelProperty() {
        return level;
    }

    public ObjectProperty<Integer> countProperty() {
        return count;
    }
}
