package uk.dangrew.exercises.turbine_status.model;

import uk.dangrew.exercises.turbine_status.io.JsonTurbineAlarm;

import java.util.List;
import java.util.Optional;

/**
 * Objects with responsibility for applying state changes to the model, for example alarms on {@link Turbine}s.
 */
public class ModelUpdater {

    private final TurbineManager turbineManager;

    public ModelUpdater(TurbineManager turbineManager) {
        this.turbineManager = turbineManager;
    }

    public void updateModel(List<JsonTurbineAlarm> alarms) {
        turbineManager.getAll().stream()
                .map(Turbine::getAlarms)
                .forEach(Alarms::clearAlarms);

        for (JsonTurbineAlarm alarm : alarms) {
            Optional<Turbine> turbine = turbineManager.getTurbine(alarm.getTurbine());
            if (turbine.isEmpty()) {
                //should never be the case, but defensive by default
                turbine = turbineManager.create(alarm.getTurbine());
            }

            if (turbine.isEmpty()) {
                //report an error, handle exception or throw another exception for better handling elsewhere
                continue;
            }

            turbine.get().getAlarms()
                    .recordAlarm(alarm.getLevel(), alarm.getCount());
        }
    }
}
