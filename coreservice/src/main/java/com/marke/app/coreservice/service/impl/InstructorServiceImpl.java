package com.marke.app.coreservice.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marke.app.coreservice.dao.InstructorDao;
import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Instructor;
import com.marke.app.coreservice.service.InstructorService;

/**
 * Capa de servicios - Instructor service.
 * @author visilva
 *
 */
@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorDao instructorDao;
	
	public Instructor guardarInstructor(Instructor instructor) throws CoreServiceGeneralException {
		if (instructor == null) {
			throw new CoreServiceGeneralException("Datos invalidos!");
		}
		if (StringUtils.isBlank(instructor.getName())) {
			throw new CoreServiceGeneralException("Datos invalidos! Favor de proporcionar nombre");
		}
		instructorDao.crearEntidad(instructor);
		return instructor;
	}

}
