package bachelor.controllers;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bachelor.beans.Facility;
import bachelor.beans.Machine;
import bachelor.beans.Section;
import bachelor.services.FSMService;

// POM - postrojenje, odeljenje, masine

@RestController
@RequestMapping("/fsm")
@CrossOrigin
public class FSMController {

	@Autowired
	private FSMService fsmService;
	
	@RequestMapping(value = "/createFacility", method = RequestMethod.POST)
	public void createFacility(@RequestBody Facility f){
		this.fsmService.createFacility(f);
	}
	
	@RequestMapping(value = "/deleteFacility", method = RequestMethod.POST)
	public void deleteFacility(@RequestBody int id){
		this.fsmService.deleteFacility(id);
	}
	
	@RequestMapping(value = "/updateFacility", method = RequestMethod.POST)
	public void updateFacility(@RequestBody Facility f){
		this.fsmService.updateFacility(f);
	}
	
	@RequestMapping(value = "/getFacilities", method = RequestMethod.GET)
	public Iterable<Facility> getFacilities(){
		return this.fsmService.getFacilities();
	}
	
	@RequestMapping(value = "/getFacilityById", method = RequestMethod.POST)
	public Facility getFacilityById(@RequestBody int idF){
		return this.fsmService.getFacilityById(idF);
	}
	
	
	@RequestMapping(value = "/createSection", method = RequestMethod.POST)
	public void createSection(@RequestBody Section s){
		this.fsmService.createSection(s);
	}
	
	@RequestMapping(value = "/deleteSection", method = RequestMethod.POST)
	public void deleteSection(@RequestBody int id){
		this.fsmService.deleteSection(id);
	}
	
	@RequestMapping(value = "/updateSection", method = RequestMethod.POST)
	public void updateSection(@RequestBody Section s){
		this.fsmService.updateSection(s);
	}
	
	@RequestMapping(value = "/getSections", method = RequestMethod.GET)
	public Iterable<Section> getSections(){
		return this.fsmService.getSections();
	}
	
	@RequestMapping(value = "/getSectionById", method = RequestMethod.POST)
	public Section getSectionById(@RequestBody int idS){
		return this.fsmService.getSectionById(idS);
	}
	
	
	@RequestMapping(value = "/createMachine", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA)
	public void createMachine(@RequestParam("image") MultipartFile file, @RequestParam("name") String name, @RequestParam("section") String idS, @RequestParam("description") String description) throws IOException{
		
		Machine machine = new Machine();
		Section section = this.fsmService.getSectionById(Integer.parseInt(idS));
		machine.setSection(section);
		machine.setName(name);
		machine.setDescription(description);
		machine.setImage(file.getOriginalFilename());
		
		machine = this.fsmService.createMachine(machine);
		
		System.out.println(section.getMachines().size());
		
		String saveImageName = machine.getIdM() + file.getOriginalFilename();
		String imagePath = new java.io.File(".").getCanonicalPath()+File.separator+".."+File.separator+"bachelor-frontend/src/images/" + saveImageName;
		
		
		file.transferTo(new File(imagePath));
	}
	
	
	
	
}
