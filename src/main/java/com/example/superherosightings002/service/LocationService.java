package com.example.superherosightings002.service;

import com.example.superherosightings002.dao.*;
import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Location;
import com.example.superherosightings002.models.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    
    @Autowired
    HeroDao heroDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperpowerDao superpowerDao;
    
    // SERVICE FUNCTION
    public Location createLocation(String name, double latitude, double longitude, String description, String address){
        Location location = new Location();
        location.setName(name);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setDescription(description);
        location.setAddressInformation(address);
        
        return location;
    }
    
    public boolean isValidLatitude(String latitude){
        try{
            double value = Double.parseDouble(latitude);
            if(value<-90 || value>90){
                return false;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public boolean isValidLongitude(String longitude){
        try{
            double value = Double.parseDouble(longitude);
            if(value<-180 || value>180){
                return false;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    
    // EXTERNAL DAO FUNCTIONS  
    public List<Sighting> getSightingsForLocation(Location location){
        return sightingDao.getSightingsForLocation(location);
    }
    public List<Hero> getHerosForLocation(Location location){
        return heroDao.getHerosForLocation(location);
    }
    // LOCAL DAO FUNCTIONS  
    public Location getLocationById(int id){
        return locationDao.getLocationById(id);      
    }
    public List<Location> getAllLocations(){
        return locationDao.getAllLocations();
    }
    public Location addLocation(Location location){
        return locationDao.addLocation(location);
    }
    public void updateLocation(Location location){
        locationDao.updateLocation(location);
    }
    public void deleteLocationById(int id){
        locationDao.deleteLocationById(id);
    }
}
