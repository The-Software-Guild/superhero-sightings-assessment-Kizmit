/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.HeroVillain;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface HeroVillainDao {
    HeroVillain getHeroVillainById(int heroId);
    List<HeroVillain> getAllVillains();
    List<HeroVillain> getAllHeroes();
    HeroVillain addHeroVillain(HeroVillain hero);
    void deleteHeroVillainById(int heroId); //boolean for verification?
    void editHeroVillain(HeroVillain hero);
}
