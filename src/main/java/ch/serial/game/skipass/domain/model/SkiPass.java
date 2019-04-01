package ch.serial.game.skipass.domain.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import ch.serial.game.skipass.domain.service.SkiPassRepository;

public class SkiPass {

	@Inject
	SkiPassRepository repository;
	
	private Long idSkiPass;
	private String ownerLastName;
	private String ownerFirstName;
	private List<SkiSession> sessions = new ArrayList<>();
	
	public Long getIdSkiPass() {
		return idSkiPass;
	}

	public void setIdSkiPass(Long id) {
		this.idSkiPass = id;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String lastName) {
		this.ownerLastName = lastName;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String firstName) {
		this.ownerFirstName = firstName;
	}

	public List<SkiSession> getSessions() {
		return sessions;
	}

	public void setSessions(List<SkiSession> sessions) {
		this.sessions = sessions;
	}
	
	public List<SkiSession> startSession(Long idResort) {

		List<SkiSession> updatedSessions = new ArrayList<>();
		
		if(hasOpenedSession(idResort)) {
			return updatedSessions;
		}

		if(hasOpenedSession()) {
			updatedSessions.addAll(stopSessions());
		}
		SkiSession s = new SkiSession(Instant.now(), idResort, this.idSkiPass);
		this.sessions.add(s);
		updatedSessions.add(s);
		
		return updatedSessions;
	}
	
	public List<SkiSession> stopSessions() {
		List<SkiSession> openedSessions = this.sessions.stream().filter(c -> c.getEndDate() == null).collect(Collectors.toList());
		openedSessions.forEach(c -> c.setEndDate(Instant.now()));
		return openedSessions;
	}
	
	public boolean hasOpenedSession(Long idResort) {
		return (this.sessions.stream().filter(s -> s.getIdResort().equals(idResort) && s.getEndDate() == null).count()) > 0;
	}
	
	public boolean hasOpenedSession() {
		return (this.sessions.stream().filter(s -> s.getEndDate() == null).count()) > 0;
	}
	
}
