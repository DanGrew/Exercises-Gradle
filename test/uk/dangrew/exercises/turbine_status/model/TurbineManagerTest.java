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

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TurbineManagerTest {

   private TurbineManager systemUnderTest;

   @BeforeEach
   public void initialiseSystemUnderTest() {
      systemUnderTest = new TurbineManager();
   }

   @Test
   public void shouldProvideTurbineByIdentifier() {
      Optional<Turbine> first = systemUnderTest.create("First");
      Optional<Turbine> second = systemUnderTest.create("Second");

      assertThat(systemUnderTest.getTurbine("First").get(), equalTo(first.get()));
      assertThat(systemUnderTest.getTurbine("Second").get(), equalTo(second.get()));
   }
   
   @Test
   public void shouldNotDuplicateTurbineWhenCreatingWithSameIdentifier() {
      assertThat(systemUnderTest.create("unique").isPresent(), equalTo(true));
      assertThat(systemUnderTest.create("unique").isPresent(), equalTo(false));
   }

}