package bachelor.services;

import bachelor.beans.Facility;
import bachelor.beans.Machine;
import bachelor.beans.Section;

public interface FSMService {

	public void createFacility(Facility f);
	public void deleteFacility(int id);
	public void updateFacility(Facility f);
	public Iterable<Facility> getFacilities();
	
	public void createSection(Section s);
	public void deleteSection(int id);
	public void updateSection(Section s);
	public Iterable<Section> getSections();
	
	public Facility getFacilityById(int idF);
	public Section getSectionById(int idS);
	
	
	public Machine createMachine(Machine m);
	
}
