package bachelor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bachelor.beans.Topology;
import bachelor.services.TopologyService;

@RestController
@RequestMapping("/topology")
@CrossOrigin(origins = "http://localhost:4200")
public class TopologyController {

	@Autowired
	private TopologyService topologyService;
	
	@RequestMapping(value = "/getTopologiesForSection", method = RequestMethod.POST)
	public List<Topology> getTopologiesForSection(@RequestBody String sectionId){
		return this.topologyService.getTopologiesForSection(Integer.parseInt(sectionId));
	}
}
