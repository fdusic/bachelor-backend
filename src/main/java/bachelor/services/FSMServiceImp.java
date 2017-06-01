package bachelor.services;

import org.springframework.beans.factory.annotation.Autowired;

import bachelor.beans.Facility;
import bachelor.beans.Section;
import bachelor.repositories.FacilityRepo;
import bachelor.repositories.SectionRepo;

@org.springframework.stereotype.Service
public class FSMServiceImp implements FSMService {

	@Autowired
	private FacilityRepo facilityRepo;
	
	@Autowired
	private SectionRepo sectionRepo;
	
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
}
