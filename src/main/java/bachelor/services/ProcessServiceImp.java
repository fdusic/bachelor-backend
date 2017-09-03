package bachelor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bachelor.beans.ConnectedMachines;
import bachelor.beans.Link;
import bachelor.beans.Machine;
import bachelor.beans.Process;
import bachelor.beans.ProcessSaveHelp;
import bachelor.beans.Section;
import bachelor.beans.Step;
import bachelor.beans.Topology;
import bachelor.repositories.ConnectedMachinesRepo;
import bachelor.repositories.LinkRepo;
import bachelor.repositories.ProcessRepo;
import bachelor.repositories.StepRepo;
import bachelor.repositories.TopologyRepo;

@Service
public class ProcessServiceImp implements ProcessService {

	@Autowired
	private ProcessRepo processRepo;
	
	@Autowired
	private TopologyRepo topologyRepo;
	
	@Autowired
	private StepRepo stepRepo;
	
	@Autowired
	private LinkRepo linkRepo;
	
	@Autowired
	private ConnectedMachinesRepo connectedMachinesRepo;
	
	public List<Process> getProcessesForSection(int sectionId) {

		List<Process> ret = new ArrayList<Process>();
		
		Section s = new Section();
		s.setIdS(sectionId);
		
		ArrayList<Topology> tops = (ArrayList<Topology>) this.topologyRepo.findBySection(s);
		
		for(Topology t : tops){
			ArrayList<Process> ps = (ArrayList<Process>) this.processRepo.findByTopology(t);
			for(Process p : ps){
				ret.add(p);
			}
		}
		
		return ret;
	}

	public Topology getTopologyById(int topologyId) {
		return this.topologyRepo.findOne(topologyId);
	}

	public List<Step> getImportSteps(ArrayList<Machine> machines) {
		List<Step> ret = new ArrayList<Step>();
		
		for(Machine m : machines) {
			List<Step> temp = this.stepRepo.findByMachine(m);
			for(Step s : temp) {
				ret.add(s);
			}
		}
		
		return ret;
	}

	public ProcessSaveHelp saveProcessAndSteps(Process process) {
		List<Step> ret = new ArrayList<Step>();
		for(Step step : process.getSteps()) {
			Step s = this.stepRepo.save(step);
			ret.add(s);
		}
		
		Process p = this.processRepo.save(process);
		
		ProcessSaveHelp psh = new ProcessSaveHelp();
		psh.setProcess(p);
		psh.setSteps(ret);
		
		return psh;
	}

	public void saveLinks(ArrayList<Link> links) {
		for(Link l : links) {
			this.linkRepo.save(l);
		}
	}

	public List<Link> getLinksForProcess(Process p) {
		return this.linkRepo.findByProcess(p);
	}

	public List<ConnectedMachines> getMachineConnections(String topologyId) {
		Topology t = new Topology();
		t.setIdT(Integer.parseInt(topologyId));
		
		return this.connectedMachinesRepo.findByTopology(t);
	}

}
