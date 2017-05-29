package com.marke.app.coreservice.model;

public class Instructor {
	private Long idInstructor;
	private String name;
	private String color;
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
