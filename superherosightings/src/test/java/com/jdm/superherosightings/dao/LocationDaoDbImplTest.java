/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Location;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Joe
 */

@SpringBootTest
public class LocationDaoDbImplTest {
    @Autowired
    JdbcTemplate jdbc;    
    
    @Autowired
    LocationDao locationDao;
    
    Location location1, location2;
    
    public LocationDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Location> locations = locationDao.getAllLocations();
        for(Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }
        
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getLocationById method, of class LocationDaoDbImpl.
     */
    @Test
    public void testAddGetLocationById() {
        location1 = locationDao.addLocation(location1);
        location2 = locationDao.addLocation(location2);
        
        assertNotNull(location1);
        assertNotNull(location2);
        
        Location location1Get = locationDao.getLocationById(location1.getLocationId());
        Location location2Get = locationDao.getLocationById(location2.getLocationId());
        
        assertEquals(location1Get, location1);
        assertEquals(location2Get, location2);
    }

    /**
     * Test of getAllLocations method, of class LocationDaoDbImpl.
     */
    @Test
    public void testGetAllLocations() {
        locationDao.addLocation(location1);
        locationDao.addLocation(location2);
        
        List<Location> locations = locationDao.getAllLocations();
        
        assertNotNull(locations);
        assertEquals(2, locations.size());
        assertEquals(locations.get(0), location1);
        assertEquals(locations.get(1), location2);
    }

    /**
     * Test of deleteLocationById method, of class LocationDaoDbImpl.
     */
    @Test
    public void testDeleteLocationById() {
        Location location1Ret = locationDao.addLocation(location1);
        Location location2Ret = locationDao.addLocation(location2);
        
        locationDao.deleteLocationById(location1Ret.getLocationId());
        
        assertNull(locationDao.getLocationById(location1Ret.getLocationId()));
        assertNotNull(locationDao.getLocationById(location2Ret.getLocationId()));
    }

    /**
     * Test of editLocation method, of class LocationDaoDbImpl.
     */
    @Test
    public void testEditLocation() {
        location1 = locationDao.addLocation(location1);
        location1.setAddress("different address");
        
        locationDao.editLocation(location1);
        
        assertEquals(location1, locationDao.getLocationById(location1.getLocationId()));
        assertEquals(location1.getAddress(), locationDao.getLocationById(location1.getLocationId()).getAddress(), "different address");
        
    }
    
    
}
