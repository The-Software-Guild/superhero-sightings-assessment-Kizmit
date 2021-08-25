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
public class Villain {
    private int villainId;
    private String villainName, villainDesc;
    private Organization organizations[];
    private Power powers[];
    private VillainSighting sightings[];

    public int getVillainId() {
        return villainId;
    }

    public void setVillainId(int villainId) {
        this.villainId = villainId;
    }

    public String getVillainName() {
        return villainName;
    }

    public void setVillainName(String villainName) {
        this.villainName = villainName;
    }

    public String getVillainDesc() {
        return villainDesc;
    }

    public void setVillainDesc(String villainDesc) {
        this.villainDesc = villainDesc;
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

    public VillainSighting[] getSightings() {
        return sightings;
    }

    public void setSightings(VillainSighting[] sightings) {
        this.sightings = sightings;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.villainId;
        hash = 83 * hash + Objects.hashCode(this.villainName);
        hash = 83 * hash + Objects.hashCode(this.villainDesc);
        hash = 83 * hash + Arrays.deepHashCode(this.organizations);
        hash = 83 * hash + Arrays.deepHashCode(this.powers);
        hash = 83 * hash + Arrays.deepHashCode(this.sightings);
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
        final Villain other = (Villain) obj;
        if (this.villainId != other.villainId) {
            return false;
        }
        if (!Objects.equals(this.villainName, other.villainName)) {
            return false;
        }
        if (!Objects.equals(this.villainDesc, other.villainDesc)) {
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
