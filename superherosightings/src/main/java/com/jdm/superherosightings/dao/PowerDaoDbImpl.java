/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Power;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PowerDaoDbImpl implements PowerDao {
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Power getPowerById(int powerId) {
        try {
            final String SELECT_POWER_BY_ID = "SELECT * FROM power WHERE powerId = ?";
            Power power = jdbc.queryForObject(SELECT_POWER_BY_ID, new PowerMapper(), powerId);
            return power;
        } 
        catch(DataAccessException ex) {
            return null;
        }   
    }

    @Override
    public List<Power> getAllPowers() {
        final String GET_ALL_POWERS = "SELECT * FROM power";
        return jdbc.query(GET_ALL_POWERS, new PowerMapper());
    }

    @Override
    @Transactional
    public Power addPower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void deletePowerById(int powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editPower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int index) throws SQLException {
            Power power = new Power();
            power.setPowerId(rs.getInt("powerId"));
            power.setName(rs.getString("powerName"));
            power.setDescription(rs.getString("powerDesc"));
            return power;
        }
    }

}
