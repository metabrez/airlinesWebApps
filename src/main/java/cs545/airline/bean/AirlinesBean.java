package cs545.airline.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@ManagedBean
@SessionScoped
public class AirlinesBean {
	
	@Inject
	FlightService flightService;
	
	private List<Flight> flightList = new ArrayList<>();
	
	public List<Flight> getFlightList(){
		flightList = flightService.findAll();
		return flightList;
	}

}
