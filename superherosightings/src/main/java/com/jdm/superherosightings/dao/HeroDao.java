/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Hero;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface HeroDao {
    Hero getHeroById(int heroId);
    List<Hero> getAllHeroes();
    Hero addHero(Hero hero);
    void deleteHeroById(int heroId); //boolean for verification?
    void editHero(Hero hero);
}
