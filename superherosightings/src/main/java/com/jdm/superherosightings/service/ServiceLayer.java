/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.service;

import com.jdm.superherosightings.dao.LocationDao;
import com.jdm.superherosightings.dao.OrganizationDao;
import com.jdm.superherosightings.dao.PowerDao;
import com.jdm.superherosightings.dao.SightingDao;
import com.jdm.superherosightings.dao.SuperPersonDao;
import com.jdm.superherosightings.entities.Sighting;
import com.jdm.superherosightings.entities.SuperPerson;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */

@Component
public class ServiceLayer {
    @Autowired
    LocationDao locDao;
    
    @Autowired
    OrganizationDao orgDao;
    
    @Autowired
    PowerDao powerDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperPersonDao superPersonDao;
    
    public List<Sighting> getSightings() {
        List<Sighting> sightings = sightingDao.getAllVillainSightings();
        
        sightings.forEach(sighting ->{
            sighting.setSuperPerson(superPersonDao.getSuperById(sighting.getSuperPersonId()));
            sighting.setLocation(locDao.getLocationById(sighting.getLocationId()));
            sighting.setOrganizations(sighting.getSuperPerson().getOrganizations());
        });
        
        return sightings;
    }

    public List<SuperPerson> getVillains() {
        return superPersonDao.getAllVillains();
    }
    

}
