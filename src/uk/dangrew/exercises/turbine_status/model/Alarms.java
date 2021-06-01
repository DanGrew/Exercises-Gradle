package uk.dangrew.exercises.turbine_status.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import uk.dangrew.exercises.turbine_status.events.AlarmListener;

/**
 * Encapsulates the alarm data associated with a turbine.
 */
public class Alarms {

   private final ObservableMap<AlarmLevel, Integer> alarms;

   public Alarms() {
      this.alarms = FXCollections.observableHashMap();
   }

   /**
    * Clears the alarms currently held for the associated {@link Turbine}.
    */
   void clearAlarms() {
      this.alarms.clear();
   }

   /**
    * Records the number of alarms of the given type the associated {@link Turbine} has. Note this will replace any existing alarm count recorded.
    *
    * @param level the level of the alarms.
    * @param count the number of alarms at the level the {@link Turbine} has.
    */
   void recordAlarm(AlarmLevel level, int count) {
      alarms.put(level, count);
   }

   public int getAlarmCountFor(AlarmLevel level) {
      return alarms.getOrDefault(level, 0);
   }
   
   public void addAlarmListener(AlarmListener listener){
      alarms.addListener(listener);
   }
}
