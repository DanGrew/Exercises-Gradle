package uk.dangrew.exercises.turbine_status.io;

import uk.dangrew.exercises.turbine_status.model.AlarmLevel;
import uk.dangrew.exercises.turbine_status.model.Turbine;

/**
 * Json description of an alarm count on a {@link Turbine}.
 */
public class JsonTurbineAlarm {
   
   private String turbine;
   private AlarmLevel level;
   private int count;
   
   public JsonTurbineAlarm(){
      
   }

   public String getTurbine() {
      return turbine;
   }

   public void setTurbine(String identifier) {
      this.turbine = identifier;
   }

   public AlarmLevel getLevel() {
      return level;
   }

   public void setLevel(AlarmLevel level) {
      //note ordinal value used to deserialize
      this.level = level;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }
}
