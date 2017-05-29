package com.marke.app.coreservice.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class ApiExceptionMapper implements ExceptionMapper<Exception>{

	public Response toResponse(Exception exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception).type(MediaType.APPLICATION_JSON).build();
	}

}
