package com.marke.app.coreservice.resource;

import com.marke.app.coreservice.model.Equipment;

/**
 * Recurso que representa el modelo Equipo en la capa REST
 * @author gina
 *
 */
public class EquipmentResource {

	private Long idEquipment;
	private Long equipmentNumber;
	private String equipmentName;
	
	public EquipmentResource(Equipment equipment){
		this.idEquipment = equipment.getIdEquipment();
		this.equipmentNumber = equipment.getEquipmentNumber();
		this.equipmentName = equipment.getEquipmentName();
	}

	public Long getIdEquipment() {
		return idEquipment;
	}

	public void setIdEquipment(Long idEquipment) {
		this.idEquipment = idEquipment;
	}

	public Long getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(Long equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	
	
}
