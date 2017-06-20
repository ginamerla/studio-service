package com.marke.app.coreservice.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marke.app.coreservice.model.Equipment;
import com.marke.app.coreservice.resource.EquipmentResource;
import com.marke.app.coreservice.service.EquipmentService;

@Service
@Path("/equipos")
public class EquipmentRestService {

	@Autowired
	private EquipmentService equipmentService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEquipment(Equipment equipment){
		Equipment equipmentSaved = equipmentService.createEquipment(equipment);
		EquipmentResource resource = new EquipmentResource(equipmentSaved);
		return Response.ok(resource).build();
	}
	
	@PUT
	@Path("/{idEquipment}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEquipment(@PathParam("idEquipment")Long id, Equipment e){
		e.setIdEquipment(id);
		Equipment equipmentUpdated = equipmentService.updateEquipment(e);
		EquipmentResource resource = new EquipmentResource(equipmentUpdated);
		return Response.ok(resource).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEquipments(){
		List<Equipment>equipmentList = new ArrayList<Equipment>();
		equipmentList = equipmentService.getAllequipments();
		List<EquipmentResource>equipmentResourceList = new ArrayList<EquipmentResource>();
		for(Equipment e:equipmentList){
			EquipmentResource equipmentResource= new EquipmentResource(e);
			equipmentResourceList.add(equipmentResource);
		}
		return Response.ok(equipmentResourceList).build();
	}
	
	@GET
	@Path("/{idEquipment}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEquipment(@PathParam("idEquipment")Long idEquipment){
		Equipment equipment = new Equipment();
		equipment.setIdEquipment(idEquipment);
		equipment = equipmentService.getEquipment(equipment);
		EquipmentResource resource = new EquipmentResource(equipment);
		return Response.ok(resource).build();
	}
	
	@DELETE
	@Path("/{idEquipment}")
	public Response deleteEquipment(@PathParam("idEquipment")Long idEquipment){
		equipmentService.deleteEquipment(idEquipment);
		return Response.ok().build();
	}
}
