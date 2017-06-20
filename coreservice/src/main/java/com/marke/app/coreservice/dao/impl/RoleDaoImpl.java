package com.marke.app.coreservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.marke.app.coreservice.dao.RoleDao;
import com.marke.app.coreservice.dao.mapper.RoleRowMapper;
import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Role;

public class RoleDaoImpl implements RoleDao{

	public static final Logger LOG = LogManager.getLogger(Role.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void crearEntidad(Role modelo) throws CoreServiceGeneralException {
		LOG.info("Creando nuevo rol");
		jdbcTemplate.update(INSERT, new Object[]{modelo.getRoleName()});
	}

	@Override
	public void actualizarEntidad(Role modelo)throws CoreServiceGeneralException {
		LOG.info("Actualizando el rol");
		jdbcTemplate.update(UPDATE, new Object[]{modelo.getRoleName(), modelo.getIdRole()});
	}

	@Override
	public void eliminarEntidad(Long identificador)throws CoreServiceGeneralException {
		LOG.info("Eliminando el Rol");
		jdbcTemplate.update(DELETE, identificador);
	}

	@Override
	public Role consultarEntidad(Role modelo)throws CoreServiceGeneralException {
		LOG.info("Consultando Rol");
		Role role = new Role();
		role = jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{modelo.getIdRole()}, new RoleRowMapper());
		return role;
	}

	@Override
	public List<Role> consultarEntidades() throws CoreServiceGeneralException {
		LOG.info("Consultando todos los roles");
		List<Role>roleList = new ArrayList<Role>();
		roleList = jdbcTemplate.query(SELECT_ALL, new RoleRowMapper());
		return roleList;
	}

}
