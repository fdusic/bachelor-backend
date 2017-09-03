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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bachelor.beans.ConnectedMachines;
import bachelor.beans.Link;
import bachelor.beans.Machine;
import bachelor.beans.Process;
import bachelor.beans.ProcessSaveHelp;
import bachelor.beans.Step;
import bachelor.beans.Topology;
import bachelor.beans.User;
import bachelor.services.ProcessService;

@RestController
@RequestMapping("/process")
@CrossOrigin(origins = "http://localhost:4200")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	
	@RequestMapping(value = "/getProcessesForSection", method = RequestMethod.POST)
	public List<Process> getProcessesForSection(@RequestBody String sectionId){
		return this.processService.getProcessesForSection(Integer.parseInt(sectionId));
	}
	
	@RequestMapping(value = "/getTopologyById", method = RequestMethod.POST)
	public Topology getTopologyById(@RequestBody String topologyId) {
		return this.processService.getTopologyById(Integer.parseInt(topologyId));
	}
	
	@RequestMapping(value = "/getImportSteps", method = RequestMethod.POST)
	public List<Step> getImportSteps(@RequestBody ArrayList<Machine> machines){
		return this.processService.getImportSteps(machines);
	}
	
	@RequestMapping(value = "/saveProcessAndSteps", method = RequestMethod.POST)
	public ProcessSaveHelp saveProcessAndSteps(@RequestBody Process process, @Context HttpServletRequest request) {
		process.setAuthor(((User) request.getSession().getAttribute("user")));
		process.setVersion(1.0f);
		return this.processService.saveProcessAndSteps(process);
	}
	
	@RequestMapping(value = "/saveLinks", method = RequestMethod.POST)
	public void saveLinks(@RequestBody ArrayList<Link> links) {
		this.processService.saveLinks(links);
	}
	
	@RequestMapping(value = "/getLinksForProcess", method = RequestMethod.POST)
	public List<Link> getLinksForProcess(@RequestBody Process process) {
		return this.processService.getLinksForProcess(process);
	}
	
	@RequestMapping(value = "/getMachineConnections", method = RequestMethod.GET)
	public List<ConnectedMachines> getMachineConnections(@RequestParam(name="topology") String topologyId) {
		return this.processService.getMachineConnections(topologyId);
	}
}
