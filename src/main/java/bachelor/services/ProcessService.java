package bachelor.services;

import java.util.List;

import bachelor.beans.Process;
import bachelor.beans.Topology;


public interface ProcessService {
	
	public List<Process> getProcessesForSection(int sectionId);
	public Topology getTopologyById(int topologyId);
}
