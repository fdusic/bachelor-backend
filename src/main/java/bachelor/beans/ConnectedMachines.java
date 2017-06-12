package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class ConnectedMachines implements Serializable{
	
	@Id
	@GeneratedValue
	private int idCM;
	
	
	@ManyToOne
	@JoinColumn(name="mt1", nullable=false)
	private MachineInTopology machineInTopology1;
	
	@ManyToOne
	@JoinColumn(name="mt2", nullable=false)
	private MachineInTopology machineInTopology2;
	
	
	@ManyToOne
	@JoinColumn(name="connectionType", nullable=false)
	private ConnectionType connectionType;


	public int getIdCM() {
		return idCM;
	}


	public void setIdCM(int idCM) {
		this.idCM = idCM;
	}


	public MachineInTopology getMachineInTopology1() {
		return machineInTopology1;
	}


	public void setMachineInTopology1(MachineInTopology machineInTopology1) {
		this.machineInTopology1 = machineInTopology1;
	}


	public MachineInTopology getMachineInTopology2() {
		return machineInTopology2;
	}


	public void setMachineInTopology2(MachineInTopology machineInTopology2) {
		this.machineInTopology2 = machineInTopology2;
	}


	public ConnectionType getConnectionType() {
		return connectionType;
	}


	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	
	

}
