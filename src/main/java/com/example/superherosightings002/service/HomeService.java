package com.example.superherosightings002.service;

import com.example.superherosightings002.dao.*;
import com.example.superherosightings002.models.Hero;
import com.example.superherosightings002.models.Organization;
import com.example.superherosightings002.models.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Service
public class HomeService {

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

    public String buildUrl(HashMap<Sighting, Hero> heroSightins) {
        final String BASE_URL = "https://maps.googleapis.com/maps/api/staticmap?";

        int height = 600;
        int length = 300;
        final String SIZE = "size=" + height + "x" + length;

        // &maptype=roadmap
        String mapType = "roadmap";
        final String MAP_TYPE = "maptype=" + mapType;

        // &markers=color:blue%7Clabel:S%7C40.702147,-74.015794
        // &markers=color:green%7Clabel:G%7C40.711614,-74.012318
        // &markers=color:red%7Clabel:C%7C40.718217,-73.998284
        String markers = "";
        if (heroSightins != null) {
            for (Sighting sighting : heroSightins.keySet()) {
                markers += "&markers="

                        + "label:"
                        + heroSightins.get(sighting).getName().charAt(0)

                        + "%7C"

                        + sighting.getLocation().getLatitude()
                        + ","
                        + sighting.getLocation().getLongitude();
            }
        }

        final String KEY = "key=" + getApiKey();

        final String url = BASE_URL
                + SIZE
                + "&" + MAP_TYPE
                + markers // & is already included
                + "&" + KEY;

        return url;
    }

    private String getApiKey() {
        final String API_KEY_FILE_PATH = "../API_KEY.txt";
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(API_KEY_FILE_PATH)));
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error:" + e);
            return "";
        }

    }

    public int getNumberOfSuperheros() {
        int numberOfSuperheros = 0;
        List<Hero> heros = heroDao.getAllHeros();
        for (Hero hero : heros) {
            if (hero.isIsHero()) {
                numberOfSuperheros++;
            }
        }
        return numberOfSuperheros;
    }

    public int getNumberOfSupervillains() {
        int numberOfSupervillains = 0;
        List<Hero> heros = heroDao.getAllHeros();
        for (Hero hero : heros) {
            if (!hero.isIsHero()) {
                numberOfSupervillains++;
            }
        }
        return numberOfSupervillains;
    }

    public int getNumberOfHeroOrganization() {
        int numberOfHeroOrganization = 0;
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for (Organization organization : organizations) {
            if (organization.isIsHero()) {
                numberOfHeroOrganization++;
            }
        }
        return numberOfHeroOrganization;
    }

    public int getNumberOfVillainOrganization() {
        int numberOfVillainOrganization = 0;
        List<Organization> organizations = organizationDao.getAllOrganizations();
        for (Organization organization : organizations) {
            if (!organization.isIsHero()) {
                numberOfVillainOrganization++;
            }
        }
        return numberOfVillainOrganization;
    }

    public int getNumberOfLocations() {
        return locationDao.getAllLocations().size();
    }

    public int getNumberOfSightings() {
        return sightingDao.getAllSightings().size();
    }

    public int getNumberOfSuperpowers() {
        return superpowerDao.getAllSuperpowers().size();
    }
}
