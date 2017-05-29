package com.marke.app.coreservice.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.marke.app.coreservice.dao.InstructorDao;
import com.marke.app.coreservice.model.Instructor;

@RunWith(MockitoJUnitRunner.class)
public class InstructorDaoImplTest {
	@InjectMocks
	private InstructorDaoImpl dao;
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testCrearInstructor(){
		Instructor instructor = new Instructor();
		instructor.setColor("Blanco");
		instructor.setName("Papol");
		Mockito.when(jdbcTemplate.update(Mockito.eq(InstructorDao.INSERT), Mockito.anyObject())).thenReturn(1);
		dao.crearEntidad(instructor);
	}
}
