package bachelor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bachelor.beans.Section;
import bachelor.beans.Topology;
import bachelor.repositories.TopologyRepo;

@Service
public class TopologyServiceImp implements TopologyService {
	
	@Autowired
	private TopologyRepo topologyRepo;
	
	public List<Topology> getTopologiesForSection(int sectionId) {
		Section s = new Section();
		s.setIdS(sectionId);
		return this.topologyRepo.findBySection(s);
	}

	public Topology saveTopology(Topology topology) {
		return this.topologyRepo.save(topology);
	}

}
