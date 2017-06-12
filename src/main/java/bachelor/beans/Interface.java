package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Interface implements Serializable{
	
	
	@Id
	@GeneratedValue
	private int idI;
	
	@Column(length = 30, nullable = false, unique=true)
	private String name;
	
	@Column(length = 100,nullable=true)
	private String description;

	public int getIdI() {
		return idI;
	}

	public void setIdI(int idI) {
		this.idI = idI;
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
	
	

}
