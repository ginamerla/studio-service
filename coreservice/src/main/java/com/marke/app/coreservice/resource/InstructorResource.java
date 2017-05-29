package com.marke.app.coreservice.resource;

import com.marke.app.coreservice.model.Instructor;

/**
 * Recurso que representa el modelo Instructor en la capa de Rest.
 * @author visilva
 *
 */
public class InstructorResource {
	private Long idInstructor;
	private String name;
	private String color;
	
	public InstructorResource(Instructor model) {
		this.idInstructor = model.getIdInstructor();
		this.name = model.getName();
		this.color = model.getColor();
	}

	public Long getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(Long idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
