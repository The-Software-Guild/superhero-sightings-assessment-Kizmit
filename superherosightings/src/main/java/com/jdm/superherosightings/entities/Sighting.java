/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.entities;

import java.sql.Timestamp;
import java.util.Objects;


/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class Sighting {
    private int sightingId, heroVillainId;
    private HeroVillain heroVillain;
    private Location location;
    private Timestamp sightingTime;

    public int getHeroVillainId() {
        return heroVillainId;
    }

    public void setHeroVillainId(int heroVillainId) {
        this.heroVillainId = heroVillainId;
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public HeroVillain getHeroVillain() {
        return heroVillain;
    }

    public void setHeroVillain(HeroVillain heroVillain) {
        this.heroVillain = heroVillain;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.sightingId;
        hash = 37 * hash + this.heroVillainId;
        hash = 37 * hash + Objects.hashCode(this.heroVillain);
        hash = 37 * hash + Objects.hashCode(this.location);
        hash = 37 * hash + Objects.hashCode(this.sightingTime);
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
        if (this.heroVillainId != other.heroVillainId) {
            return false;
        }
        if (!Objects.equals(this.heroVillain, other.heroVillain)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.sightingTime, other.sightingTime)) {
            return false;
        }
        return true;
    }


    
    
}
