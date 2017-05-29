package com.marke.app.coreservice.dao;

import com.marke.app.coreservice.model.Instructor;

/**
 * Interfase para instructores.
 * @author visilva
 *
 */
public interface InstructorDao extends AbstractDao<Instructor, Long> {

	public static final String INSERT = "insert into instructor(name, color) values(?,?)";
	public static final String UPDATE = "";
	public static final String DELETE = "";
	public static final String SELECT_BY_ID = "";
	public static final String SELECT_ALL = "";
	
}