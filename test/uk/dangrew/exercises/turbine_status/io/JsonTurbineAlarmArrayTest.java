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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonTurbineAlarmArrayTest {
   
   @Test
   public void shouldParseUpdate() throws JsonProcessingException {
      String input = 
            "[" +
            "{\"turbine\": \"T1\", \"level\": 1, \"count\": 2}," +
            "{\"turbine\": \"T6\", \"level\": 2, \"count\": 1}," +
            "{\"turbine\": \"T13\", \"level\": 1, \"count\": 1}," +
            "{\"turbine\": \"T13\", \"level\": 2, \"count\": 1}," +
            "{\"turbine\": \"T25\", \"level\": 2, \"count\": 3}," +
            "{\"turbine\": \"T43\", \"level\": 1, \"count\": 2}," +
            "{\"turbine\": \"T44\", \"level\": 1, \"count\": 4}," +
            "{\"turbine\": \"T44\", \"level\": 2, \"count\": 1}," +
            "{\"turbine\": \"T67\", \"level\": 2, \"count\": 2}," +
            "{\"turbine\": \"T82\", \"level\": 1, \"count\": 1}" +
            "]";

      ObjectMapper mapper = new ObjectMapper();
      List<JsonTurbineAlarm> update = mapper.readValue(input, new TypeReference<>() {});

      assertThat(update.get(0).getTurbine(), equalTo("T1"));
      assertThat(update.get(1).getTurbine(), equalTo("T6"));
      assertThat(update.get(2).getTurbine(), equalTo("T13"));
      assertThat(update.get(3).getTurbine(), equalTo("T13"));
      assertThat(update.get(4).getTurbine(), equalTo("T25"));
      assertThat(update.get(5).getTurbine(), equalTo("T43"));
      assertThat(update.get(6).getTurbine(), equalTo("T44"));
      assertThat(update.get(7).getTurbine(), equalTo("T44"));
      assertThat(update.get(8).getTurbine(), equalTo("T67"));
      assertThat(update.get(9).getTurbine(), equalTo("T82"));
   }

}