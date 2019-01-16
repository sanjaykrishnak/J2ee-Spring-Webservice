package com.sanjay.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// To use this we go to use this url -http://localhost:8080/RestService-1.0/rest/hello/sanjay
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 
}