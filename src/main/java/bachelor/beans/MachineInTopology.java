package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class MachineInTopology implements Serializable {

	@Id
	@GeneratedValue
	private int idMT;
	
	@JoinColumn(name = "topology", nullable = false)
	@ManyToOne
	private Topology topology;
	
	@JoinColumn(name = "machine", nullable = false)
	@ManyToOne
	private Machine machine;
	
	public MachineInTopology() {
	}

	public int getIdMT() {
		return idMT;
	}

	public void setIdMT(int idMT) {
		this.idMT = idMT;
	}

	public Topology getTopology() {
		return topology;
	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
}
