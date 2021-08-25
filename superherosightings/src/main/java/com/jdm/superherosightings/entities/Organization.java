package com.jdm.superherosightings.entities;

import java.util.List;
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
    private List<Hero> heroes;
    private List<Villain> villains;

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

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Villain> getVillains() {
        return villains;
    }

    public void setVillains(List<Villain> villains) {
        this.villains = villains;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.organizationId;
        hash = 13 * hash + Objects.hashCode(this.location);
        hash = 13 * hash + Objects.hashCode(this.organizationName);
        hash = 13 * hash + Objects.hashCode(this.organizationType);
        hash = 13 * hash + Objects.hashCode(this.organizationDesc);
        hash = 13 * hash + Objects.hashCode(this.organizationPhone);
        hash = 13 * hash + Objects.hashCode(this.heroes);
        hash = 13 * hash + Objects.hashCode(this.villains);
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
        if (!Objects.equals(this.heroes, other.heroes)) {
            return false;
        }
        if (!Objects.equals(this.villains, other.villains)) {
            return false;
        }
        return true;
    }


}
