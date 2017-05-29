package com.marke.app.coreservice.dao;

import java.util.List;

import com.marke.app.coreservice.exception.CoreServiceGeneralException;

/**
 * Interfase maestra
 * @author visilva
 *
 * @param <T> Modelo a manipular en la base de datos
 * @param <K> Llave o identificador unico de la entidad en juego.
 */
public interface AbstractDao<T, K> {

	/**
	 * Crea un nuevo instructor.
	 * @param instructor
	 * @throws CoreServiceGeneralException
	 */
	void crearEntidad(T modelo) throws CoreServiceGeneralException;
	
	/**
	 * Actualiza los datos de instructor
	 * @param instructor
	 * @throws CoreServiceGeneralException
	 */
	void actualizarEntidad(T modelo) throws CoreServiceGeneralException;
	
	/**
	 * Eliminar instructor.
	 * @param idInstructor
	 * @throws CoreServiceGeneralException
	 */
	void eliminarEntidad(K identificador) throws CoreServiceGeneralException;
	
	/**
	 * Consultar instructor
	 * @param instructor
	 * @return
	 * @throws CoreServiceGeneralException
	 */
	T consultarEntidad(T modelo) throws CoreServiceGeneralException;
	
	/**
	 * Obtener todos los instructores.
	 * @return
	 * @throws CoreServiceGeneralException
	 */
	List<T> consultarEntidades() throws CoreServiceGeneralException;
}
