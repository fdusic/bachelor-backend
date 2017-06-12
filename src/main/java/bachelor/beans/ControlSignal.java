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
public class ControlSignal implements Serializable{
	
	@Id
	@GeneratedValue
	private int idCS;
	
	@Column(length = 100, nullable = false)
	private String operation;
	
	@ManyToOne
	@JoinColumn(name="step",nullable=false)
	private Step step;

	public int getIdCS() {
		return idCS;
	}

	public void setIdCS(int idCS) {
		this.idCS = idCS;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}
	
	

}
