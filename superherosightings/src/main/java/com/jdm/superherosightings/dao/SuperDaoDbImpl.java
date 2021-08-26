package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.SuperPerson;
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
public class SuperDaoDbImpl implements SuperPersonDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public SuperPerson getSuperById(int heroId) {
        try {
            final String SELECT_SUPER_PERSON_BY_ID = "SELECT * FROM superperson WHERE superPersonId = ?";
            SuperPerson hero = jdbc.queryForObject(SELECT_SUPER_PERSON_BY_ID, new HeroVillainMapper(), heroId);
            return hero;
        } 
        catch(DataAccessException ex) {
            return null;
        }    
    }
    
    @Override
    public List<SuperPerson> getAllHeroes() {
        final String GET_ALL_HEROES = "SELECT * FROM superperson WHERE isVillain = ?";
        return jdbc.query(GET_ALL_HEROES, new HeroVillainMapper(), false);
    }
    
    @Override
    public List<SuperPerson> getAllVillains() {
        final String GET_ALL_VILLAINS = "SELECT * FROM superperson WHERE isVillain = ?";
        return jdbc.query(GET_ALL_VILLAINS, new HeroVillainMapper(), true);
    }

    @Override
    @Transactional
    public SuperPerson addSuper(SuperPerson heroVillain) {
        final String INSERT_SUPER_PERSON = "INSERT INTO superperson(sName, sDescription, isVillain) VALUES(?,?,?)";
        jdbc.update(INSERT_SUPER_PERSON, heroVillain.getName(), heroVillain.getDescription(), heroVillain.isVillain());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        heroVillain.setSuperPersonId(newId);
        return heroVillain;    
    }

    @Override
    @Transactional
    public void deleteSuperById(int heroVillainId) {
        final String DELETE_SIGHTING = "DELETE hvs.* FROM sighting hvs WHERE superPersonId = ?";
        jdbc.update(DELETE_SIGHTING, heroVillainId);
        
        final String DELETE_ORGSUPERPERSON = "DELETE ohv.* FROM organizationsuperperson ohv WHERE superPersonId = ?";
        jdbc.update(DELETE_ORGSUPERPERSON, heroVillainId);
        
        final String DELETE_SUPERPERSONPOWER = "DELETE hvp.* FROM superpersonpower hvp WHERE superPersonId = ?";
        jdbc.update(DELETE_SUPERPERSONPOWER, heroVillainId);
        
        final String DELETE_SUPERPERSON = "DELETE hv.* FROM superperson hv WHERE superPersonId = ?";
        jdbc.update(DELETE_SUPERPERSON, heroVillainId);
    }

    @Override
    public void editSuper(SuperPerson superperson) {
        final String UPDATE_SUPERPERSON = "UPDATE superperson SET sName = ?, sDescription = ?, isVillain = ? WHERE superPersonId = ?";
        jdbc.update(UPDATE_SUPERPERSON, superperson.getName(), superperson.getDescription(), superperson.isVillain(), superperson.getSuperPersonId());    
    }

    private static final class HeroVillainMapper implements RowMapper<SuperPerson> {

        @Override
        public SuperPerson mapRow(ResultSet rs, int index) throws SQLException {
            SuperPerson superPerson = new SuperPerson();
            superPerson.setSuperPersonId(rs.getInt("superPersonId"));
            superPerson.setName(rs.getString("sName"));
            superPerson.setDescription(rs.getString("sDescription"));
            superPerson.setVillain(rs.getBoolean("isVillain"));
            return superPerson;
        }
    }

}
