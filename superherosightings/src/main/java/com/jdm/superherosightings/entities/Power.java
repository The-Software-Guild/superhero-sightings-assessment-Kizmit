/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.entities;

import java.util.Objects;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class Power {
    private int powerId;
    private String powerName, powerDesc;

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerDesc() {
        return powerDesc;
    }

    public void setPowerDesc(String powerDesc) {
        this.powerDesc = powerDesc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.powerId;
        hash = 37 * hash + Objects.hashCode(this.powerName);
        hash = 37 * hash + Objects.hashCode(this.powerDesc);
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
        final Power other = (Power) obj;
        if (this.powerId != other.powerId) {
            return false;
        }
        if (!Objects.equals(this.powerName, other.powerName)) {
            return false;
        }
        if (!Objects.equals(this.powerDesc, other.powerDesc)) {
            return false;
        }
        return true;
    }
    
    
}
