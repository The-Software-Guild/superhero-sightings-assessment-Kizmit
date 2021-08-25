/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.entities;

import java.util.List;
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
    private List<Organization> organizations;
    private List<Power> powers;
    private List<VillainSighting> sightings;

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

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public List<VillainSighting> getSightings() {
        return sightings;
    }

    public void setSightings(List<VillainSighting> sightings) {
        this.sightings = sightings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.villainId;
        hash = 67 * hash + Objects.hashCode(this.villainName);
        hash = 67 * hash + Objects.hashCode(this.villainDesc);
        hash = 67 * hash + Objects.hashCode(this.organizations);
        hash = 67 * hash + Objects.hashCode(this.powers);
        hash = 67 * hash + Objects.hashCode(this.sightings);
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
        if (!Objects.equals(this.organizations, other.organizations)) {
            return false;
        }
        if (!Objects.equals(this.powers, other.powers)) {
            return false;
        }
        if (!Objects.equals(this.sightings, other.sightings)) {
            return false;
        }
        return true;
    }

   
}
