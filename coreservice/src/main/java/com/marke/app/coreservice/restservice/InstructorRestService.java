package com.marke.app.coreservice.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
public class InstructorRestService {
	@Autowired
	private InstructorService instructorService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response nuevoInstructor(Instructor instructor) {
		Instructor instructorGuardado = instructorService.guardarInstructor(instructor);
		InstructorResource instructorResource = new InstructorResource(instructorGuardado);
		return Response.ok(instructorResource).build();
	}
	
	@Path("/{idInstructor}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarInstructor(@PathParam("idInstructor") Long idInstructor, Instructor instructor){
		instructor.setIdInstructor(idInstructor);
		Instructor instructorActualizado = instructorService.actualizarInstructor(instructor);
		InstructorResource instructorResource = new InstructorResource(instructorActualizado);
		return Response.ok(instructorResource).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarInstructores(){
		List<InstructorResource>listaResources = new ArrayList<InstructorResource>();
		List<Instructor>listaInstructores = instructorService.consultarInstructores();
		for(Instructor i : listaInstructores){
			InstructorResource resource = new InstructorResource(i);
			listaResources.add(resource);
		}
		return Response.ok(listaResources).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarInstructor(@PathParam("id")Long idInstructor){
		Instructor instructor = new Instructor();
		instructor.setIdInstructor(idInstructor);
		instructor = instructorService.consultarInstructor(instructor);
		InstructorResource resource = new InstructorResource(instructor);
		return Response.ok(resource).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response eliminarInstructor(@PathParam("id")Long idInstructor){
		instructorService.eliminarInstructor(idInstructor);
		return Response.ok().build();
	}
}
