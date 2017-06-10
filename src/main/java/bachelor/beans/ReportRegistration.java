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
public class ReportRegistration implements Serializable{

	@Id
	@GeneratedValue
	private int idRR;
	
	@ManyToOne
	@JoinColumn(name = "idM")
	private User manager;
	
	@ManyToOne
	@JoinColumn(name = "idA")
	private User admin;

	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false, length = 30)
	private String surname;
	
	@Column(nullable = false, length = 50)
	private String address;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 30)
	private String phone;
	
	@Column(nullable = false, length = 40)
	private String password;
	
	@Column(nullable = false)
	private User.Proffesion proffesion;
	
	@Column
	private boolean executed = false;
	
	public ReportRegistration() {
	}

	public int getIdRR() {
		return idRR;
	}

	public void setIdRR(int idRR) {
		this.idRR = idRR;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User.Proffesion getProffesion() {
		return proffesion;
	}

	public void setProffesion(User.Proffesion proffesion) {
		this.proffesion = proffesion;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ReportRegistration [idRR=" + idRR + ", manager=" + manager
				+ ", admin=" + admin + ", name=" + name + ", surname="
				+ surname + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + ", proffesion=" + proffesion
				+ ", executed=" + executed + "]";
	}
}
