/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.HeroSighting;
import java.util.List;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
@Repository
public class HeroSightingDaoDbImpl implements HeroSightingDao {

    @Override
    public HeroSighting getHeroSightingById(int heroSightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HeroSighting> getAllHeroSightings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HeroSighting addHeroSighting(HeroSighting heroSighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteHeroSightingById(int heroSightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editHeroSighting(HeroSighting heroSighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
