package com.example.superherosightings002.dao;

import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Organization;

import java.util.List;

public interface OrganizationDao {
    
    Organization getOrganizationById(int id);
    List<Organization> getAllOrganizations();
    Organization addOrganization(Organization organization);
    void updateOrganization(Organization organization);
    void deleteOrganizationById(int id);
    
    List<Organization> getOrganizationsForHero(Hero hero);
}
