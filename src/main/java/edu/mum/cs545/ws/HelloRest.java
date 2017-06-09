package edu.mum.cs545.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}

	@Path("airline")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		Airline airline = airlineService.findByName("oneworld");
		if (airline != null) {
			result = "This is an airline: " + airline.getName();
		}
		return result;
	}
	
	@Path("airline/list")
	@GET
	public List<Airline> getAllAirLines() {
		List<Airline> a = new ArrayList<>();
		if (airlineService.findAll() != null) {
			a = airlineService.findAll();
		}
		return a;
	

	}

}



