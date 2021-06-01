package uk.dangrew.exercises.turbine_status.model;

public class Turbine {

   private final String identifier;
   private final Alarms alarms;

   public Turbine(String identifier) {
      this.identifier = identifier;
      this.alarms = new Alarms();
   }

   public String getIdentifier() {
      return identifier;
   }

   public Alarms getAlarms() {
      return alarms;
   }
   
}
