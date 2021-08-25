package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.HeroVillain;
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
public class HeroVillainDaoDbImpl implements HeroVillainDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public HeroVillain getHeroVillainById(int heroId) {
        try {
            final String SELECT_HERO_VILLAIN_BY_ID = "SELECT * FROM herovillain WHERE heroVillainId = ?";
            HeroVillain hero = jdbc.queryForObject(SELECT_HERO_VILLAIN_BY_ID, new HeroVillainMapper(), heroId);
            return hero;
        } 
        catch(DataAccessException ex) {
            return null;
        }    
    }
    
    @Override
    public List<HeroVillain> getAllHeroes() {
        final String GET_ALL_HEROES = "SELECT * FROM herovillain WHERE isVillain = ?";
        return jdbc.query(GET_ALL_HEROES, new HeroVillainMapper(), false);
    }
    
    @Override
    public List<HeroVillain> getAllVillains() {
        final String GET_ALL_VILLAINS = "SELECT * FROM herovillain WHERE isVillain = ?";
        return jdbc.query(GET_ALL_VILLAINS, new HeroVillainMapper(), true);
    }

    @Override
    @Transactional
    public HeroVillain addHeroVillain(HeroVillain heroVillain) {
        final String INSERT_HERO_VILLAIN = "INSERT INTO herovillain(hvName, hvDescription, isVillain) VALUES(?,?,?)";
        jdbc.update(INSERT_HERO_VILLAIN, heroVillain.getName(), heroVillain.getDescription(), heroVillain.isVillain());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        heroVillain.setHeroVillainId(newId);
        return heroVillain;    
    }

    @Override
    @Transactional
    public void deleteHeroVillainById(int heroVillainId) {
        final String DELETE_SIGHTING = "DELETE hvs.* FROM sighting hvs WHERE heroVillainId = ?";
        jdbc.update(DELETE_SIGHTING, heroVillainId);
        
        final String DELETE_ORGHEROVILLAIN = "DELETE ohv.* FROM organizationherovillain ohv WHERE heroVillainId = ?";
        jdbc.update(DELETE_ORGHEROVILLAIN, heroVillainId);
        
        final String DELETE_HEROVILLAINPOWER = "DELETE hvp.* FROM herovillainpower hvp WHERE heroVillainId = ?";
        jdbc.update(DELETE_HEROVILLAINPOWER, heroVillainId);
        
        final String DELETE_HEROVILLAIN = "DELETE hv.* FROM herovillain hv WHERE heroVillainId = ?";
        jdbc.update(DELETE_HEROVILLAIN, heroVillainId);
    }

    @Override
    public void editHeroVillain(HeroVillain herovillain) {
        final String UPDATE_HEROVILLAIN = "UPDATE herovillain SET hvName = ?, hvDescription = ?, isVillain = ? WHERE heroVillainId = ?";
        jdbc.update(UPDATE_HEROVILLAIN, herovillain.getName(), herovillain.getDescription(), herovillain.isVillain(), herovillain.getHeroVillainId());    
    }

    private static final class HeroVillainMapper implements RowMapper<HeroVillain> {

        @Override
        public HeroVillain mapRow(ResultSet rs, int index) throws SQLException {
            HeroVillain heroVillain = new HeroVillain();
            heroVillain.setHeroVillainId(rs.getInt("heroVillainId"));
            heroVillain.setName(rs.getString("hvName"));
            heroVillain.setDescription(rs.getString("hvDescription"));
            heroVillain.setVillain(rs.getBoolean("isVillain"));
            return heroVillain;
        }
    }

}
