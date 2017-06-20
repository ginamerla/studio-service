package com.marke.app.coreservice.service;

import java.util.List;

import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Role;

public interface RoleService {
	
	Role createRole(Role role) throws CoreServiceGeneralException;
	Role updateRole(Role role) throws CoreServiceGeneralException;
	List<Role> getAllRoles();
	Role getRole(Role role) throws CoreServiceGeneralException;
	void deleteRole(Long idRole) throws CoreServiceGeneralException;

}
