/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.HeroSighting;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface HeroSightingDao {
    HeroSighting getHeroSightingById(int heroSightingId);
    List<HeroSighting> getAllHeroSightings();
    HeroSighting addHeroSighting(HeroSighting heroSighting);
    void deleteHeroSightingById(int heroSightingId); //boolean for verification?
    void editHeroSighting(HeroSighting heroSighting);
}
