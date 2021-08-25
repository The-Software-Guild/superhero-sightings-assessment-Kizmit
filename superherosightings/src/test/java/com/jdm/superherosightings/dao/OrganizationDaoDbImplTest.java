/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Location;
import com.jdm.superherosightings.entities.Organization;
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
public class OrganizationDaoDbImplTest {
   
    @Autowired
    LocationDao locDao;
    
    @Autowired
    OrganizationDao orgDao;
    
    Organization org1, org2;
    
    Location location1, location2;
    public OrganizationDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        orgDao.getAllOrganizations().forEach(org -> {
            orgDao.deleteOrganizationById(org.getOrganizationId());
        });

        locDao.getAllLocations().forEach(location -> {
            locDao.deleteLocationById(location.getLocationId());
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
        
        location1 = locDao.addLocation(location1);
        location2 = locDao.addLocation(location2);
        
        org1 = new Organization();
        org1.setLocationId(location1.getLocationId());
        org1.setType("Villain");
        org1.setName("Villain Organization");
        org1.setDescription("Villain Organization Description");
        
        org2 = new Organization();
        org2.setLocationId(location2.getLocationId());
        org2.setType("Hero");
        org2.setName("Hero Organization");
        org2.setDescription("Hero Organization Description");
        

    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getOrganizationById method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testAddGetOrganizationById() {
        org1 = orgDao.addOrganization(org1);
        org2 = orgDao.addOrganization(org2);
        
        assertNotNull(org1);
        assertNotNull(org2);
        
        Organization org1Get = orgDao.getOrganizationById(org1.getOrganizationId());
        Organization org2Get = orgDao.getOrganizationById(org2.getOrganizationId());
        
        assertEquals(org1, org1Get);
        assertEquals(org2, org2Get);
    }

    /**
     * Test of getAllOrganizations method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testGetAllOrganizations() {
        org1 = orgDao.addOrganization(org1);
        org2 = orgDao.addOrganization(org2);
        
        assertNotNull(org1);
        assertNotNull(org2);
        
        List<Organization> organizations = orgDao.getAllOrganizations();
        assertEquals(2, organizations.size());
        assertEquals(organizations.get(0), org1);
        assertEquals(organizations.get(1), org2);
    }

    /**
     * Test of deleteOrganizationById method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testDeleteOrganizationById() {
        org1 = orgDao.addOrganization(org1);
        org2 = orgDao.addOrganization(org2);
        assertNotNull(org1);
        assertNotNull(org2);
        
        orgDao.deleteOrganizationById(org1.getOrganizationId());
        assertNull(orgDao.getOrganizationById(org1.getOrganizationId()));
        assertNotNull(orgDao.getOrganizationById(org2.getOrganizationId()));
        
        orgDao.deleteOrganizationById(org2.getOrganizationId());
        assertNull(orgDao.getOrganizationById(org2.getOrganizationId()));
    }

    /**
     * Test of editOrganization method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testEditOrganization() {
        org1 = orgDao.addOrganization(org1);
        
        org1.setDescription("NEW DESCRIPTION");
        
        orgDao.editOrganization(org1);
        
        assertEquals(org1, orgDao.getOrganizationById(org1.getOrganizationId()));
        assertEquals(orgDao.getOrganizationById(org1.getOrganizationId()).getDescription(), "NEW DESCRIPTION");
    }
    
}
