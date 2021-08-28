/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.service;

import com.jdm.superherosightings.dao.LocationDao;
import com.jdm.superherosightings.dao.OrganizationDao;
import com.jdm.superherosightings.dao.PowerDao;
import com.jdm.superherosightings.dao.SightingDao;
import com.jdm.superherosightings.dao.SuperPersonDao;
import com.jdm.superherosightings.entities.Location;
import com.jdm.superherosightings.entities.Organization;
import com.jdm.superherosightings.entities.Power;
import com.jdm.superherosightings.entities.Sighting;
import com.jdm.superherosightings.entities.SuperPerson;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */

@Component
public class ServiceLayer {
    @Autowired
    LocationDao locDao;
    
    @Autowired
    OrganizationDao orgDao;
    
    @Autowired
    PowerDao powerDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperPersonDao superPersonDao;
    
    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();
    public List<Sighting> getSightings() {
        List<Sighting> sightings = sightingDao.getAllVillainSightings();
        
        sightings.forEach(sighting ->{
            sighting.setSuperPerson(superPersonDao.getSuperById(sighting.getSuperPersonId()));
            sighting.setLocation(locDao.getLocationById(sighting.getLocationId()));
            sighting.setOrganizations(sighting.getSuperPerson().getOrganizations());
            sighting.setPowers(sighting.getSuperPerson().getPowers());
            sighting.getOrganizations().forEach(org -> {
                    sighting.appendOrgNames(org.getName());
            });
            sighting.getPowers().forEach(power -> {
                    sighting.appendPowerNames(power.getName());
            });
        });
        

        
        
        return sightings;
    }

    public List<SuperPerson> getVillains() {
        List<SuperPerson> villains = superPersonDao.getAllVillains();
        villains.forEach(villain -> {
            villain.getOrganizations().forEach(org -> {
                villain.appendOrgNames(org.getName());
            });
            villain.getPowers().forEach(power -> {
                villain.appendPowerNames(power.getName());
            });
        });
        
        
        return villains;
    }
    
    public List<SuperPerson> getHeroes() {
        List<SuperPerson> heroes = superPersonDao.getAllHeroes();
        heroes.forEach(hero -> {
            hero.getOrganizations().forEach(org -> {
                hero.appendOrgNames(org.getName());
            });
            hero.getPowers().forEach(power -> {
                hero.appendPowerNames(power.getName());
            });
        });
        
        
        return heroes;
    }

    public List<Power> getPowers() {
        return powerDao.getAllPowers();
    }

    public List<Organization> getOrganizations() {
        return orgDao.getAllOrganizations();
    }

    public List<Location> getLocations() {
        return locDao.getAllLocations();
    }

    public void deleteSightingById(int id) {
        sightingDao.deleteSightingById(id);
    }

    public void addSighting(Sighting sighting) {
        sightingDao.addSighting(sighting);
    }

    public Sighting createSighting(HttpServletRequest request) {
        Sighting sighting = new Sighting();
        String superPersonName = request.getParameter("superPersonName");
        String locationName = request.getParameter("locationName");
        
        SuperPerson superPerson = superPersonDao.getSuperPersonByName(superPersonName);
        Location location = locDao.getLocationByName(locationName);
        
        if(location != null){
            sighting.setLocation(location);
            sighting.setLocationId(location.getLocationId());
        }
        if(superPerson != null){
            sighting.setSuperPerson(superPerson);
            sighting.setSuperPersonId(superPerson.getSuperPersonId());
        }
        
        sighting.setSightingDate(Date.valueOf(LocalDate.now()));
        
        return sighting;
    }

    public Sighting getSightingById(int id) {
        return sightingDao.getSightingById(id);
    }

    public Sighting editSighting(Sighting sighting, HttpServletRequest request) {
        
        SuperPerson superPerson = superPersonDao.getSuperPersonByName(request.getParameter("superPersonName"));
        Location location = locDao.getLocationByName(request.getParameter("locationName"));
        Date date = null;
        if(request.getParameter("dateTime").equals("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            date = Date.valueOf(request.getParameter("dateTime"));
        }
        
        if(location != null){
            sighting.setLocation(location);
            sighting.setLocationId(location.getLocationId());
        }
        if(superPerson != null){
            sighting.setSuperPerson(superPerson);
            sighting.setSuperPersonId(superPerson.getSuperPersonId());
        }
        if(date != null){
            sighting.setSightingDate(date);
        }
        return sighting;
    }

    public void updateSighting(Sighting sighting) {
        sightingDao.editSighting(sighting);
    }

    public Organization createOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        String locationName = request.getParameter("locationName");
        String organizationType = request.getParameter("organizationType");
        String organizationName = request.getParameter("organizationName");
        String organizationDesc = request.getParameter("organizationDesc");
        String organizationPhone = request.getParameter("organizationPhone");
        
        organization.setLocation(locDao.getLocationByName(locationName));
        organization.setLocationId(organization.getLocation().getLocationId());
        organization.setType(organizationType);
        organization.setName(organizationName);
        organization.setDescription(organizationDesc);
        organization.setPhone(organizationPhone);
        
        return organization;
    }

    public void addOrganization(Organization organization) {
        orgDao.addOrganization(organization);
    }

    public void deleteOrganizationById(int id) {
        orgDao.deleteOrganizationById(id);
    }

    public Organization getOrganizationById(int id) {
        return orgDao.getOrganizationById(id);
    }

    public Organization editOrganization(Organization organization, HttpServletRequest request) {
        String locationName = request.getParameter("locationName");
        String organizationType = request.getParameter("organizationType");
        String organizationName = request.getParameter("organizationName");
        String organizationDesc = request.getParameter("organizationDesc");
        String organizationPhone = request.getParameter("organizationPhone");
        
        organization.setLocation(locDao.getLocationByName(locationName));
        organization.setLocationId(organization.getLocation().getLocationId());
        organization.setType(organizationType);
        organization.setName(organizationName);
        organization.setDescription(organizationDesc);
        organization.setPhone(organizationPhone);
        return organization;
    }

    public void updateOrganization(Organization organization) {
        orgDao.editOrganization(organization);
    }

    public SuperPerson createSuperPerson(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addSuperPerson(SuperPerson hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteSuperPersonById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SuperPerson getSuperPersonById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SuperPerson editSuperPerson(SuperPerson hero, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateSuperPerson(SuperPerson hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
