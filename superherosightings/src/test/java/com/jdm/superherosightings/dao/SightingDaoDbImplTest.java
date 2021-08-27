/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Location;
import com.jdm.superherosightings.entities.Sighting;
import com.jdm.superherosightings.entities.SuperPerson;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Joe
 */
@SpringBootTest
public class SightingDaoDbImplTest {
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    SuperPersonDao superPersonDao;
            
    Sighting sighting1, sighting2;
    Location location1, location2;
    SuperPerson hero, villain;
    
    public SightingDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        superPersonDao.getAllHeroes().forEach(hero -> {
            superPersonDao.deleteSuperById(hero.getSuperPersonId());
        });
        
        superPersonDao.getAllVillains().forEach(villain -> {
            superPersonDao.deleteSuperById(villain.getSuperPersonId());
        });
        
        locationDao.getAllLocations().forEach(location -> {
            locationDao.deleteLocationById(location.getLocationId());
        });
        
        sightingDao.getAllHeroSightings().forEach(heroSighting -> {
            sightingDao.deleteSightingById(heroSighting.getSightingId());
        });
        
        sightingDao.getAllHeroSightings().forEach(villainSighting -> {
            sightingDao.deleteSightingById(villainSighting.getSightingId());
        });
        
        location1 = new Location();
        location2 = new Location();
        
        location1.setAddress("Test Address");
        location1.setCity("Test City");
        location1.setCoordinates("(25,23)");
        location1.setDescription("Test Location Description");
        location1.setName("Test Location");
        location1.setState("Test State");
        
        location2.setAddress("Test Address 2");
        location2.setCity("Test City 2");
        location2.setCoordinates("(25,24)");
        location2.setDescription("Test Location Description 2");
        location2.setName("Test Location 2");
        location2.setState("Test State 2");
        
        location1 = locationDao.addLocation(location1);
        location2 = locationDao.addLocation(location2);
        
        hero = new SuperPerson();
        hero.setName("Test Hero");
        hero.setDescription("Test Hero Description");
        hero.setVillain(false);
        
        villain = new SuperPerson();
        villain.setName("Test Villain");
        villain.setDescription("Test Villain Description");
        villain.setVillain(true);
        
        hero = superPersonDao.addSuper(hero);
        villain = superPersonDao.addSuper(villain);
        
        sighting1 = new Sighting();
        sighting1.setSuperPersonId(hero.getSuperPersonId());
        sighting1.setLocationId(location1.getLocationId());
        sighting1.setSightingDate(Date.valueOf(LocalDate.now()));
        
        sighting2 = new Sighting();
        sighting2.setSuperPersonId(villain.getSuperPersonId());
        sighting2.setLocationId(location2.getLocationId());
        sighting2.setSightingDate(Date.valueOf(LocalDate.now()));
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSightingById method, of class SightingDaoDbImpl.
     */
    @Test
    public void testAddGetSightingById() {
        sighting1 = sightingDao.addSighting(sighting1);
        sighting2 = sightingDao.addSighting(sighting2);
        
        assertNotNull(sighting1);
        assertNotNull(sighting2);
        
        Sighting sighting1Get = sightingDao.getSightingById(sighting1.getSightingId());
        Sighting sighting2Get = sightingDao.getSightingById(sighting2.getSightingId());
        
        assertEquals(sighting1Get, sighting1);
        assertEquals(sighting2Get, sighting2);
        
    }

    /**
     * Test of getAllHeroSightings and getAllVillainSightings methods, of class SightingDaoDbImpl.
     */
    @Test
    public void testGetAllHeroVillainSightings() {
        sighting1 = sightingDao.addSighting(sighting1);
        sighting2 = sightingDao.addSighting(sighting2);
      
        assertNotNull(sighting1);
        assertNotNull(sighting2);
        assertNotNull(sightingDao.getAllHeroSightings());
        assertNotNull(sightingDao.getAllVillainSightings());
        assertEquals(1, sightingDao.getAllHeroSightings().size());
        assertEquals(1, sightingDao.getAllVillainSightings().size());
        assertEquals(sighting1, sightingDao.getAllHeroSightings().get(0));
        assertEquals(sighting2, sightingDao.getAllVillainSightings().get(0));
    }

    /**
     * Test of deleteSightingById method, of class SightingDaoDbImpl.
     */
    @Test
    public void testDeleteSightingById() {
        sighting1 = sightingDao.addSighting(sighting1);
        sighting2 = sightingDao.addSighting(sighting2);
        
        sightingDao.deleteSightingById(sighting1.getSightingId());
        assertNull(sightingDao.getSightingById(sighting1.getSuperPersonId()));
        assertEquals(sightingDao.getSightingById(sighting2.getSightingId()), sighting2);
        
    }

    /**
     * Test of editSighting method, of class SightingDaoDbImpl.
     */
    @Test
    public void testEditSighting() {
        sighting1 = sightingDao.addSighting(sighting1);
        sighting2 = sightingDao.addSighting(sighting2);
        
        sighting1.setLocationId(location2.getLocationId());
        
        sightingDao.editSighting(sighting1);
        assertEquals(sighting1, sightingDao.getSightingById(sighting1.getSightingId()));
    }
    
    @Test
    public void testGetSightingByLocDate(){
        sighting1 = sightingDao.addSighting(sighting1);
        sighting2 = sightingDao.addSighting(sighting2);
        
        List<Sighting> sightingGet = sightingDao.getAllSightingsAtLocationDate(sighting1.getLocationId(), sighting1.getSightingDate().toLocalDate());
        assertEquals(1,sightingGet.size());
    }
}
