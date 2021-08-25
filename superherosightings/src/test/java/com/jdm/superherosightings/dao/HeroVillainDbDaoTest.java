/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.HeroVillain;
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
public class HeroVillainDbDaoTest {
    
    @Autowired
    HeroVillainDao heroDao;
    
    HeroVillain hero, villain;
    
    
    public HeroVillainDbDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<HeroVillain> herovillains = heroDao.getAllHeroes();
        for(HeroVillain herovillain : herovillains) {
            heroDao.deleteHeroVillainById(herovillain.getHeroVillainId());
        }
        
        herovillains = heroDao.getAllVillains();
        for(HeroVillain herovillain : herovillains) {
            heroDao.deleteHeroVillainById(herovillain.getHeroVillainId());
        }
        
        hero = new HeroVillain();
        hero.setName("Test Hero");
        hero.setDescription("Test Hero Description");
        hero.setVillain(false);
        
        villain = new HeroVillain();
        villain.setName("Test Villain");
        villain.setDescription("Test Villain Description");
        villain.setVillain(true);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHeroVillainById method, of class HeroDaoDbImpl.
     */
    @Test
    public void testAddGetHeroById() {

        hero = heroDao.addHeroVillain(hero);
        villain = heroDao.addHeroVillain(villain);
        assertNotNull(hero);
        assertNotNull(villain);
        
        HeroVillain heroGet = heroDao.getHeroVillainById(hero.getHeroVillainId());
        HeroVillain villainGet = heroDao.getHeroVillainById(villain.getHeroVillainId());
        assertEquals(hero, heroGet);
        assertEquals(villain, villainGet);
    }

    /**
     * Test of getAllHeroes method, of class HeroDaoDbImpl.
     */
    @Test
    public void testGetAllHeroes() {
        hero = heroDao.addHeroVillain(hero);
        villain = heroDao.addHeroVillain(villain);
        assertNotNull(hero);
        assertNotNull(villain);
        
        List<HeroVillain> heroes = heroDao.getAllHeroes();
        assertEquals(heroes.size(), 1);
        assertEquals(heroes.get(0), hero);
        
        List<HeroVillain> villains = heroDao.getAllVillains();
        assertEquals(villains.size(), 1);
        assertEquals(villains.get(0), villain);
        
    }

    /**
     * Test of deleteHeroVillainById method, of class HeroDaoDbImpl.
     */
    @Test
    public void testDeleteHeroVillainById() {
        hero = heroDao.addHeroVillain(hero);
        villain = heroDao.addHeroVillain(villain);
        assertNotNull(hero);
        assertNotNull(villain);
        
        heroDao.deleteHeroVillainById(hero.getHeroVillainId());
        assertNull(heroDao.getHeroVillainById(hero.getHeroVillainId()));
        assertNotNull(heroDao.getHeroVillainById(villain.getHeroVillainId()));
        
        heroDao.deleteHeroVillainById(villain.getHeroVillainId());
        assertNull(heroDao.getHeroVillainById(villain.getHeroVillainId()));
    }

    /**
     * Test of editHeroVillain method, of class HeroDaoDbImpl.
     */
    @Test
    public void testEditHero() {
        hero = heroDao.addHeroVillain(hero);
        
        hero.setName("Edited Hero Name");

        heroDao.editHeroVillain(hero);
        
        assertEquals(hero, heroDao.getHeroVillainById(hero.getHeroVillainId()));
        assertEquals(heroDao.getHeroVillainById(hero.getHeroVillainId()).getName(), "Edited Hero Name");
    }
    
}
