package com.marke.app.coreservice.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.marke.app.coreservice.dao.InstructorDao;
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
		throw new UnsupportedOperationException("No implementado!");
	}

	public void eliminarEntidad(Long identificador) throws CoreServiceGeneralException {
		throw new UnsupportedOperationException("No implementado!");
	}

	public Instructor consultarEntidad(Instructor modelo) throws CoreServiceGeneralException {
		throw new UnsupportedOperationException("No implementado!");
	}

	public List<Instructor> consultarEntidades() throws CoreServiceGeneralException {
		throw new UnsupportedOperationException("No implementado!");
	}

}
