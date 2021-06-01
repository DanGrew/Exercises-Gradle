package uk.dangrew.exercises.turbine_status.events;

import javafx.collections.MapChangeListener;
import uk.dangrew.exercises.turbine_status.model.AlarmLevel;
import uk.dangrew.exercises.turbine_status.model.Turbine;

/**
 * Provides a specific {@link MapChangeListener} for receiving changes to {@link AlarmLevel} counts on {@link Turbine}s.
 */
public interface AlarmListener extends MapChangeListener<AlarmLevel, Integer> {

   @Override
   public void onChanged(
         Change<? extends AlarmLevel, ? extends Integer> change
   );
}
