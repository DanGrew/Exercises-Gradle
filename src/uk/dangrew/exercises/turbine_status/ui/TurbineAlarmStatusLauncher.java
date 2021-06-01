package uk.dangrew.exercises.turbine_status.ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.dangrew.exercises.turbine_status.io.JsonTurbineAlarm;
import uk.dangrew.exercises.turbine_status.model.ModelUpdater;
import uk.dangrew.exercises.turbine_status.model.TurbineManager;

import java.util.List;

/**
 * Main class for launching the application.
 */
public class TurbineAlarmStatusLauncher extends Application {
   static final String TITLE = "Turbine Alarm Status";

   @Override
   public void start(Stage stage) throws Exception {
      TurbineManager turbineManager = new TurbineManager();
      initialiseExpectedData(turbineManager);

      stage.setTitle(TITLE);
      stage.setOnCloseRequest(event -> System.exit(1));
      TurbineAlarmStatusPane ui = new TurbineAlarmStatusPane(turbineManager);
      stage.setScene(new Scene(ui));
      stage.setMaximized(false);
      stage.show();
   }

   /**
    * Initialises some data we expect to be present.
    *
    * @param turbineManager to populate the data in.
    */
   private void initialiseExpectedData(TurbineManager turbineManager) {
      for(int i = 0; i < 100; i++) {
         turbineManager.create("T" + i);
      }
   }

   public static void main(String[] args) {
      launch();
   }
}
