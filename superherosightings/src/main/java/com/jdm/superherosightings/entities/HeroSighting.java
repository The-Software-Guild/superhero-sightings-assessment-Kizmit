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
public class HeroSighting {
    private int sightingId;
    private Hero hero;
    private Location location;
    private Timestamp sightingTime;

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
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
        int hash = 3;
        hash = 17 * hash + this.sightingId;
        hash = 17 * hash + Objects.hashCode(this.hero);
        hash = 17 * hash + Objects.hashCode(this.location);
        hash = 17 * hash + Objects.hashCode(this.sightingTime);
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
        final HeroSighting other = (HeroSighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (!Objects.equals(this.hero, other.hero)) {
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
