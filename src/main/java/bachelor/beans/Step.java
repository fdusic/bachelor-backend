package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@SuppressWarnings("serial")
public class Step implements Serializable{

	@Id
	@GeneratedValue
	private int idStep;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(length = 30, nullable = false)
	private String color;
	
	@ManyToOne
	@JoinColumn(name="machine", nullable=false)
	private Machine machine;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
}
