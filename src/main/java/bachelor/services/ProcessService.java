package bachelor.services;

import java.util.List;

import bachelor.beans.Process;


public interface ProcessService {
	
	List<Process> getProcessesForSection(int sectionId);
}
