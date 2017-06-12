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
public class ConnectionType implements Serializable{
	
	
	@Id
	@GeneratedValue
	private int idCT;
	
	@Column(length = 30, nullable = false, unique=true)
	private String name;
	
	@Column(length = 100,nullable=true)
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="interface",nullable=false)
	private Interface iface;

	public int getIdCT() {
		return idCT;
	}

	public void setIdCT(int idCT) {
		this.idCT = idCT;
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

	public Interface getIface() {
		return iface;
	}

	public void setIface(Interface iface) {
		this.iface = iface;
	}
	
	
	

}
