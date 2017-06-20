package com.marke.app.coreservice.service;

import java.util.List;

import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Instructor;

public interface InstructorService {

	/**
	 * Registra un nuevo instructor.
	 * @param instructor
	 * @return instructor saved
	 * @throws CoreServiceGeneralException
	 */
	Instructor guardarInstructor(Instructor instructor) throws CoreServiceGeneralException;
	
	/**
	 * Actualiza el instructor indicado
	 * @param instructor
	 * @return updated instructor
	 * @throws CoreServiceGeneralException
	 */
	Instructor actualizarInstructor(Instructor instructor)throws CoreServiceGeneralException;
	
	/**
	 * Obtiene todos los instructores guardados
	 * @return lista de instructores guardados
	 */
	List<Instructor> consultarInstructores();
	
	/**
	 * Obtiene el instructor indicado
	 * @param instructor
	 * @return el instructor con el id indicado
	 * @throws CoreServiceGeneralException
	 */
	Instructor consultarInstructor(Instructor instructor) throws CoreServiceGeneralException;
	
	/**
	 * elimina el instructor indicado
	 * @param id
	 * @throws CoreServiceGeneralExce;
	 * ption
	 */
	void eliminarInstructor(Long id) throws CoreServiceGeneralException;
}
