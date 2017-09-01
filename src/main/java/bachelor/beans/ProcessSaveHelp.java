package bachelor.beans;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ProcessSaveHelp implements Serializable{

	private Process process;
	private List<Step> steps;
	
	public ProcessSaveHelp() {
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
}
