package bachelor.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bachelor.beans.ConnectionType;
import bachelor.beans.Facility;
import bachelor.beans.Interface;
import bachelor.beans.Machine;
import bachelor.beans.ReportFailure;
import bachelor.beans.Section;
import bachelor.beans.Topology;
import bachelor.beans.User;
import bachelor.repositories.ConnectionTypeRepo;
import bachelor.repositories.FacilityRepo;
import bachelor.repositories.FailureReportRepo;
import bachelor.repositories.InterfaceRepo;
import bachelor.repositories.MachineRepo;
import bachelor.repositories.SectionRepo;
import bachelor.repositories.TopologyRepo;
import bachelor.repositories.UserRepo;

@org.springframework.stereotype.Service
public class FSMServiceImp implements FSMService {

	@Autowired
	private FacilityRepo facilityRepo;
	
	@Autowired
	private SectionRepo sectionRepo;
	
	@Autowired
	private MachineRepo machineRepo;
	
	@Autowired
	private InterfaceRepo interfaceRepo;
	
	@Autowired
	private FailureReportRepo failureReportRepo;
	
	@Autowired
	private ConnectionTypeRepo connectionTypeRepo;
	
	@Autowired
	private TopologyRepo topologyRepo;
	
	@Autowired
	private UserRepo userRepo;
	
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
		return sections.get(0);
	}

	public Machine createMachine(Machine m) {
		return this.machineRepo.save(m);
	}

	public Iterable<Machine> getMachinesBySection(Section section) {
		return this.machineRepo.findBySection(section);
	}

	public Interface createInterface(Interface iface) {
		return this.interfaceRepo.save(iface);
	}

	public Iterable<Interface> getInterfaces() {
		return this.interfaceRepo.findAll();
	}

	public void machineSupportInterfaces(Machine machine) {
		this.machineRepo.save(machine);
	}

	public void deleteMachine(int id) {
		this.machineRepo.delete(id);
	}
	
	public Machine getMachineById(int idm) {
		List<Machine> list = this.machineRepo.findByIdM(idm);
		if(list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	public void createFailureReport(ReportFailure rf, User user) {
		rf.setEmployee(user);
		rf.setDateCreated(new Date());
		this.failureReportRepo.save(rf);
	}

	public List<ReportFailure> getFailureReports() {
		return this.failureReportRepo.findByExecuted(false);
	}

	public void fixed(ReportFailure rf, User user) {
		rf.setExecuted(true);
		rf.setRepairer(user);
		this.failureReportRepo.save(rf);
	}

	public List<Section> getSectionByFacility(Facility facility) {
		return this.sectionRepo.findByFacility(facility);
	}

	public ConnectionType createConnectionType(ConnectionType ct) {
		return this.connectionTypeRepo.save(ct);
	}

	public Iterable<ConnectionType> getConnectionTypes() {
		return this.connectionTypeRepo.findAll();
	}

	public Topology createTopology(Topology t) {
		List<User> users = this.userRepo.findByUsername("babs");
		User user = users.get(0);
		t.setAuthor(user);
		return this.topologyRepo.save(t);
	}
}
