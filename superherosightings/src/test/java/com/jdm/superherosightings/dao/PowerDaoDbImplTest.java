package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Power;
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
public class PowerDaoDbImplTest {

    @Autowired
    PowerDao powerDao;

    Power power1, power2;

    public PowerDaoDbImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        powerDao.getAllPowers().forEach(power -> {
            powerDao.deletePowerById(power.getPowerId());
        });

        power1 = new Power();
        power2 = new Power();

        power1.setName("Test Power 1");
        power1.setDescription("Test Power 1 Description");

        power2.setName("Test Power 2");
        power2.setDescription("Test Power 2 Description");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPowerById method, of class PowerDaoDbImpl.
     */
    @Test
    public void testAddGetPowerById() {
        power1 = powerDao.addPower(power1);
        power2 = powerDao.addPower(power2);

        assertNotNull(power1);
        assertNotNull(power2);

        Power power1Get = powerDao.getPowerById(power1.getPowerId());
        Power power2Get = powerDao.getPowerById(power2.getPowerId());

        assertEquals(power1Get, power1);
        assertEquals(power2Get, power2);
    }

    /**
     * Test of getAllPowers method, of class PowerDaoDbImpl.
     */
    @Test
    public void testGetAllPowers() {
        power1 = powerDao.addPower(power1);
        power2 = powerDao.addPower(power2);
        
        assertNotNull(powerDao.getAllPowers());
        assertEquals(2, powerDao.getAllPowers().size());
        assertEquals(power1, powerDao.getAllPowers().get(0));
        assertEquals(power2, powerDao.getAllPowers().get(1));
    }

    /**
     * Test of deletePowerById method, of class PowerDaoDbImpl.
     */
    @Test
    public void testDeletePowerById() {
        power1 = powerDao.addPower(power1);
        power2 = powerDao.addPower(power2);
        
        powerDao.deletePowerById(power1.getPowerId());
        assertNull(powerDao.getPowerById(power1.getPowerId()));
        assertNotNull(powerDao.getPowerById(power2.getPowerId()));
        powerDao.deletePowerById(power2.getPowerId());
        assertNull(powerDao.getPowerById(power2.getPowerId()));
        assertEquals(0, powerDao.getAllPowers().size());
    }

    /**
     * Test of editPower method, of class PowerDaoDbImpl.
     */
    @Test
    public void testEditPower() {
        power1 = powerDao.addPower(power1);
        power2 = powerDao.addPower(power2);
        
        power1.setDescription("EDITED POWER DESCRIPTION");
        
        powerDao.editPower(power1);
        assertEquals(powerDao.getPowerById(power1.getPowerId()), power1);
        assertEquals(powerDao.getPowerById(power1.getPowerId()).getDescription(), power1.getDescription());
    }

}
