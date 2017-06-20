package com.marke.app.coreservice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.marke.app.coreservice.model.Equipment;

public class EquipmentRowMapper implements RowMapper<Equipment>{

	@Override
	public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Equipment equipment = new Equipment();
		equipment.setIdEquipment(rs.getLong("idequipment"));
		equipment.setEquipmentNumber(rs.getLong("equipmentnumber"));
		equipment.setEquipmentName(rs.getString("name"));
		return equipment;
	}

}
