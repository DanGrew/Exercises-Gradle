package uk.dangrew.exercises.turbine_status.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import uk.dangrew.exercises.turbine_status.io.AlarmRandomizer;
import uk.dangrew.exercises.turbine_status.model.ModelUpdater;
import uk.dangrew.exercises.turbine_status.model.TurbineManager;

/**
 * Top level pane that contains the alarm table and controls around it.
 */
public class TurbineAlarmStatusPane extends BorderPane {

   private final AlarmRandomizer alarmRandomizer;
   private final ModelUpdater modelUpdater;

   public TurbineAlarmStatusPane(TurbineManager turbineManager) {
      this.alarmRandomizer = new AlarmRandomizer();
      this.modelUpdater = new ModelUpdater(turbineManager);

      setCenter(new AlarmTable(turbineManager));
      
      Button inputGeneratorButton = new Button("Emulate Input");
      inputGeneratorButton.setOnAction(this::emulateInput);
      setBottom(inputGeneratorButton);
   }

   private void emulateInput(ActionEvent actionEvent) {
      modelUpdater.updateModel(alarmRandomizer.randomizeAlarms());
   }

}
