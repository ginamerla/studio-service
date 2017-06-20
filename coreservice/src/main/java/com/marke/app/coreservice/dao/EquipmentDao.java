package com.marke.app.coreservice.dao;

import com.marke.app.coreservice.model.Equipment;

/**
 * Interface para Equipment
 * @author gina
 *
 */
public interface EquipmentDao extends AbstractDao<Equipment, Long>{

	public static final String INSERT = "insert into equipment(equipmentnumber, name) values (?,?)";
	public static final String UPDATE = "update equipment set  equipmentnumber = ?, name = ? where idequipment = ?";
	public static final String SELECT_BY_ID = "select * from equipment where idequipment = ?";
	public static final String SELECT_ALL = "select * from equipment";
	public static final String DELETE = "delete from equipment where idequipment = ?";
}
