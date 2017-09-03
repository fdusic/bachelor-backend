package bachelor.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bachelor.beans.ConnectedMachines;
import bachelor.beans.Topology;
import bachelor.beans.User;
import bachelor.repositories.ConnectedMachinesRepo;
import bachelor.services.TopologyService;

@RestController
@RequestMapping("/topology")
@CrossOrigin(origins = "http://localhost:4200")
public class TopologyController {

	@Autowired
	private TopologyService topologyService;
	
	@Autowired
	private ConnectedMachinesRepo connectedMachinesRepo;
	
	@RequestMapping(value = "/getTopologiesForSection", method = RequestMethod.POST)
	public List<Topology> getTopologiesForSection(@RequestBody String sectionId){
		return this.topologyService.getTopologiesForSection(Integer.parseInt(sectionId));
	}
	
	
	@RequestMapping(value = "/saveTopology", method = RequestMethod.POST)
	public Topology saveTopology(@RequestBody Topology topology, @Context HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		topology.setAuthor(user);
		return this.topologyService.saveTopology(topology);
	}
	
	@RequestMapping(value = "/saveConnectedMachines", method = RequestMethod.POST)
	public void saveConnectedMachines(@RequestBody ArrayList<ConnectedMachines> connectedMachines){
		this.connectedMachinesRepo.save(connectedMachines);
	}
	
}
