package bachelor.services;

import java.util.List;

import bachelor.beans.Topology;

public interface TopologyService {

	List<Topology> getTopologiesForSection(int sectionId);
	
	public Topology saveTopology(Topology topology);
	
	
}
