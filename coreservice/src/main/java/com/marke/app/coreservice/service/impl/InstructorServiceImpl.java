package com.marke.app.coreservice.service.impl;

import java.util.List;

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

	@Override
	public Instructor actualizarInstructor(Instructor instructor)
			throws CoreServiceGeneralException {
		if (instructor == null){
			throw new CoreServiceGeneralException("Datos invalidos - instructor nulo");
		}
		if (instructor.getIdInstructor()==null){
			throw new CoreServiceGeneralException("Datos invalidos - id nulo");
		}
		if (StringUtils.isBlank(instructor.getColor())){
			throw new CoreServiceGeneralException("Datos invalidos - color nulo");
		}
		if (StringUtils.isBlank(instructor.getName())){
			throw new CoreServiceGeneralException("Datos invalidos - name nulo");
		}
		instructorDao.actualizarEntidad(instructor);
		return instructor;
	}

	@Override
	public List<Instructor> consultarInstructores() {
		List<Instructor>listaInstructores = instructorDao.consultarEntidades();
		return listaInstructores;
	}

	@Override
	public Instructor consultarInstructor(Instructor instructor)throws CoreServiceGeneralException {
		if(instructor==null){
			throw new CoreServiceGeneralException("Datos invalidos - Instructor nulo");
		}
		if(instructor.getIdInstructor()==null){
			throw new CoreServiceGeneralException("Datos invalidos - El id es nulo");
		}
		return instructorDao.consultarEntidad(instructor);
	}

	@Override
	public void eliminarInstructor(Long id) throws CoreServiceGeneralException {
		if(id==null){
			throw new CoreServiceGeneralException("Datos invalidos - El id es nulo");
		}
		instructorDao.eliminarEntidad(id); 
	}

}
