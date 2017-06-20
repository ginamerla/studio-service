package com.marke.app.coreservice.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marke.app.coreservice.dao.RoleDao;
import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Role;
import com.marke.app.coreservice.service.RoleService;

/**
 * Capa de servicios para Rol
 * @author gina
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role createRole(Role role) throws CoreServiceGeneralException {
		if(role==null){
			throw new CoreServiceGeneralException("Datos invalidos - El rol es nulo");
		}
		if(StringUtils.isBlank(role.getRoleName())){
			throw new CoreServiceGeneralException("Datos invalidos - El nombre del rol es nulo o vacio");
		}
		roleDao.crearEntidad(role);
		return role;
	}

	@Override
	public Role updateRole(Role role) throws CoreServiceGeneralException {
		if(role == null){
			throw new CoreServiceGeneralException("Datos invalidos - El rol es nulo");
		}
		if(role.getIdRole()==null){
			throw new CoreServiceGeneralException("Datos invalidos - El id es nulo");
		}
		if(StringUtils.isBlank(role.getRoleName())){
			throw new CoreServiceGeneralException("Datos invalidos - El nombre es nulo o vacio");
		}
		roleDao.actualizarEntidad(role);
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role>roleList = roleDao.consultarEntidades();
		return roleList;
	}

	@Override
	public Role getRole(Role role) throws CoreServiceGeneralException {
		if(role == null){
			throw new CoreServiceGeneralException("Datos invalidos - El rol es nulo");
		}
		if(role.getIdRole()==null){
			throw new CoreServiceGeneralException("Datos invalidos - El id del rol es nulo");
		}
		return roleDao.consultarEntidad(role);
	}

	@Override
	public void deleteRole(Long idRole) throws CoreServiceGeneralException {
		if(idRole==null){
			throw new CoreServiceGeneralException("Datos invalidos - El id del rol es nulo");
		}
		roleDao.eliminarEntidad(idRole);
	}

}
