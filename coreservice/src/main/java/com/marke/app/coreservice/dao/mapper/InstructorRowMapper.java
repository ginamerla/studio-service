package com.marke.app.coreservice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.marke.app.coreservice.model.Instructor;

public class InstructorRowMapper implements RowMapper<Instructor>{

	@Override
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor instructor = new Instructor();
		instructor.setIdInstructor(rs.getLong("idinstructor"));
		instructor.setColor(rs.getString("color"));
		instructor.setName(rs.getString("name"));
		return instructor;
	}
	

}
