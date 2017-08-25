package bachelor.services;

import java.util.List;

import bachelor.beans.ConnectionType;
import bachelor.beans.Facility;
import bachelor.beans.Interface;
import bachelor.beans.Machine;
import bachelor.beans.ReportFailure;
import bachelor.beans.Section;
import bachelor.beans.Topology;
import bachelor.beans.User;

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
	public Iterable<Machine> getMachinesBySection(Section section);
	
	public Interface createInterface(Interface iface);
	public Iterable<Interface> getInterfaces();
	
	public void machineSupportInterfaces(Machine machine);
	public void deleteMachine(int id);
	
	public Machine getMachineById(int idM);
	
	public void createFailureReport(ReportFailure rf, User user);
	public List<ReportFailure> getFailureReports();
	public void fixed(ReportFailure rf, User user);
	
	public List<Section> getSectionByFacility(Facility facility);
	public ConnectionType createConnectionType(ConnectionType ct);
	public Iterable<ConnectionType> getConnectionTypes();
	public Topology createTopology(Topology t);
	
}
