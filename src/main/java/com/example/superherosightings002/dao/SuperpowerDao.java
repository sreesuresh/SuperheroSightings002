package com.example.superherosightings002.dao;

import com.example.superherosightings002.models.Superpower;

import java.util.List;

public interface SuperpowerDao {
    
    Superpower getSuperpowerById(int id);
    List<Superpower> getAllSuperpowers();
    Superpower addSuperpower(Superpower superpower);
    void updateSuperpower(Superpower superpower);
    void deleteSuperpowerById(int id);
    
}
