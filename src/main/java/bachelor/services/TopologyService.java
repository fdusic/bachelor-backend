package bachelor.services;

import java.util.List;

import bachelor.beans.ConnectedMachines;
import bachelor.beans.Topology;

public interface TopologyService {

	public List<Topology> getTopologiesForSection(int sectionId);
	
	public Topology saveTopology(Topology topology);
	
	
	
}
