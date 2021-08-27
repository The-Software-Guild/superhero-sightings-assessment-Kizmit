/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.SuperPerson;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface SuperPersonDao {
    SuperPerson getSuperById(int heroId);
    List<SuperPerson> getAllVillains();
    List<SuperPerson> getAllHeroes();
    SuperPerson addSuper(SuperPerson hero);
    void deleteSuperById(int heroId); //boolean for verification?
    void editSuper(SuperPerson hero);

    public SuperPerson getSuperPersonByName(String superPersonName);
}
