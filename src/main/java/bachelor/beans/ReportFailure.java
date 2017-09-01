package bachelor.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class ReportFailure implements Serializable{

	@Id
	@GeneratedValue
	private int idRF;
	
	@Column(nullable = false)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name = "idM", nullable = false)
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name = "idE", nullable = false)
	private User employee;
	
	
	//PROVERITI OVO
	@ManyToOne
	@JoinColumn(name = "idR", nullable = true)
	private User repairer;
	
	@Column
	private boolean executed = false;
	
	@Column(length = 100)
	private String error;
	
	public ReportFailure() {
	}

	public int getIdRF() {
		return idRF;
	}

	public void setIdRF(int idRF) {
		this.idRF = idRF;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public User getRepairer() {
		return repairer;
	}

	public void setRepairer(User repairer) {
		this.repairer = repairer;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ReportFailure [idRF=" + idRF + ", dateCreated=" + dateCreated
				+ ", machine=" + machine + ", employee=" + employee
				+ ", repairer=" + repairer + ", executed=" + executed
				+ ", error=" + error + "]";
	}
}
