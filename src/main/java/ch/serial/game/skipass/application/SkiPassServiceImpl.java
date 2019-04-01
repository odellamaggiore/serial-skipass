package ch.serial.game.skipass.application;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.serial.game.skipass.domain.model.SkiPass;
import ch.serial.game.skipass.domain.model.SkiSession;
import ch.serial.game.skipass.domain.service.SkiPassRepository;

@Service
public class SkiPassServiceImpl implements SkiPassService {

	@Inject
	SkiPassRepository repository;
	
	@Override
	@Transactional
	public void startSession(final Long idSkipass, final Long idResort) {
		SkiPass p = getSkipass(idSkipass);
		List<SkiSession> updatedSessions = p.startSession(idResort);
		updatedSessions.forEach(c -> repository.saveSession(c));
	}
	
	@Override
	@Transactional
	public void stopSessions(final Long idSkipass) {
		SkiPass f = getSkipass(idSkipass);
		List<SkiSession> closedSessions = f.stopSessions();
		closedSessions.forEach(c -> repository.saveSession(c));
	}

	@Override
	public SkiPass getSkipass(final Long idSkipass) {
		return repository.getByIdSkipass(idSkipass);
	}
}
