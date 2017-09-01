package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Link implements Serializable {

	@Id
	@GeneratedValue
	private int idL;
	
	@ManyToOne
	private Step from;
	
	@ManyToOne
	private Step to;
	
	@ManyToOne
	private Process process;
	
	public Link() {
	}

	public int getIdL() {
		return idL;
	}

	public void setIdL(int idL) {
		this.idL = idL;
	}

	public Step getFrom() {
		return from;
	}

	public void setFrom(Step from) {
		this.from = from;
	}

	public Step getTo() {
		return to;
	}

	public void setTo(Step to) {
		this.to = to;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
}
