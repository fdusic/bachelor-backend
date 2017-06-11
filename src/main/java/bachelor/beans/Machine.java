package bachelor.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class Machine implements Serializable {

	@Id
	@GeneratedValue
	private int idM;
	
	@Column(length = 100)
	private String image;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "section", nullable = false, referencedColumnName = "idS",foreignKey = @ForeignKey(name="fk_machine_section"))
	private Section section;
	
	public Machine() {
	}

	public int getIdM() {
		return idM;
	}

	public void setIdM(int idM) {
		this.idM = idM;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
