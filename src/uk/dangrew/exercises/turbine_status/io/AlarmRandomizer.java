package uk.dangrew.exercises.turbine_status.io;

import uk.dangrew.exercises.turbine_status.model.AlarmLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Provides a simple mechanism for emulating input to the model, randomly generating json data as if received from an external server.
 */
public class AlarmRandomizer {

    private static final int AMOUNT_TO_RANDOMIZE = 40;

    private final Random random;
    private final int amountToRandomize;

    public AlarmRandomizer() {
        this(AMOUNT_TO_RANDOMIZE, new Random());
    }

    AlarmRandomizer(int amountToRandomize, Random random) {
        this.random = random;
        this.amountToRandomize = amountToRandomize;
    }

    public List<JsonTurbineAlarm> randomizeAlarms() {
        List<JsonTurbineAlarm> input = new ArrayList<>();
        for (int i = 0; i < amountToRandomize; i++) {
            JsonTurbineAlarm alarm = new JsonTurbineAlarm();
            alarm.setTurbine("T" + random.nextInt(100));
            alarm.setCount(random.nextInt(5));
            alarm.setLevel(random.nextBoolean() ? AlarmLevel.WARNING : AlarmLevel.CRITICAL);

            input.add(alarm);
        }
        return input;
    }
}
