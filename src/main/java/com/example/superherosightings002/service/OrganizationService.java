package com.example.superherosightings002.service;

import com.example.superherosightings002.dao.*;
import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    
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
    public Organization createOrganization(String name, boolean isHero, String description, String address, String contact, List<Hero> heros){
        Organization organization = new Organization();
        organization.setName(name);
        organization.setIsHero(isHero);
        organization.setDescription(description);
        organization.setAddress(address);
        organization.setContact(contact);
        organization.setMembers(heros);

        return organization;
    }
    
    
    // EXTERNAL DAO FUNCTIONS  

    // LOCAL DAO FUNCTIONS  
    public Organization getOrganizationById(int id){
        return organizationDao.getOrganizationById(id);      
    }
    public List<Organization> getAllOrganizations(){
        return organizationDao.getAllOrganizations();
    }
    public Organization addOrganization(Organization organization){
        return organizationDao.addOrganization(organization);
    }
    public void updateOrganization(Organization organization){
        organizationDao.updateOrganization(organization);
    }
    public void deleteOrganizationById(int id){
        organizationDao.deleteOrganizationById(id);
    }
}
