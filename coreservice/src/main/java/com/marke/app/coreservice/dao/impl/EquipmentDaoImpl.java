package com.marke.app.coreservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.marke.app.coreservice.dao.EquipmentDao;
import com.marke.app.coreservice.dao.mapper.EquipmentRowMapper;
import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Equipment;

public class EquipmentDaoImpl implements EquipmentDao{
	
	private static final Logger LOG = LogManager.getLogger(InstructorDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crearEntidad(Equipment modelo)throws CoreServiceGeneralException {
		LOG.info("Creando nuevo Equipo");
		jdbcTemplate.update(INSERT, new Object[]{modelo.getEquipmentNumber(), modelo.getEquipmentName()});
	}

	@Override
	public void actualizarEntidad(Equipment modelo)throws CoreServiceGeneralException {
		LOG.info("Actualizando equipo");
		jdbcTemplate.update(UPDATE, new Object[]{modelo.getEquipmentNumber(), modelo.getEquipmentName(), modelo.getIdEquipment()});
	}

	@Override
	public void eliminarEntidad(Long identificador)throws CoreServiceGeneralException {
		LOG.info("Eliminando equipo");
		jdbcTemplate.update(DELETE, new Object[]{identificador});
	}
	
	@Override
	public Equipment consultarEntidad(Equipment modelo)throws CoreServiceGeneralException {
		LOG.info("Consultando equipo");
		Equipment equipo = new Equipment();
		equipo = jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{modelo.getIdEquipment()}, new EquipmentRowMapper());
		return equipo;
	}

	@Override
	public List<Equipment> consultarEntidades() throws CoreServiceGeneralException {
		LOG.info("Consultando todos los equipos");
		List<Equipment>equipmentList = new ArrayList<Equipment>();
		equipmentList = jdbcTemplate.query(SELECT_ALL, new EquipmentRowMapper());
		return equipmentList;
	}
	
	

}
