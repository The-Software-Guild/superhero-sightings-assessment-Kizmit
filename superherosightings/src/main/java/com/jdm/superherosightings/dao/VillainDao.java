/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Villain;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface VillainDao {
    Villain getVillainById(int villainId);
    List<Villain> getAllVillains();
    Villain addVillain(Villain villain);
    void deleteVillainById(int villainId); //boolean for verification?
    void editVillain(Villain villain);
}
