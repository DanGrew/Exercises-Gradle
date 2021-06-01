package uk.dangrew.exercises.turbine_status.ui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uk.dangrew.exercises.turbine_status.model.AlarmLevel;
import uk.dangrew.exercises.turbine_status.model.Turbine;
import uk.dangrew.exercises.turbine_status.model.TurbineManager;

/**
 * Provides a definition of the table to display the alarms associated with {@link Turbine}s.
 */
public class AlarmTable extends TableView<AlarmTableEntry> {

    private final TurbineManager turbineManager;

    public AlarmTable(TurbineManager turbineManager) {
        this.turbineManager = turbineManager;

        initialiseTableColumns();
        initialiseTableData();
    }

    /**
     * Builds the columns of the table.
     */
    private void initialiseTableColumns() {
        TableColumn<AlarmTableEntry, String> identifierColumn = new TableColumn<>("Turbine");
        identifierColumn.setCellValueFactory(new PropertyValueFactory<>("identifier"));
        getColumns().add(identifierColumn);

        TableColumn<AlarmTableEntry, String> levelColumn = new TableColumn<>("Alarm");
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
        getColumns().add(levelColumn);

        TableColumn<AlarmTableEntry, String> countColumn = new TableColumn<>("Count");
        countColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        getColumns().add(countColumn);
    }

    /**
     * Initialises the data in the table, which we know has a consistent number of rows.
     */
    private void initialiseTableData() {
        for (Turbine turbine : turbineManager.getAll()) {
            for (AlarmLevel level : AlarmLevel.values()) {
                if (!level.isActive()) {
                    continue;
                }
                AlarmTableEntry entry = new AlarmTableEntry(turbine, level);
                getItems().add(entry);

                entry.countProperty().addListener((s, o, n) -> sort());
            }
        }
    }

}
