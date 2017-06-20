package com.marke.app.coreservice.dao;

import com.marke.app.coreservice.model.Role;

/**
 * Interface para Role
 * @author gina
 *
 */
public interface RoleDao extends AbstractDao<Role, Long>{

	public static final String SELECT_ALL = "select * from role";
	public static final String SELECT_BY_ID = "select * from role where idrole = ?";
	public static final String INSERT = "insert into role (rolename) values (?)";
	public static final String UPDATE = "update role set rolename = ? where idrole = ?";
	public static final String DELETE = "delete from role where idrole = ?";
	
}
