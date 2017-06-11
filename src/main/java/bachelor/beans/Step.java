package bachelor.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
@SuppressWarnings("serial")
public class Step implements Serializable{

	@Id
	@GeneratedValue
	private int idStep;
	
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(length = 30, nullable = false)
	private String duration;
	
	@ManyToOne
	@JoinColumn(name="machineInTopology",nullable=false)
	private MachineInTopology machineInTopology;
	
	@ManyToMany
	private List<Process> processes;

	public int getIdStep() {
		return idStep;
	}

	public void setIdStep(int idStep) {
		this.idStep = idStep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public MachineInTopology getMachineInTopology() {
		return machineInTopology;
	}

	public void setMachineInTopology(MachineInTopology machineInTopology) {
		this.machineInTopology = machineInTopology;
	}

	public List<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}
	
	
	
	
}
