package com.marke.app.coreservice.resource;

import com.marke.app.coreservice.model.Role;

/**
 * Recurso que representa el modelo ROL en la capa REST
 * @author gina
 *
 */
public class RoleResource {
	
	private Long idRole;
	private String roleName;
	
	public RoleResource(Role role){
		this.idRole = role.getIdRole();
		this.roleName = role.getRoleName();
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
