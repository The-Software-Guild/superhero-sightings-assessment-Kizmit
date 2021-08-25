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
public class Organization {
    private int organizationId;
    private Location location;
    private String organizationName, organizationType, organizationDesc, organizationPhone;
    private Hero heroes[];
    private Villain villains[];

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

    public String getOrganizationPhone() {
        return organizationPhone;
    }

    public void setOrganizationPhone(String organizationPhone) {
        this.organizationPhone = organizationPhone;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public void setHeroes(Hero[] heroes) {
        this.heroes = heroes;
    }

    public Villain[] getVillains() {
        return villains;
    }

    public void setVillains(Villain[] villains) {
        this.villains = villains;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.organizationId;
        hash = 47 * hash + Objects.hashCode(this.location);
        hash = 47 * hash + Objects.hashCode(this.organizationName);
        hash = 47 * hash + Objects.hashCode(this.organizationType);
        hash = 47 * hash + Objects.hashCode(this.organizationDesc);
        hash = 47 * hash + Objects.hashCode(this.organizationPhone);
        hash = 47 * hash + Arrays.deepHashCode(this.heroes);
        hash = 47 * hash + Arrays.deepHashCode(this.villains);
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
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationType, other.organizationType)) {
            return false;
        }
        if (!Objects.equals(this.organizationDesc, other.organizationDesc)) {
            return false;
        }
        if (!Objects.equals(this.organizationPhone, other.organizationPhone)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Arrays.deepEquals(this.heroes, other.heroes)) {
            return false;
        }
        if (!Arrays.deepEquals(this.villains, other.villains)) {
            return false;
        }
        return true;
    }
    
    
}
