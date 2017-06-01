package bachelor.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("serial")
public class Facility implements Serializable{
	
	@Id
	@GeneratedValue
	private int idF;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String address;
	
	@Column(nullable = false)
	private Double surface;
	
	@OneToMany(mappedBy = "facility")
	private List<Section> sections;
	
	public Facility() {
	}

	public int getIdF() {
		return idF;
	}

	public void setIdF(int idF) {
		this.idF = idF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSurface() {
		return surface;
	}

	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
}
