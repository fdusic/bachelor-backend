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
public class Process implements Serializable{
	
	@Id
	@GeneratedValue
	private int idP;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Float version;
	
	@ManyToOne
	@JoinColumn(name="topology",nullable=false)
	private Topology topology;
	
	@ManyToOne
	@JoinColumn(name="author",nullable=false)
	private User author;
	
	@ManyToMany
	@JoinColumn(name="process", nullable = false)
	private List<Step> steps;

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
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

	public Float getVersion() {
		return version;
	}

	public void setVersion(Float version) {
		this.version = version;
	}

	public Topology getTopology() {
		return topology;
	}

	public void setTopology(Topology topology) {
		this.topology = topology;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
