package edu.mum.cs545.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Path("airline")
public class AirlineRest {
	
	
	@Inject
	private AirlineService airlineService;

	@Path("list")
	@GET
	public List<Airline> getAllAirLines() {
		List<Airline> a = new ArrayList<>();
		if (airlineService.findAll() != null) {
			a = airlineService.findAll();
		}
		return a;
	}

	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Airline airport) {

		
		airlineService.create(airport);
		return Response.status(201).entity(airport).build();

	}

	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Airline airport) {

		airlineService.update(airport);

		return Response.status(201).entity(airport).build();

	}

	@Path("findAirport")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(Airline airport) {
		Airline airline=airlineService.find(airport);
		return Response.status(200).entity(airline).build();
	}

	@Path("{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByName(@PathParam("name") String name) {
		Airline a = airlineService.findByName(name);
		if (a == null) {
			return Response.status(404).build();
		}
		return Response.status(200).entity(a).build();

	}

	
	@Path("flight/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airline> findByFlight(@PathParam("id") int id) {
		List<Airline> a = new ArrayList<>();
		Flight f= new Flight();
		f.setId(id);
		a = airlineService.findByFlight(f);
	
		
		return a;

	}

	@Path("{name}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)

	public Response delete(@PathParam("name") String name) {
		Airline a = airlineService.findByName(name);
		if (a != null) {
			airlineService.delete(a);

		}

		return Response.status(200).build();

	}
}
