package com.sanjay.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import org.json.JSONObject;




@Path("/animals")
public class AnimalsResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	AnimalService animalService;

	public AnimalsResource() {
		System.out.println("AnimalsResource()");
		animalService = new AnimalService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Animal> getAnimals() {
		System.out.println("1.AnimalsResource:getAnimals():->******************************************************");
		System.out.println(animalService.getAnimalAsList());
		System.out.println("2.AnimalsResource:getAnimals():->******************************************************");
		return animalService.getAnimalAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Animal> getAnimalsAsHtml() {
		System.out.println("getAnimalsAsHtml()");
		return animalService.getAnimalAsList();
	}

	// URI: /rest/animals/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(animalService.getAnimalsCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createAnimal(@FormParam("id") String id,
			@FormParam("animalname") String name,
			@FormParam("animaltype") String type,
			@Context HttpServletResponse servletResponse) throws IOException {
		Animal animal = new Animal(id, name, type);
		animalService.createAnimal(animal);
		servletResponse.sendRedirect("./animals/");
	}
	
	// URI: http://localhost:8080/RestService-1.0/rest/animals/1 { It will get the animal that is preloaded}
	@Path("{animal}")
	public AnimalResource getAnimal(@PathParam("animal") String id) 
	{
		System.out.println("3.AnimalsResource:getAnimal():->******************************************************");
		return new AnimalResource(uriInfo, request, id);
	}
	
	@GET
    @Path("testJson")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject testJson() throws Exception {

		//Animal myjson = new Animal();
		JSONObject myjson = new JSONObject();
 
        myjson.put("success", "1");
        myjson.put("name","foo");
        myjson.put("num",new Integer(100));
        myjson.put("balance",new Double(1000.21));
        myjson.put("is_vip",new Boolean(true));
        //myjson.put("nickname",null);
		
	/*	myjson.setId("1");
		myjson.setName("Sanjay");
		myjson.setType("Student");*/
		
        
        System.out.println("=================================");
        System.out.println("JSON object = " + myjson.toString());
        System.out.println("=================================");


        System.out.println(myjson.toString());

//        return "string returned";
        return myjson;
    }
	
	//http://localhost:8080/RestService-1.0/rest/animals/testJsonAnimal
	
	@GET
    @Path("testJsonAnimal")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal testJsonAnimal() throws Exception {

		Animal myjson = new Animal();
		myjson.setId("1");
		myjson.setName("Sanjay");
		myjson.setType("Student");
		
        
        System.out.println("=================================");
        System.out.println("JSON object = " + myjson.toString());
        System.out.println("=================================");


        System.out.println(myjson.toString());

//        return "string returned";
        return myjson;
    }

}