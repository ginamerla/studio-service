package com.marke.app.coreservice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.marke.app.coreservice.model.Role;


public class RoleRowMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setIdRole(rs.getLong("idrole"));
		role.setRoleName(rs.getString("rolename"));
		return role;
	}
	


}
