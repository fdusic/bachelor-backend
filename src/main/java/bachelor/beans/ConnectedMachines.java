package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ConnectedMachines implements Serializable{

	@Id
	@GeneratedValue
	private int idCM;
	
	@JoinColumn(name = "machine1")
	@ManyToOne 
	private Machine machine1;
	
	@JoinColumn(name = "machine2")
	@ManyToOne 
	private Machine machine2;
	
	@JoinColumn(name = "connectionType")
	@ManyToOne
	private ConnectionType connectionType;
	
	@JoinColumn(name = "interface")
	@ManyToOne
	private Interface iface;
	
	@JoinColumn(name = "topology")
	@ManyToOne
	private Topology topology;
	
	public ConnectedMachines() {
	}

	public int getIdCM() {
		return idCM;
	}

	public void setIdCM(int idCM) {
		this.idCM = idCM;
	}

	public Machine getMachine1() {
		return machine1;
	}

	public void setMachine1(Machine machine1) {
		this.machine1 = machine1;
	}

	public Machine getMachine2() {
		return machine2;
	}

	public void setMachine2(Machine machine2) {
		this.machine2 = machine2;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public Interface getIface() {
		return iface;
	}

	public void setIface(Interface iface) {
		this.iface = iface;
	}

	public Topology getTopology() {
		return topology;
	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}
	
	
}
