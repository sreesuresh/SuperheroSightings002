package com.example.superherosightings002.service;

import com.example.superherosightings002.dao.*;
import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Superpower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperpowerService {
    
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
    public Superpower createSuperpower(String name, String description){
        Superpower superpower = new Superpower();
        superpower.setName(name);
        superpower.setDescription(description);

        return superpower;
    }
    
    // EXTERNAL DAO FUNCTIONS  
    public List<Hero> getHerosForSuperpower(Superpower superpower){
        return heroDao.getHerosForSuperpower(superpower);
    }
    // LOCAL DAO FUNCTIONS  
    public Superpower getSuperpowerById(int id){
        return superpowerDao.getSuperpowerById(id);      
    }
    public List<Superpower> getAllSuperpowers(){
        return superpowerDao.getAllSuperpowers();
    }
    public Superpower addSuperpower(Superpower superpower){
        return superpowerDao.addSuperpower(superpower);
    }
    public void updateSuperpower(Superpower superpower){
        superpowerDao.updateSuperpower(superpower);
    }
    public void deleteSuperpowerById(int id){
        superpowerDao.deleteSuperpowerById(id);
    }
}
