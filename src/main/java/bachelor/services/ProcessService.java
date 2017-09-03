package bachelor.services;

import java.util.ArrayList;
import java.util.List;

import bachelor.beans.ConnectedMachines;
import bachelor.beans.Link;
import bachelor.beans.Machine;
import bachelor.beans.Process;
import bachelor.beans.ProcessSaveHelp;
import bachelor.beans.Step;
import bachelor.beans.Topology;


public interface ProcessService {
	
	public List<Process> getProcessesForSection(int sectionId);
	public Topology getTopologyById(int topologyId);
	public List<Step> getImportSteps(ArrayList<Machine> machines);
	public ProcessSaveHelp saveProcessAndSteps(Process process);
	public void saveLinks(ArrayList<Link> links);
	public List<Link> getLinksForProcess(Process p);
	public List<ConnectedMachines> getMachineConnections(String topologyId);
	
}
