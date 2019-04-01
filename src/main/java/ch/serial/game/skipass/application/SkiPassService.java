package ch.serial.game.skipass.application;

import ch.serial.game.skipass.domain.model.SkiPass;

/**
 * Skipass application service interface
 * @author odellamaggiore
 */
public interface SkiPassService {

	/**
	 * Starts a session for a skipass / resort
	 * @param idSkipass skipass id
	 * @param idResort resort id
	 */
	public void startSession(Long idSkipass, Long idResort);
	
	/**
	 * Stops all opened sessions for a skipass
	 * @param idSkipass skipass id
	 */
	public void stopSessions(Long idSkipass);
	
	/**
	 * Find skipass information by skipass id
	 * @param idSkipass
	 * @return
	 */
	public SkiPass getSkipass(Long idSkipass);
	
}
