package com.marke.app.coreservice.service;

import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Instructor;

public interface InstructorService {

	/**
	 * Registra un nuevo instructor.
	 * @param instructor
	 * @return
	 * @throws CoreServiceGeneralException
	 */
	Instructor guardarInstructor(Instructor instructor) throws CoreServiceGeneralException;
}
