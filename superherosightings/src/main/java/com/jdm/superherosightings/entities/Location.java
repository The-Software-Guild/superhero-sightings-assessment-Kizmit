/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.entities;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class Location {
    private int locationId;
    private String locationName, locationCity, locationState, locationAddress, locationCoord, locationDesc;
    private HeroSighting sightings[];

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationCoord() {
        return locationCoord;
    }

    public void setLocationCoord(String locationCoord) {
        this.locationCoord = locationCoord;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public HeroSighting[] getSightings() {
        return sightings;
    }

    public void setSightings(HeroSighting[] sightings) {
        this.sightings = sightings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.locationId;
        hash = 47 * hash + Objects.hashCode(this.locationName);
        hash = 47 * hash + Objects.hashCode(this.locationCity);
        hash = 47 * hash + Objects.hashCode(this.locationState);
        hash = 47 * hash + Objects.hashCode(this.locationAddress);
        hash = 47 * hash + Objects.hashCode(this.locationCoord);
        hash = 47 * hash + Objects.hashCode(this.locationDesc);
        hash = 47 * hash + Arrays.deepHashCode(this.sightings);
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
        final Location other = (Location) obj;
        if (this.locationId != other.locationId) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationCity, other.locationCity)) {
            return false;
        }
        if (!Objects.equals(this.locationState, other.locationState)) {
            return false;
        }
        if (!Objects.equals(this.locationAddress, other.locationAddress)) {
            return false;
        }
        if (!Objects.equals(this.locationCoord, other.locationCoord)) {
            return false;
        }
        if (!Objects.equals(this.locationDesc, other.locationDesc)) {
            return false;
        }
        if (!Arrays.deepEquals(this.sightings, other.sightings)) {
            return false;
        }
        return true;
    }
    
    
}
