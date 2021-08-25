/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Sighting;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface SightingDao {
    Sighting getSightingById(int heroSightingId);
    List<Sighting> getAllHeroSightings();
    List<Sighting> getAllVillainSightings();
    Sighting addSighting(Sighting heroSighting);
    void deleteSightingById(int heroSightingId); //boolean for verification?
    void editSighting(Sighting heroSighting);
}
