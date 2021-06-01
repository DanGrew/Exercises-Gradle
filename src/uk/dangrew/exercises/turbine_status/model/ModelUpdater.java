package uk.dangrew.exercises.turbine_status.model;

import uk.dangrew.exercises.turbine_status.io.JsonTurbineAlarm;

import java.util.List;
import java.util.Optional;

public class ModelUpdater {

   private final TurbineManager turbineManager;

   public ModelUpdater(TurbineManager turbineManager) {
      this.turbineManager = turbineManager;
   }

   public void update(List<JsonTurbineAlarm> alarms) {
      alarms.stream()
            .map(JsonTurbineAlarm::getTurbine)
            .map(turbineManager::getTurbine)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(Turbine::getAlarms)
            .forEach(Alarms::clearAlarms);
      
      for(JsonTurbineAlarm alarm : alarms) {
         Optional<Turbine> turbine = turbineManager.getTurbine(alarm.getTurbine());
         if ( turbine.isEmpty()){
            turbine = turbineManager.create(turbine.get().getIdentifier());
         }
         
         if ( turbine.isEmpty()){
            //report an error, handle exception or throw another exception for better handling elsewhere
            continue;
         }
         
         turbine.get().getAlarms().recordAlarm(alarm.getLevel(), alarm.getCount());
      }
   }
}
