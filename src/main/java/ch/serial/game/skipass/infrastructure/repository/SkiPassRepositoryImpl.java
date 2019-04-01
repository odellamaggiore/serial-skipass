package ch.serial.game.skipass.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ch.serial.game.skipass.domain.model.SkiPass;
import ch.serial.game.skipass.domain.model.SkiSession;
import ch.serial.game.skipass.domain.service.SkiPassRepository;

@Repository
public class SkiPassRepositoryImpl implements SkiPassRepository {
	
	@Inject
	SkiPassMapper skipassMapper; 

	@Inject
	SkiSessionMapper sessionMapper; 
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void update(final SkiPass pass) {
		
		SkiPassEty passEty = findSkiPassByIdSkiPass(pass.getIdSkiPass());
		
		passEty.setOwnerLastName(pass.getOwnerLastName());
		passEty.setOwnerFirstName(pass.getOwnerFirstName());
		
	}
	
	@Override
	public SkiPass getByIdSkipass(final Long idSkipass) {
		return skipassMapper.fromSkiPassEty(findSkiPassByIdSkiPass(idSkipass));
	}
	
	@Override
	public void saveSession(final SkiSession session) {
		
		Optional<SkiSessionEty> optSession = findSessionByIdSession(session.getIdSession());
		if(optSession.isPresent()) {
			optSession.get().setEndDate(session.getEndDate());
		} else {
			SkiPassEty pass = findSkiPassByIdSkiPass(session.getIdSkiPass());
			SkiSessionEty s = sessionMapper.toSessionEty(session);
			s.setSkiPass(pass);
			entityManager.persist(s);
		}
	}
	
	private SkiPassEty findSkiPassByIdSkiPass(final Long idSkiPass) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SkiPassEty> criteria = builder.createQuery(SkiPassEty.class);
		
		Root<SkiPassEty> root = criteria.from(SkiPassEty.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("idSkiPass"), idSkiPass) );
		
		return entityManager.createQuery( criteria ).getSingleResult();
		
	}
	
	private Optional<SkiSessionEty> findSessionByIdSession(final UUID idSession) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SkiSessionEty> criteria = builder.createQuery(SkiSessionEty.class);
		
		Root<SkiSessionEty> root = criteria.from(SkiSessionEty.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("idSession"), idSession) );
		try {
			return Optional.of(entityManager.createQuery( criteria ).getSingleResult());
		}
		catch(NoResultException nre) {
			return Optional.empty();
		}
		
	}
	
}
