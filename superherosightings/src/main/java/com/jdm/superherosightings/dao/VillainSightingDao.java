/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.VillainSighting;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface VillainSightingDao {
    VillainSighting getVillainSightingById(int villainSightingId);
    List<VillainSighting> getAllVillainSightings();
    VillainSighting addVillainSighting(VillainSighting villainSighting);
    void deleteVillainSightingById(int villainSightingId); //boolean for verification?
    void editVillainSighting(VillainSighting villainSighting);
}
