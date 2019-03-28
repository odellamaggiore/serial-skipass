package ch.serial.game.skipass.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "skipass")
public class SkiPassEty {
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private UUID id;

	@Column
	private Long idSkiPass;
	
	@Column
	private String ownerLastName;
	
	@Column
	private String ownerFirstName;
	
    @OneToMany(mappedBy = "skiPass")
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<SkiSessionEty> sessions = new ArrayList<>();
	
	public SkiPassEty() {
		this.sessions = new ArrayList<>();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getIdSkiPass() {
		return idSkiPass;
	}


	public void setIdSkiPass(Long idSkiPass) {
		this.idSkiPass = idSkiPass;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public List<SkiSessionEty> getSessions() {
		if(sessions == null) {
			sessions = new ArrayList<>();
		}
		return sessions;
	}

}
