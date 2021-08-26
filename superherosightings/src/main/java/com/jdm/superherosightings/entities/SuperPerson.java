package com.jdm.superherosightings.entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class SuperPerson {
    private int superPersonId;
    private String name, description;
    private boolean villain;
    private List<Organization> organizations;
    private List<Power> powers;

    public int getSuperPersonId() {
        return superPersonId;
    }

    public void setSuperPersonId(int superPersonId) {
        this.superPersonId = superPersonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVillain() {
        return villain;
    }

    public void setVillain(boolean villain) {
        this.villain = villain;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.superPersonId;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + (this.villain ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.organizations);
        hash = 79 * hash + Objects.hashCode(this.powers);
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
        final SuperPerson other = (SuperPerson) obj;
        if (this.superPersonId != other.superPersonId) {
            return false;
        }
        if (this.villain != other.villain) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.organizations, other.organizations)) {
            return false;
        }
        if (!Objects.equals(this.powers, other.powers)) {
            return false;
        }
        return true;
    }





    
}
