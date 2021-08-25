package com.jdm.superherosightings.entities;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class Hero {
    private int heroId;
    private String heroName, heroDesc;
    private Organization organizations[];
    private Power powers[];
    private HeroSighting sightings[];

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDesc() {
        return heroDesc;
    }

    public void setHeroDesc(String heroDesc) {
        this.heroDesc = heroDesc;
    }

    public Organization[] getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organization[] organizations) {
        this.organizations = organizations;
    }

    public Power[] getPowers() {
        return powers;
    }

    public void setPowers(Power[] powers) {
        this.powers = powers;
    }

    public HeroSighting[] getSightings() {
        return sightings;
    }

    public void setSightings(HeroSighting[] sightings) {
        this.sightings = sightings;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.heroId;
        hash = 29 * hash + Objects.hashCode(this.heroName);
        hash = 29 * hash + Objects.hashCode(this.heroDesc);
        hash = 29 * hash + Arrays.deepHashCode(this.organizations);
        hash = 29 * hash + Arrays.deepHashCode(this.powers);
        hash = 29 * hash + Arrays.deepHashCode(this.sightings);
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
        final Hero other = (Hero) obj;
        if (this.heroId != other.heroId) {
            return false;
        }
        if (!Objects.equals(this.heroName, other.heroName)) {
            return false;
        }
        if (!Objects.equals(this.heroDesc, other.heroDesc)) {
            return false;
        }
        if (!Arrays.deepEquals(this.organizations, other.organizations)) {
            return false;
        }
        if (!Arrays.deepEquals(this.powers, other.powers)) {
            return false;
        }
        if (!Arrays.deepEquals(this.sightings, other.sightings)) {
            return false;
        }
        return true;
    }
    
    
}
