package uk.dangrew.exercises.turbine_status.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import static java.util.Collections.unmodifiableCollection;

/**
 * Provides a simplistic mechanism for managing {@link Turbine}s, to be thought of the most simple database.
 */
public class TurbineManager {

   private final Map<String, Turbine> turbines;

   public TurbineManager() {
      this.turbines = new TreeMap<>();
   }

   public Optional<Turbine> getTurbine(String identifier) {
      return Optional.ofNullable(turbines.get(identifier));
   }

   /**
    * Creates a new {@link Turbine} only if one does not already exist, using the identifier as a unique key.
    *
    * @param identifier of the {@link Turbine} to create.
    * @return the created {@link Turbine}, if successful.
    */
   public Optional<Turbine> create(String identifier) {
      if(turbines.containsKey(identifier)) {
         //either log errors or use an exception mechanism to handle properly elsewhere
         return Optional.empty();
      }

      Turbine turbine = new Turbine(identifier);
      turbines.put(turbine.getIdentifier(), turbine);
      return Optional.of(turbine);
   }

   public Collection<Turbine> getAll() {
      return unmodifiableCollection(turbines.values());
   }
}
