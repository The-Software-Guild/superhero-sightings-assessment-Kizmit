/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Location;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface LocationDao {
    Location getLocationById(int locationId);
    List<Location> getAllLocations();
    Location addLocation(Location location);
    void deleteLocationById(int locationId); //boolean for verification?
    void editLocation(Location location);
}
