package com.marke.app.coreservice.restservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marke.app.coreservice.model.Instructor;
import com.marke.app.coreservice.resource.InstructorResource;
import com.marke.app.coreservice.service.InstructorService;

@Service
@Path("/instructores")
public class RestInstructorService {
	@Autowired
	private InstructorService instructorService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response nuevoInstructor(Instructor instructor) {
		Instructor instructorGuardado = instructorService.guardarInstructor(instructor);
		InstructorResource instructorResource = new InstructorResource(instructorGuardado);
		return Response.ok(instructorResource).build();
	}
}
