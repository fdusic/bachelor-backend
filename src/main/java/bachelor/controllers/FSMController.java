package bachelor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bachelor.beans.Facility;
import bachelor.beans.Section;
import bachelor.services.FSMService;

// POM - postrojenje, odeljenje, masine

@RestController
@RequestMapping("/fsm")
@CrossOrigin
public class FSMController {

	@Autowired
	private FSMService pomService;
	
	@RequestMapping(value = "/createFacility", method = RequestMethod.POST)
	public void createFacility(@RequestBody Facility f){
		this.pomService.createFacility(f);
	}
	
	@RequestMapping(value = "/deleteFacility", method = RequestMethod.POST)
	public void deleteFacility(@RequestParam int id){
		this.pomService.deleteFacility(id);
	}
	
	@RequestMapping(value = "/updateFacility", method = RequestMethod.POST)
	public void updateFacility(@RequestBody Facility f){
		this.pomService.updateFacility(f);
	}
	
	@RequestMapping(value = "/getFacilities", method = RequestMethod.GET)
	public Iterable<Facility> getFacilities(){
		return this.pomService.getFacilities();
	}
	
	@RequestMapping(value = "/createSection", method = RequestMethod.POST)
	public void createSection(@RequestBody Section s){
		this.pomService.createSection(s);
	}
	
	@RequestMapping(value = "/deleteSection", method = RequestMethod.POST)
	public void deleteSection(@RequestParam int id){
		this.pomService.deleteSection(id);
	}
	
	@RequestMapping(value = "/updateSection", method = RequestMethod.POST)
	public void updateSection(@RequestBody Section s){
		this.pomService.updateSection(s);
	}
	
	@RequestMapping(value = "/getSections", method = RequestMethod.GET)
	public Iterable<Section> getSections(){
		return this.pomService.getSections();
	}
	
	
}
