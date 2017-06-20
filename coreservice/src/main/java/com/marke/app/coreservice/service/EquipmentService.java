package com.marke.app.coreservice.service;

import java.util.List;

import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Equipment;

public interface EquipmentService {

	Equipment createEquipment (Equipment equipment)throws CoreServiceGeneralException;
	Equipment updateEquipment (Equipment equipment)throws CoreServiceGeneralException;
	List<Equipment>getAllequipments();
	Equipment getEquipment (Equipment equipment)throws CoreServiceGeneralException;
	void deleteEquipment(Long id)throws CoreServiceGeneralException;
}
