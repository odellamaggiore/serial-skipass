package ch.serial.game.skipass.domain.service;

import ch.serial.game.skipass.domain.model.forfait.SkiSession;
import ch.serial.game.skipass.domain.model.forfait.SkiPass;

/**
 * Skipass / sessions Repository
 * @author odellamaggiore
 */
public interface SkiPassRepository {

	/**
	 * Updates existing skipass
	 * @param skipass pass
	 */
	void update(SkiPass skipass);
	
	/**
	 * Create or update session for a given skipass
	 * @param session session
	 */
	void saveSession(SkiSession session);
	
	/**
	 * Finds skipass by idSkipass
	 * @param idSkipass
	 * @return
	 */
	SkiPass getByIdSkipass(Long idSkipass);
	
}
