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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.dangrew.exercises.turbine_status.io.JsonTurbineAlarm;
import uk.dangrew.exercises.turbine_status.model.AlarmLevel;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonTurbineAlarmTest {

   @Test
   public void shouldParseTurbineAlarm() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      JsonTurbineAlarm jsonTurbineAlarm = mapper.readValue("{\"turbine\": \"T1\", \"level\": 1, \"count\": 2}", JsonTurbineAlarm.class);

      assertThat(jsonTurbineAlarm.getTurbine(), equalTo("T1"));
      assertThat(jsonTurbineAlarm.getLevel(), equalTo(AlarmLevel.WARNING));
      assertThat(jsonTurbineAlarm.getCount(), equalTo(2));
   }

}
