package bachelor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bachelor.beans.Process;
import bachelor.beans.Section;
import bachelor.beans.Topology;
import bachelor.repositories.ProcessRepo;
import bachelor.repositories.TopologyRepo;

@Service
public class ProcessServiceImp implements ProcessService {

	@Autowired
	private ProcessRepo processRepo;
	
	@Autowired
	private TopologyRepo topologyRepo;
	
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

}
