package com.marke.app.coreservice.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marke.app.coreservice.dao.EquipmentDao;
import com.marke.app.coreservice.exception.CoreServiceGeneralException;
import com.marke.app.coreservice.model.Equipment;
import com.marke.app.coreservice.service.EquipmentService;

/**
 * Capa de servicios - Equipment Service
 * 
 * @author gina
 *
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentDao equipmentDao;

	@Override
	public Equipment createEquipment(Equipment equipment)throws CoreServiceGeneralException {
		if(equipment == null){
			throw new CoreServiceGeneralException("Datos invalidos - El equipo es nulo");
		}
		if(StringUtils.isBlank(equipment.getEquipmentName())){
			throw new CoreServiceGeneralException("Datos invalidos - El nombre esta vacio");
		}
		equipmentDao.crearEntidad(equipment);
		return equipment;
	}

	@Override
	public Equipment updateEquipment(Equipment equipment) throws CoreServiceGeneralException {
		if(equipment == null){
			throw new CoreServiceGeneralException("Datos invalidos - El equipo es nulo");
		}
		if(equipment.getIdEquipment() == null){
			throw new CoreServiceGeneralException("Datos invalidos - El id es nulo");
		}
		if(equipment.getEquipmentNumber() == null){
			throw new CoreServiceGeneralException("Datos invalidos - El numero es nulo");
		}
		if(StringUtils.isBlank(equipment.getEquipmentName())){
			throw new CoreServiceGeneralException("Datos invalidos - El nombre no fue proporcionado o es nulo");
		}
		equipmentDao.actualizarEntidad(equipment);
		return equipment;
	}

	@Override
	public List<Equipment> getAllequipments() {
		List<Equipment>equipmentList = equipmentDao.consultarEntidades();
		return equipmentList;
	}

	@Override
	public Equipment getEquipment(Equipment equipment) throws CoreServiceGeneralException {
		if(equipment == null){
			throw new CoreServiceGeneralException("Datos invalidos - El equipo es nulo");
		}
		if(equipment.getIdEquipment()==null){
			throw new CoreServiceGeneralException("Datos invalidos - El id es nulo");
		}
		
		return equipmentDao.consultarEntidad(equipment);
	}

	@Override
	public void deleteEquipment(Long id) throws CoreServiceGeneralException {
		if(id==null){
			throw new CoreServiceGeneralException("Datos invalidos - el id es nulo");
		}
		equipmentDao.eliminarEntidad(id);

	}

}
