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

import com.marke.app.coreservice.model.Role;
import com.marke.app.coreservice.resource.RoleResource;
import com.marke.app.coreservice.service.RoleService;

@Service
@Path("/roles")
public class RoleRestService {

	@Autowired
	private RoleService roleService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRoles(){
		List<Role>rolesList = new ArrayList<Role>();
		rolesList = roleService.getAllRoles();
		List<RoleResource> resourceList = new ArrayList<RoleResource>();
		for(Role r:rolesList){
			RoleResource resource = new RoleResource(r);
			resourceList.add(resource);
		}
		return Response.ok(resourceList).build();
	}
	
	@GET
	@Path("/{idRole}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRole(@PathParam("idRole")Long idRole){
		Role role = new Role();
		role.setIdRole(idRole);
		role = roleService.getRole(role);
		RoleResource resource = new RoleResource(role);
		return Response.ok(resource).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRole(Role role){
		Role roleCreated = roleService.createRole(role);
		RoleResource resource = new RoleResource(roleCreated);
		return Response.ok(resource).build();
	}
	
	@PUT
	@Path("/{idRole}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRole(@PathParam("idRole")Long idRole,Role role){
		role.setIdRole(idRole);
		Role updatedRole = roleService.updateRole(role);
		RoleResource resource = new RoleResource(updatedRole);
		return Response.ok(resource).build();
	}
	
	@DELETE
	@Path("/{idRole}")
	public Response deleteRole(@PathParam("idRole")Long idRole){
		roleService.deleteRole(idRole);
		return Response.ok().build();
	}
}
