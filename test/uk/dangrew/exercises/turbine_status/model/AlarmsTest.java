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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlarmsTest {

   private Alarms systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new Alarms();
   }

   @Test
   public void shouldRecordAlarms() {
      assertThat(systemUnderTest.getAlarmCountFor(AlarmLevel.WARNING), equalTo(0));
      assertThat(systemUnderTest.getAlarmCountFor(AlarmLevel.CRITICAL), equalTo(0));

      systemUnderTest.recordAlarm(AlarmLevel.WARNING, 2);
      systemUnderTest.recordAlarm(AlarmLevel.CRITICAL, 10);

      assertThat(systemUnderTest.getAlarmCountFor(AlarmLevel.WARNING), equalTo(2));
      assertThat(systemUnderTest.getAlarmCountFor(AlarmLevel.CRITICAL), equalTo(10));
   }

   @Test
   public void shouldClearAlarms() {
      systemUnderTest.recordAlarm(AlarmLevel.WARNING, 2);
      systemUnderTest.recordAlarm(AlarmLevel.CRITICAL, 10);

      systemUnderTest.clearAlarms();
      
      assertThat(systemUnderTest.getAlarmCountFor(AlarmLevel.WARNING), equalTo(0));
      assertThat(systemUnderTest.getAlarmCountFor(AlarmLevel.CRITICAL), equalTo(0));
   }

}