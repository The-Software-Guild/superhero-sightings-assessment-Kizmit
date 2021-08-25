package com.jdm.superherosightings.dao;

import com.jdm.superherosightings.entities.Organization;
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
public class OrganizationDaoDbImpl implements OrganizationDao {
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Organization getOrganizationById(int organizationId) {
        try {
            final String SELECT_ORGANIZATION_BY_ID = "SELECT * FROM organization WHERE organizationId = ?";
            Organization organization = jdbc.queryForObject(SELECT_ORGANIZATION_BY_ID, new OrganizationMapper(), organizationId);
            return organization;
        } 
        catch(DataAccessException ex) {
            return null;
        }            
    }

    @Override
    public List<Organization> getAllOrganizations() {
        final String GET_ALL_ORGANIZATIONS = "SELECT * FROM organization";
        return jdbc.query(GET_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    @Transactional
    public Organization addOrganization(Organization organization) {
        final String INSERT_ORGANIZATION = "INSERT INTO organization(locationId, organizationType, organizationName, organizationDesc, organizationPhone) VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_ORGANIZATION, 
                organization.getLocationId(),
                organization.getType(),
                organization.getName(), 
                organization.getDescription(),
                organization.getPhone());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        organization.setOrganizationId(newId);
        return organization;            
    }

    @Override
    @Transactional
    public void deleteOrganizationById(int organizationId) {
        final String DELETE_ORGHEROVILLAIN = "DELETE ohv.* FROM organizationherovillain ohv WHERE ohv.organizationId = ?";
        jdbc.update(DELETE_ORGHEROVILLAIN, organizationId);
        
        final String DELETE_ORGANIZATION = "DELETE o.* FROM organization o WHERE organizationId = ?";
        jdbc.update(DELETE_ORGANIZATION, organizationId);
    }

    @Override
    public void editOrganization(Organization organization) {
        final String UPDATE_LOCATION = "UPDATE organization SET locationId = ?, organizationType = ?, "
                + " organizationName = ?, organizationDesc = ?, organizationPhone = ? WHERE organizationId = ?";
        jdbc.update(UPDATE_LOCATION, organization.getLocationId(), organization.getType(), 
                organization.getName(), organization.getDescription(), organization.getPhone(), 
                organization.getOrganizationId());
    }
    
    
    public static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int index) throws SQLException {
            Organization organization = new Organization();
            organization.setOrganizationId(rs.getInt("organizationId"));
            organization.setName(rs.getString("organizationName"));
            organization.setDescription(rs.getString("organizationDesc"));
            organization.setLocationId(rs.getInt("locationId"));
            organization.setPhone(rs.getString("organizationPhone"));
            organization.setType(rs.getString("organizationType"));
            
            return organization;
        }
    }
}
