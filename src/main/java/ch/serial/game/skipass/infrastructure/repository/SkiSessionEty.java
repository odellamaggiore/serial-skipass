package ch.serial.game.skipass.infrastructure.repository;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "session")
public class SkiSessionEty {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private UUID id;
	
	@Column
	private UUID idSession;
	
	@Column
	private Instant startDate;
	
	@Column
	private Instant endDate;
	
	@Column
	private Long idResort;
	
	@ManyToOne
    @JoinColumn(name = "idSkiPass")
	private SkiPassEty skiPass;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Instant getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}
	
	public Instant getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}
	
	public Long getIdResort() {
		return idResort;
	}
	
	public void setIdResort(Long idResort) {
		this.idResort = idResort;
	}

	public SkiPassEty getSkiPass() {
		return skiPass;
	}

	public void setSkiPass(SkiPassEty skiPass) {
		this.skiPass = skiPass;
	}

	public UUID getIdSession() {
		return idSession;
	}

	public void setIdSession(UUID idSession) {
		this.idSession = idSession;
	}
	
}
