package bachelor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bachelor.beans.Process;
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
	
}
