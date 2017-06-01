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
	@JoinColumn(name = "idK", nullable = false)
	private User user;
	
	@Column
	private boolean executed = false;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
}
