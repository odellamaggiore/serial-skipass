package ch.serial.game.skipass.domain.model;

import java.time.Instant;
import java.util.UUID;

public class SkiSession {

	private UUID idSession;
	private Instant startDate;
	private Instant endDate;
	private Long idResort;
	private Long idSkiPass;
	
	public SkiSession() {}
	
	public SkiSession(Instant startDate, Long idResort, Long idSkiPass) {
		this.idSession = UUID.randomUUID();
		this.startDate = startDate;
		this.idResort = idResort;
		this.idSkiPass = idSkiPass;
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

	public UUID getIdSession() {
		return idSession;
	}

	public void setIdSession(UUID idSession) {
		this.idSession = idSession;
	}

	public Long getIdSkiPass() {
		return idSkiPass;
	}

	public void setIdSkiPass(Long idSkiPass) {
		this.idSkiPass = idSkiPass;
	}
	
}
