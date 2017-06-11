package bachelor.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class MachineInTopology implements Serializable{
	
	
	@Id
	@GeneratedValue
	private int idMT;
	
	@Column(nullable = false)
	private Float x;
	
	
	@Column(nullable = false)
	private Float y;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="machine",nullable=false)
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name="topology", nullable=false)
	private Topology topology;
	
	@ManyToMany
	@JoinTable(name="connectedMachines",joinColumns =
            @JoinColumn(name = "mt1", referencedColumnName = "idMT"),
        inverseJoinColumns =
            @JoinColumn(name = "mt2", referencedColumnName = "idMT"))
	private List<MachineInTopology> connectedMachines;

	public int getIdMT() {
		return idMT;
	}

	public void setIdMT(int idMT) {
		this.idMT = idMT;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Topology getTopology() {
		return topology;
	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}
	
	

}
