package bachelor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bachelor.beans.Facility;
import bachelor.beans.Machine;
import bachelor.beans.Section;
import bachelor.repositories.FacilityRepo;
import bachelor.repositories.MachineRepo;
import bachelor.repositories.SectionRepo;

@org.springframework.stereotype.Service
public class FSMServiceImp implements FSMService {

	@Autowired
	private FacilityRepo facilityRepo;
	
	@Autowired
	private SectionRepo sectionRepo;
	
	@Autowired
	private MachineRepo machineRepo;
	
	public void createFacility(Facility f) {
		this.facilityRepo.save(f);
	}

	public void deleteFacility(int id) {
		this.facilityRepo.delete(id);
	}

	public void updateFacility(Facility f) {
		this.facilityRepo.save(f);
	}

	public Iterable<Facility> getFacilities() {
		return this.facilityRepo.findAll();
	}

	public void createSection(Section s) {
		this.sectionRepo.save(s);
	}

	public void deleteSection(int id) {
		this.sectionRepo.delete(id);
	}

	public void updateSection(Section s) {
		this.sectionRepo.save(s);
	}

	public Iterable<Section> getSections() {
		return this.sectionRepo.findAll();
	}

	public Facility getFacilityById(int idF) {
		List<Facility> facilities = this.facilityRepo.findFacilityByIdF(idF);
		return facilities.get(0);
	}

	public Section getSectionById(int idS) {
		List<Section> sections = this.sectionRepo.findSectionByIdS(idS);
		Section s = sections.get(0);
		System.out.println(s.getMachines().get(0).getName());
		return sections.get(0);
	}

	public Machine createMachine(Machine m) {
		return this.machineRepo.save(m);
	}
}
