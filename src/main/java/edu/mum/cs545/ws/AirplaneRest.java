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
import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

@Named
@Path("airplane")
public class AirplaneRest {

	@Inject
	private AirplaneService airplaneService;
	
	/*@GET
	public String helloWorld(@DefaultValue("From AirplaneRest Controller") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}
	*/

	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Airplane airplane) {
		airplaneService.create(airplane);
		return Response.status(201).entity(airplane).build();

	}

	@Path("delete")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(Airplane airplane) {
		airplaneService.delete(airplane);
		return Response.status(204).build();

	}

	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Airplane airplane) {
		Airplane airp = airplaneService.update(airplane);
		return Response.status(201).entity(airp).build();

	}

	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response find(Airplane airplane) {
		Airplane airp = airplaneService.find(airplane);
		if(airp!=null){
			
			return Response.status(200).entity(airp).build();
			
		}
		
		return Response.status(404).build();

	}

	@Path("{serialno}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBySrlnr(@PathParam("serialno") String serialno) {
		Airplane a = airplaneService.findBySrlnr(serialno);
		if (a == null) {
			return Response.status(404).build();
		}
		return Response.status(200).entity(a).build();

	}

	@Path("flight/{flight}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Airplane> findByFlight(@PathParam("flight") int flight) {
		List<Airplane> a = new ArrayList<>();
		Flight f = new Flight();
		f.setId(flight);
		a = airplaneService.findByFlight(f);
		return a;
	}
/*
	@Path("/flight/{model}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByModel(@PathParam("model") String model) {
		List<Airplane> a = airplaneService.findByModel(model);
		return Response.status(200).entity(a).build();

	}*/
	
	@Path("flight/model/{name}")
	@GET
	public List<Airplane> getAirPlaneByModel(@PathParam("name")String model) {
		return airplaneService.findByModel(model);
	}



	@Path("list")
	@GET
	public List<Airplane> getAllAirplanes() {
		List<Airplane> airplane = new ArrayList<>();
		if (airplaneService.findAll() != null) {
			airplane = airplaneService.findAll();
		}
		return airplane;
	}

}
