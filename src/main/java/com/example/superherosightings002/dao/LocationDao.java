package com.example.superherosightings002.dao;

import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Location;

import java.util.List;

public interface LocationDao {
    
    Location getLocationById(int id);
    List<Location> getAllLocations();
    Location addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(int id);
    
    List<Location> getLocationsForHero(Hero hero);
}
