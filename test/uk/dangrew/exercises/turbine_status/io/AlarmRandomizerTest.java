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

package uk.dangrew.exercises.turbine_status.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.dangrew.exercises.turbine_status.model.AlarmLevel;

import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlarmRandomizerTest {
   
   @Mock private Random random;
   private AlarmRandomizer systemUnderTest;
   
   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new AlarmRandomizer(3, random);
   }
   
   @Test
   public void shouldRandomizeAlarmsUsingRandom() {
      lenient().when(random.nextInt(100))
               .thenReturn(20)
               .thenReturn(15)
               .thenReturn(2);
      lenient().when(random.nextInt(5))
            .thenReturn(4)
            .thenReturn(14)
            .thenReturn(1);
      when(random.nextBoolean())
            .thenReturn(true)
            .thenReturn(false)
            .thenReturn(true);

      List<JsonTurbineAlarm> result = systemUnderTest.randomizeAlarms();
      assertThat(result.size(), equalTo(3));
      
      assertThat(result.get(0).getTurbine(), equalTo("T20"));
      assertThat(result.get(0).getLevel(), equalTo(AlarmLevel.WARNING));
      assertThat(result.get(0).getCount(), equalTo(4));

      assertThat(result.get(1).getTurbine(), equalTo("T15"));
      assertThat(result.get(1).getLevel(), equalTo(AlarmLevel.CRITICAL));
      assertThat(result.get(1).getCount(), equalTo(14));

      assertThat(result.get(2).getTurbine(), equalTo("T2"));
      assertThat(result.get(2).getLevel(), equalTo(AlarmLevel.WARNING));
      assertThat(result.get(2).getCount(), equalTo(1));
   }

}