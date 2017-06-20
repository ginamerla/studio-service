package com.marke.app.coreservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.marke.app.coreservice.dao.InstructorDao;
import com.marke.app.coreservice.dao.mapper.InstructorRowMapper;
import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Instructor;

@Component
public class InstructorDaoImpl implements InstructorDao {
	private static final Logger LOG = LogManager.getLogger(InstructorDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void crearEntidad(Instructor modelo) throws CoreServiceGeneralException {
		LOG.info("Creando nuevo instructor");
		jdbcTemplate.update(INSERT,new Object[]{modelo.getName(), modelo.getColor()});
	}

	public void actualizarEntidad(Instructor modelo) throws CoreServiceGeneralException {
		LOG.info("Actualizando instructor");
		jdbcTemplate.update(UPDATE, new Object[]{modelo.getName(), modelo.getColor(), modelo.getIdInstructor()});
	}

	public void eliminarEntidad(Long id) throws CoreServiceGeneralException {
		LOG.info("Eliminando instructor");
		jdbcTemplate.update(DELETE, new Object[]{id});
	}

	public Instructor consultarEntidad(Instructor modelo) throws CoreServiceGeneralException {
		LOG.info("Consultando instructor");
		Instructor instructor = new Instructor();
		instructor = jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{modelo.getIdInstructor()}, new InstructorRowMapper());
		return instructor;
	}

	public List<Instructor> consultarEntidades() throws CoreServiceGeneralException {
		LOG.info("Consultando todos los Instructores");
		List<Instructor>instructorList = new ArrayList<Instructor>();
		instructorList = jdbcTemplate.query(SELECT_ALL, new InstructorRowMapper());
		return instructorList;
	}

}
