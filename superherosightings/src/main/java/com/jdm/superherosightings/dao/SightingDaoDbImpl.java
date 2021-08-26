/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Location;
import com.jdm.superherosightings.entities.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
@Repository
public class SightingDaoDbImpl implements SightingDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Sighting getSightingById(int sightingId) {
        try {
            final String SELECT_SIGHTING_BY_ID = "SELECT * FROM sighting WHERE sightingId = ?";
            Sighting sighting = jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new SightingMapper(), sightingId);
            return sighting;
        } 
        catch(DataAccessException ex) {
            return null;
        }   
    }

    @Override
    public List<Sighting> getAllHeroSightings() {
        final String GET_ALL_SIGHTINGS = "SELECT * FROM sighting s JOIN superperson sp ON s.superPersonId = sp.superPersonId WHERE sp.isVillain = ?";
        return jdbc.query(GET_ALL_SIGHTINGS, new SightingMapper(), false);
    }

    @Override
    public List<Sighting> getAllVillainSightings() {  
        final String GET_ALL_SIGHTINGS = "SELECT * FROM sighting s JOIN superperson sp ON s.superPersonId = sp.superPersonId WHERE sp.isVillain = ?";
        return jdbc.query(GET_ALL_SIGHTINGS, new SightingMapper(), true);    
    }
    
    @Override
    public List<Sighting> getAllSightingsAtLocationDate(int locationId, LocalDate date) { //Not testewd
        final String GET_SIGHTINGS_LOCATIONDATE = "SELECT * FROM sighting s "
                + "JOIN superperson sp ON s.superPersonId = sp.superPersonId "
                + "JOIN location l ON l.locationId = s.locationId"
                + "WHERE l.locationId = ? AND s.sightingTime = ?";
        return jdbc.query(GET_SIGHTINGS_LOCATIONDATE, new SightingMapper(), locationId, date);
    }

    @Override
    @Transactional
    public Sighting addSighting(Sighting sighting) {
        final String INSERT_SIGHTING = "INSERT INTO sighting(superPersonId, locationId, sightingTime) VALUES (?,?,?)";
        jdbc.update(INSERT_SIGHTING, sighting.getSuperPersonId(), sighting.getLocationId(), sighting.getSightingTime());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingId(newId);
        return sighting;
    }

    @Override
    @Transactional
    public void deleteSightingById(int sighting) {
        final String DELETE_SIGHTING = "DELETE s.* FROM sighting s WHERE sightingId = ?";
        jdbc.update(DELETE_SIGHTING, sighting);
    }

    @Override
    public void editSighting(Sighting sighting) {
        final String UPDATE_SIGHTING = "UPDATE sighting SET superPersonId = ?, locationId = ?, sightingTime = ? WHERE sightingId = ?";
        jdbc.update(UPDATE_SIGHTING, sighting.getSuperPersonId(), sighting.getLocationId(), sighting.getSightingTime(), sighting.getSightingId());
    }
    
    public static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int index) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("sightingId"));
            sighting.setSuperPersonId(rs.getInt("superPersonId"));
            sighting.setLocationId(rs.getInt("locationId"));
            sighting.setSightingTime(rs.getTimestamp("sightingTime"));
            
            return sighting;
        }
    }

}
