package com.marke.app.coreservice.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.marke.app.coreservice.resource.HealthCheck;

@Service
@Path("/admin")
public class RestAdminService {

	@GET
	@Path("/health-report")
	@Produces(MediaType.APPLICATION_JSON)
	public Response healthCheck() {
		System.out.println("Checking...");
		HealthCheck healthCheck = new HealthCheck("Ok", "The Application is running!");
		return Response.ok(healthCheck).build();
	}
}
