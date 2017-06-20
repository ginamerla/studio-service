package com.marke.app.coreservice.dao;

import com.marke.app.coreservice.model.Instructor;

/**
 * Interfase para instructores.
 * @author visilva
 *
 */
public interface InstructorDao extends AbstractDao<Instructor, Long> {

	public static final String INSERT = "insert into instructor(name, color) values(?,?)";
	public static final String UPDATE = "update instructor set name = ?, color = ? where idinstructor = ?";
	public static final String DELETE = "delete from instructor where idinstructor = ?";
	public static final String SELECT_BY_ID = "select * from instructor where idinstructor = ?";
	public static final String SELECT_ALL = "select * from instructor";
	
}