package com.example.superherosightings002.dao;

import com.example.superherosightings002.models.Location;
import com.example.superherosightings002.models.Sighting;

import java.util.List;

public interface SightingDao {
    
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    Sighting addSighting(Sighting sighting);
    void updateSighting(Sighting sighting);
    void deleteSightingById(int id);
    
    List<Sighting> getSightingsForLocation(Location location);
}
