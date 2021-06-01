// **************************************************
//                        GSDK                       
//           Graffica System Development Kit         
//                                                   
//  Release Version: {RELEASE_VERSION}               
//  Copyright: (c) Graffica Ltd {RELEASE_DATE}       
//                                                   
// **************************************************
//  This software is provided under the terms of the 
//        Graffica Software Licence Agreement        
//                                                   
//     THIS HEADER MUST NOT BE ALTERED OR REMOVED    
// **************************************************

package uk.dangrew.exercises.turbine_status.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.dangrew.exercises.turbine_status.io.JsonTurbineAlarm;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModelUpdaterTest {

    private Turbine turbine;
    private TurbineManager turbineManager;
    private ModelUpdater systemUnderTest;

    @BeforeEach
    public void initialiseSystemUnderTest() {
        turbineManager = new TurbineManager();
        turbine = turbineManager.create("Turbine").get();
        systemUnderTest = new ModelUpdater(turbineManager);
    }

    @Test
    public void shouldUpdateTurbine() {
        assertThat(turbine.getAlarms().getAlarmCountFor(AlarmLevel.WARNING), equalTo(0));
        
        JsonTurbineAlarm alarm = new JsonTurbineAlarm();
        alarm.setTurbine(turbine.getIdentifier());
        alarm.setLevel(AlarmLevel.WARNING);
        alarm.setCount(10);

        systemUnderTest.updateModel(Collections.singletonList(alarm));
        assertThat(turbine.getAlarms().getAlarmCountFor(AlarmLevel.WARNING), equalTo(10));
    }

    @Test
    public void shouldClearAlarmsOnUpdate() {
        JsonTurbineAlarm alarm = new JsonTurbineAlarm();
        alarm.setTurbine(turbine.getIdentifier());
        alarm.setLevel(AlarmLevel.WARNING);
        alarm.setCount(10);

        systemUnderTest.updateModel(Collections.singletonList(alarm));
        assertThat(turbine.getAlarms().getAlarmCountFor(AlarmLevel.WARNING), equalTo(10));
        
        systemUnderTest.updateModel(Collections.emptyList());
        assertThat(turbine.getAlarms().getAlarmCountFor(AlarmLevel.WARNING), equalTo(0));
    }
}