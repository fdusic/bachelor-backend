package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private int idU;
	
	@Column(unique = true, nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 30)
	private String password;
	
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
	
	
	@ManyToOne
	@JoinColumn(name="facility", nullable = true)
	private Facility facility;
	
	public enum Proffesion{
		USER, EMPLOYEE, MANAGER, EXPERT, ADMIN, REPAIRER
	}
	
	@Column(nullable = false)
	private Proffesion proffesion;
	
	public User() {
	}

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Proffesion getProffesion() {
		return proffesion;
	}

	public void setProffesion(Proffesion proffesion) {
		this.proffesion = proffesion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [idU=" + idU + ", username=" + username + ", password="
				+ password + ", name=" + name + ", surname=" + surname
				+ ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", proffesion=" + proffesion + "]";
	}
}
