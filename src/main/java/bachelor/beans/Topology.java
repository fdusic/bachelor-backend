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
public class Topology implements Serializable{
	
	@Id
	@GeneratedValue
	private int idT;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(nullable = false)
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="section", nullable = false)
	private Section section;
	
	@ManyToOne
	@JoinColumn(name="author", nullable=false)
	private User author;
	
	@ManyToMany
	@JoinTable(name = "machineInTopology", joinColumns = @JoinColumn(name = "topology", referencedColumnName = "idT"), 
												inverseJoinColumns = @JoinColumn(name = "machine", referencedColumnName = "idM"))
	private List<Machine> machines;

	public int getIdT() {
		return idT;
	}


	public void setIdT(int idT) {
		this.idT = idT;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public List<Machine> getMachines() {
		return machines;
	}


	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

}
