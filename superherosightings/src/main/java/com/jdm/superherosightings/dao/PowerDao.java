/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Power;
import java.util.List;
/**
 *
 * @author Joe
 */
public interface PowerDao {
    Power getPowerById(int powerId);
    List<Power> getAllPowers();
    Power addPower(Power power);
    void deletePowerById(int powerId); //boolean for verification?
    void editPower(Power power);
}
