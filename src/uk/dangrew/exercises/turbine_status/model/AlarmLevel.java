package uk.dangrew.exercises.turbine_status.model;

/**
 * Defines the types of alarms a {@link Turbine} can have.
 */
public enum AlarmLevel {

    NONE(false),
    WARNING(true),
    CRITICAL(true);

    private final boolean isActive;

    private AlarmLevel(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Provides whether this level describes and active alarm.
     *
     * @return true if active.
     */
    public boolean isActive() {
        return isActive;
    }
}
