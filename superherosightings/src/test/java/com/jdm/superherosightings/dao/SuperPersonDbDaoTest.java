/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.SuperPerson;
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
public class SuperPersonDbDaoTest {
    
    @Autowired
    SuperPersonDao superPersonDao;
    
    SuperPerson hero;
    SuperPerson villain;
    
    
    public SuperPersonDbDaoTest() {
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
        
        hero = new SuperPerson();
        hero.setName("Test Hero");
        hero.setDescription("Test Hero Description");
        hero.setVillain(false);
        
        villain = new SuperPerson();
        villain.setName("Test Villain");
        villain.setDescription("Test Villain Description");
        villain.setVillain(true);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSuperById method, of class HeroDaoDbImpl.
     */
    @Test
    public void testAddGetHeroById() {

        hero = superPersonDao.addSuper(hero);
        villain = superPersonDao.addSuper(villain);
        assertNotNull(hero);
        assertNotNull(villain);
        
        SuperPerson heroGet = superPersonDao.getSuperById(hero.getSuperPersonId());
        SuperPerson villainGet = superPersonDao.getSuperById(villain.getSuperPersonId());
        assertEquals(hero, heroGet);
        assertEquals(villain, villainGet);
    }

    /**
     * Test of getAllHeroes method, of class HeroDaoDbImpl.
     */
    @Test
    public void testGetAllHeroes() {
        hero = superPersonDao.addSuper(hero);
        villain = superPersonDao.addSuper(villain);
        assertNotNull(hero);
        assertNotNull(villain);
        
        List<SuperPerson> heroes = superPersonDao.getAllHeroes();
        assertEquals(heroes.size(), 1);
        assertEquals(heroes.get(0), hero);
        
        List<SuperPerson> villains = superPersonDao.getAllVillains();
        assertEquals(villains.size(), 1);
        assertEquals(villains.get(0), villain);
        
    }

    /**
     * Test of deleteSuperById method, of class HeroDaoDbImpl.
     */
    @Test
    public void testDeleteSuperPersonById() {
        hero = superPersonDao.addSuper(hero);
        villain = superPersonDao.addSuper(villain);
        assertNotNull(hero);
        assertNotNull(villain);
        
        superPersonDao.deleteSuperById(hero.getSuperPersonId());
        assertNull(superPersonDao.getSuperById(hero.getSuperPersonId()));
        assertNotNull(superPersonDao.getSuperById(villain.getSuperPersonId()));
        
        superPersonDao.deleteSuperById(villain.getSuperPersonId());
        assertNull(superPersonDao.getSuperById(villain.getSuperPersonId()));
    }

    /**
     * Test of editSuper method, of class HeroDaoDbImpl.
     */
    @Test
    public void testEditHero() {
        hero = superPersonDao.addSuper(hero);
        
        hero.setName("Edited Hero Name");

        superPersonDao.editSuper(hero);
        
        assertEquals(hero, superPersonDao.getSuperById(hero.getSuperPersonId()));
        assertEquals(superPersonDao.getSuperById(hero.getSuperPersonId()).getName(), "Edited Hero Name");
    }
    
}
