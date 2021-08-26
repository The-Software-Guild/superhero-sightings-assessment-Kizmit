/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;



/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */

public class Sighting {
    private int sightingId, superPersonId, locationId;
    private SuperPerson superPerson;
    private Location location;
    private Timestamp sightingTime;
    private List<Organization> organizations;
 

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public int getSuperPersonId() {
        return superPersonId;
    }

    public void setSuperPersonId(int superPersonId) {
        this.superPersonId = superPersonId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public SuperPerson getSuperPerson() {
        return superPerson;
    }

    public void setSuperPerson(SuperPerson superPerson) {
        this.superPerson = superPerson;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Timestamp getSightingTime() {
        return sightingTime;
    }

    public void setSightingTime(Timestamp sightingTime) {
        this.sightingTime = sightingTime;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.sightingId;
        hash = 83 * hash + this.superPersonId;
        hash = 83 * hash + this.locationId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (this.superPersonId != other.superPersonId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        return true;
    }

 



    
    
}
